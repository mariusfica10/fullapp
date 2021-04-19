package ro.msg.learning.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.controller.converter.*;
import ro.msg.learning.shop.controller.dto.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("ProductCategoryService")
@RequiredArgsConstructor
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private Converter<ProductCategory, ProductCategoryDTO> converterProductCategory;

    Logger logger = LoggerFactory.getLogger(ProductCategoryService.class);

    //get all
    public List<ProductCategoryDTO> getProductCategories()
    {
        logger.info("getting the product categories for http");
        List<ProductCategory> list = productCategoryRepository.findAll();
        List<ProductCategoryDTO> listOutput = new ArrayList<ProductCategoryDTO>();
        for(ProductCategory obj: list)
        {
            ProductCategoryDTO object = converterProductCategory.convert(obj);
            object.setProductCategoryID(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }

    //get
    public ProductCategoryDTO getProductCategoryByID(Integer id)
    {
        logger.info("get a product category for http");
        Optional<ProductCategory> object = productCategoryRepository.findById(id);
        //mai tarziu validari
        if(object.isPresent())
        {
            logger.info("found");
            ProductCategoryDTO obj = converterProductCategory.convert(object.get());
            obj.setProductCategoryID(object.get().getId());
            return obj;
        }
        logger.info("not found");
        return null;
    }

    public ProductCategory getProductCategory(int id)
    {
        logger.info("getting a product category");
        return productCategoryRepository.getOne(id);
    }

    //save
    public void saveCategory(ProductCategoryDTO object)
    {
        logger.info("saved a product category");
        ProductCategory obj = converterProductCategory.reverse(object);
        productCategoryRepository.save(obj);
    }

}
