package ro.msg.learning.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.controller.dto.ProductDTO;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.controller.converter.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("ProductService")
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Converter<Product, ProductDTO> converterProduct;

    Logger logger = LoggerFactory.getLogger(ProductService.class);


        //get all
        public List<ProductDTO> getProducts()
        {
            logger.info("getting the products for http");
            List<Product> list = productRepository.findAll();
            List<ProductDTO> listOutput = new ArrayList<ProductDTO>();
            for(Product obj : list)
            {
                ProductDTO object = converterProduct.convert(obj);
                object.setProductID(obj.getId());
                listOutput.add(object);
            }
            return listOutput;
        }
    
        //get
        public Product getProduct(int id)
        {
            logger.info("getting a product ");
            return productRepository.getOne(id);
        }
    
        //save
        public void saveProduct(ProductDTO object)
        {
            logger.info("saving a product");
            Product obj = converterProduct.reverse(object);
            productRepository.save(obj);
        }

        public ProductDTO getProductByID(int id) {
            logger.info("getting a product for http");
            Optional<Product> object = productRepository.findById(id);
            if(object.isPresent())
            {
                logger.info("found");
                ProductDTO obj = converterProduct.convert(object.get());
                obj.setProductID(object.get().getId());
                return obj;
            }
            logger.info("not found");
            return null;
        }

}
