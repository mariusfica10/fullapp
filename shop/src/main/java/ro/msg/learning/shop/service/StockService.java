package ro.msg.learning.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.controller.converter.*;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.controller.dto.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("StockService")
@RequiredArgsConstructor
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private Converter<Stock, StockDTO> converterStock;

    Logger logger = LoggerFactory.getLogger(StockService.class);

    public List<StockDTO> getStocks()
    {
        logger.info("getting the stocks");
        List<Stock> list = stockRepository.findAll();
        List<StockDTO> listOutput = new ArrayList<StockDTO>();
        for(Stock obj : list)
        {

            StockDTO object = converterStock.convert(obj);
            object.setId(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }

    public List<StockDTO> getStocksforProduct(int productID)
    {
        logger.info("getting the stocks for the product by id");
        List<Stock> list = stockRepository.findStocksForProduct(productID);
        List<StockDTO> listOutput = new ArrayList<StockDTO>();
        for(Stock obj : list)
        {
            StockDTO object = converterStock.convert(obj);
            object.setId(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }

    public Stock getStock(StockId id)
    {
        logger.info("getting a stock");
        return stockRepository.getOne(id);
    }

    public StockDTO getStockByID(StockId id)
    {
        logger.info("getting a stock for http");
        Optional<Stock> object = stockRepository.findById(id);
        if(object.isPresent())
        {
            logger.info("found");
            StockDTO obj = converterStock.convert(object.get());
            obj.setId(object.get().getId());
            return obj;
        }
        logger.info("not found");
        return null;
    }

    public Stock getMaxForProduct(int productID)
    {
        logger.info("getting the the product with the max quantity for a certian id");
        return stockRepository.getMaxForProduct(productID);
    }

    public void saveStock(StockDTO stockDTO)
    {
        logger.info("saving a stock");
        Stock object = converterStock.reverse(stockDTO);
        object.setId(new StockId(object.getProduct().getId(), object.getLocation().getId()));
        stockRepository.save(object);
    }

}
