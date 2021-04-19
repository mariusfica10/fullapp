package ro.msg.learning.shop.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.service.OrderService;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.controller.dto.*;

@Component
public class OrderDetailConverter implements Converter<OrderDetail, OrderDetailDTO>{

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Override
    public OrderDetailDTO convert(OrderDetail obj) {
        return OrderDetailDTO.builder()
            .id(obj.getId())
            .orderID(obj.getOrder().getId())
            .productID(obj.getProduct().getId())
            .quantity(obj.getQuantity())
            .build();
    }

    @Override
    public OrderDetail reverse(OrderDetailDTO obj) {
        return OrderDetail.builder()
            .id(obj.getId())
            .product(productService.getProduct(obj.getProductID()))
            .order(orderService.getOrder(obj.getOrderID()))
            .quantity(obj.getQuantity())
            .build();
    }
}
