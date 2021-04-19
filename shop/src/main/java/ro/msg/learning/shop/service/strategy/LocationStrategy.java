package ro.msg.learning.shop.service.strategy;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.model.OrderDetail;

@Component
public interface LocationStrategy {
    boolean getLocation(OrderDetail orderDetail);
}
