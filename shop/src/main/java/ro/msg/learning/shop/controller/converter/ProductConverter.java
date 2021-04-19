package ro.msg.learning.shop.controller.converter;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.msg.learning.shop.controller.dto.ProductDTO;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.ProductCategoryService;
import ro.msg.learning.shop.service.SupplierService;

@Component
public class ProductConverter implements Converter<Product, ProductDTO>{

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public ProductDTO convert(Product obj) {
        return ProductDTO.builder()
            .productID(new Random().nextInt())
            .name(obj.getName())
            .description(obj.getDescription())
            .price(obj.getPrice())
            .weight(obj.getWeight())
            .productCategory(obj.getCategory().getId())
            .supplier(obj.getSupplier().getId())
            .imageurl(obj.getImageurl())
            .build();
    }

    @Override
    public Product reverse(ProductDTO obj) {
        return Product.builder()
            .name(obj.getName())
            .description(obj.getDescription())
            .price(obj.getPrice())
            .weight(obj.getWeight())
            .category(productCategoryService.getProductCategory(obj.getProductCategory()))
            .supplier(supplierService.getSupplier(obj.getSupplier()))
            .imageurl(obj.getImageurl())
            .build();
    }


}
