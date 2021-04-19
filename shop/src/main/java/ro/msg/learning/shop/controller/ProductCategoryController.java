package ro.msg.learning.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.msg.learning.shop.controller.dto.ProductCategoryDTO;
import ro.msg.learning.shop.service.ProductCategoryService;

@RestController
public class ProductCategoryController {
    
    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping(value = "/productCategories")
    public List<ProductCategoryDTO> getProductCategory()
    {
        //convertesc in dto toata lista
        //doar dto uri in controller
        //in service convertesc din dto in model
        // 
        return productCategoryService.getProductCategories();
    }

    @GetMapping(value="/productCategories/{id}")
    public ProductCategoryDTO getProductCategoryByID(@PathVariable Integer id)
    {
        return productCategoryService.getProductCategoryByID(id);
    }
    
    //POST
    @RequestMapping(value="/productCategories/save", method = RequestMethod.POST)
    public void saveCategory(@RequestBody ProductCategoryDTO productCategory)
    {
        productCategoryService.saveCategory(productCategory);
    }
}
