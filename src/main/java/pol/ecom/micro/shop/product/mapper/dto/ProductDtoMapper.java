package pol.ecom.micro.shop.product.mapper.dto;
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


import org.springframework.stereotype.Component;
import pol.ecom.micro.shop.lib.dto.response.ProductDto;
import pol.ecom.micro.shop.lib.mapper.DtoMapper;
import pol.ecom.micro.shop.product.entity.Product;

import java.util.List;

@Component
public class ProductDtoMapper implements DtoMapper<Product, ProductDto> {
 @Override
 public ProductDto toDto(Product entity) {
  return ProductDto.builder()
          .id(entity.getId())
          .name(entity.getName())
          .sku(entity.getSku())
          .price(entity.getPrice())
          .build();
 }

 @Override
 public List<ProductDto> toListDto(List<Product> entities) {
  return null;
 }
}
