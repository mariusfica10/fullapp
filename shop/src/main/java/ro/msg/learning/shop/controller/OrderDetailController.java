package ro.msg.learning.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.controller.dto.*;
import ro.msg.learning.shop.service.OrderDetailService;

@RestController
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value="/orderDetails", method = RequestMethod.GET)
    public List<OrderDetailDTO> getDetails()
    {
        return orderDetailService.getOrderDetails();
    }

    @RequestMapping(value="/orderDetails/order/{id}", method = RequestMethod.GET)
    public List<OrderDetailDTO> getDetails(@PathVariable int id)
    {
        return orderDetailService.getDetailsForOrder(id);
    }

    //POST
    @RequestMapping(value="/orderDetails/save", method= RequestMethod.POST)
    public void saveSupplier(@RequestBody OrderDetailDTO order)
    {
        orderDetailService.saveOrderDetail(order);
    }
}
