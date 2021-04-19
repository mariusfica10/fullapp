package ro.msg.learning.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.repository.OrderDetailRepository;

import ro.msg.learning.shop.controller.converter.*;
import ro.msg.learning.shop.controller.dto.*;
import ro.msg.learning.shop.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("OrderDetailService")
@RequiredArgsConstructor
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private Converter<OrderDetail, OrderDetailDTO> orderConverter;
    Logger logger = LoggerFactory.getLogger(OrderDetailService.class);


    public List<OrderDetailDTO> getOrderDetails()
    {
        logger.info("gettin the order details for http");
        List<OrderDetail> list = orderDetailRepository.findAll();
        List<OrderDetailDTO> listOutput = new ArrayList<OrderDetailDTO>();
        for(OrderDetail obj : list)
        {
            OrderDetailDTO object = orderConverter.convert(obj);
            object.setId(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }
    
    public List<OrderDetailDTO> getDetailsForOrder(int id)
    {
        logger.info("getting details for a order check");
        List<OrderDetail> list = orderDetailRepository.findForOrder(id);
        List<OrderDetailDTO> listOutput = new ArrayList<OrderDetailDTO>();
        for(OrderDetail obj : list)
        {
            OrderDetailDTO object = orderConverter.convert(obj);
            object.setId(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }
    

    public OrderDetail getOrderDetail(OrderDetailId id)
    {
        logger.info("get an order detail");
        return orderDetailRepository.getOne(id);
    }

    public OrderDetailDTO getOrderDetailByID(OrderDetailId id)
    {
        logger.info("get order detail for http");
        Optional<OrderDetail> object = orderDetailRepository.findById(id);
        if(object.isPresent())
        {
            logger.info("found");
            OrderDetailDTO obj = orderConverter.convert(object.get());
            obj.setId(object.get().getId());
            return obj;
        }
        logger.info("not found");
        return null;
    }

    public void saveOrderDetail(OrderDetailDTO orderDetailDTO)
    {
        logger.info("save order detail");
        OrderDetail object = orderConverter.reverse(orderDetailDTO);
        object.setId(new OrderDetailId(object.getOrder().getId(), object.getProduct().getId()));
        orderDetailRepository.save(object);
    }

}
