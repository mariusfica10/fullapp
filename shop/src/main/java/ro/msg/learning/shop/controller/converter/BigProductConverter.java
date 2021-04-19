package ro.msg.learning.shop.controller.converter;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import ro.msg.learning.shop.controller.dto.BigProductDTO;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.service.ProductCategoryService;
import ro.msg.learning.shop.service.SupplierService;

public class BigProductConverter implements Converter<Product, BigProductDTO> {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public BigProductDTO convert(Product obj) {
        return BigProductDTO.builder()
            .bigProductID(new Random().nextInt())
            .name(obj.getName())
            .description(obj.getDescription())
            .price(obj.getPrice())
            .weight(obj.getWeight())
            .productCategory(obj.getCategory().getId())
            .nameCategory(obj.getCategory().getName())
            .descrptionCategory(obj.getCategory().getDescription())
            .supplier(obj.getSupplier().getId())
            .imageurl(obj.getImageurl())
            .build();
    }

    @Override
    public Product reverse(BigProductDTO obj) {
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