package ro.msg.learning.shop.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.StockRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MostAbundantStrategy implements LocationStrategy{

    @Autowired
    private StockRepository stockRepository;

    Logger logger = LoggerFactory.getLogger(MostAbundantStrategy.class);

    @Override
    public boolean getLocation(OrderDetail orderDetail) {
        logger.info("going into most abundant strategy");
        int idProduct = orderDetail.getProduct().getId();
        int quantity = orderDetail.getQuantity();
        int newQuantity = -1;
        Stock object = stockRepository.getMaxForProduct(idProduct);
        if(object.getQuantity() >= quantity)
        {
            newQuantity = object.getQuantity() - quantity;
            object.setQuantity(newQuantity);
            stockRepository.save(object);
            return true;
        }
        return false;
    }
    
}
