package ro.msg.learning.shop.service.strategy;

import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleLocation implements LocationStrategy{

    @Autowired
    private StockRepository stockRepository;

    Logger logger = LoggerFactory.getLogger(SingleLocation.class);

    @Override
    public boolean getLocation(OrderDetail orderDetail) {
        int idProduct = orderDetail.getProduct().getId();
        int quantity = orderDetail.getQuantity();
        int newQuantity = -1;

        logger.info("going into single location strategy");

        for(Stock s: stockRepository.findAll())
        {
            if(s.getProduct().getId() == idProduct)
            {
                if(s.getQuantity() >= quantity)
                {
                    newQuantity = s.getQuantity()-quantity;
                    s.setQuantity(newQuantity);
                    stockRepository.save(s);
                    return true;
                }
            }
        }
        return false;
        
    }
        
    
}
