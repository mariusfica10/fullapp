package ro.msg.learning.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.msg.learning.shop.controller.dto.StockDTO;
import ro.msg.learning.shop.service.StockService;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @RequestMapping(value="/stocks", method = RequestMethod.GET)
    public List<StockDTO> getStocks()
    {
        return stockService.getStocks();
    }

    @RequestMapping(value="/stocks/product/{id}", method = RequestMethod.GET)
    public List<StockDTO> getStocksForProduct(@PathVariable int id)
    {
        return stockService.getStocksforProduct(id);
    }

    //POST
    @RequestMapping(value="/stocks/save", method= RequestMethod.POST)
    public void saveSupplier(@RequestBody StockDTO stockDTO)
    {
        stockService.saveStock(stockDTO);
    }

}
