package ro.msg.learning.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.msg.learning.shop.service.ProductCategoryService;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.SupplierService;
import ro.msg.learning.shop.controller.dto.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    SupplierService supplierService;

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public List<ProductDTO> getProducts()
    {
        return productService.getProducts();
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public ProductDTO getProductByID(@PathVariable int id)
    {
        return productService.getProductByID(id);
    }

    //POST
    @RequestMapping(value="/products/save", method= RequestMethod.POST)
    public void saveProduct(@RequestBody ProductDTO productDTO)
    {
        productService.saveProduct(productDTO);
    }

}
