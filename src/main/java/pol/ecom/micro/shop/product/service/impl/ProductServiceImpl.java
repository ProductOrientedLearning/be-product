package pol.ecom.micro.shop.product.service.impl;
/*
 * This is course Microservice Product Oriented
 * MIT No Attribution

 * Copyright (c) 2023 <Dr.JohnLe & Mr.HaNguyen>

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import pol.ecom.micro.shop.lib.constant.MessageCode;
import pol.ecom.micro.shop.lib.dto.response.ProductDto;
import pol.ecom.micro.shop.lib.exception.ShopException;
import pol.ecom.micro.shop.lib.util.MessageUtil;
import pol.ecom.micro.shop.product.dto.request.ProductRequest;
import pol.ecom.micro.shop.product.entity.Product;
import pol.ecom.micro.shop.product.mapper.dto.ProductDtoMapper;
import pol.ecom.micro.shop.product.mapper.entity.ProductMapper;
import pol.ecom.micro.shop.product.repository.ProductRepository;
import pol.ecom.micro.shop.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDtoMapper productDtoMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MessageUtil messageUtil;

    @Transactional
    @Override
    public ProductDto createProduct(ProductRequest request) {
        Product product = productRepository.findBySku(request.getSku());
        if(!ObjectUtils.isEmpty(product)) {
            throw new ShopException(MessageCode.MESSAGE_DUPLICATE_PRODUCT.getCode(), messageUtil.getMessage(MessageCode.MESSAGE_DUPLICATE_PRODUCT));
        }
        return productDtoMapper.toDto(productRepository.save(productMapper.toEntity(request)));
    }

    @Override
    public ProductDto findById(long id) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public ProductDto findBySku(String sku) {
        return productDtoMapper.toDto(productRepository.findBySku(sku));
    }
}
