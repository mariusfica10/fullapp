package ro.msg.learning.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.msg.learning.shop.controller.dto.OrderDTO;
import ro.msg.learning.shop.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/orders", method = RequestMethod.GET)
    public List<OrderDTO> getOrders()
    {
        return orderService.getOrders();
    }

    //POST
    @RequestMapping(value="/orders/save", method= RequestMethod.POST)
    public void saveOrder(@RequestBody OrderDTO orderDTO)
    {
        orderService.makeOrder(orderDTO);
    }
}
