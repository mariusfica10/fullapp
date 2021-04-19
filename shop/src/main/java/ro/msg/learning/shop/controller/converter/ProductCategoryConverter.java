package ro.msg.learning.shop.controller.converter;

import java.util.Random;

import org.springframework.stereotype.Component;

import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.controller.dto.ProductCategoryDTO;

@Component
public class ProductCategoryConverter implements Converter<ProductCategory, ProductCategoryDTO>{

    @Override
    public ProductCategoryDTO convert(ProductCategory obj) {
        return ProductCategoryDTO.builder()
                .productCategoryID(new Random().nextInt())
                .name(obj.getName())
                .description(obj.getDescription())
                .build();
    }

    @Override
    public ProductCategory reverse(ProductCategoryDTO obj) {
        return ProductCategory.builder()
                .name(obj.getDescription())
                .description(obj.getName())
                .build();
    }

    
}
