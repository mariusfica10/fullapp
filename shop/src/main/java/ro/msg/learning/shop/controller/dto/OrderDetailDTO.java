package ro.msg.learning.shop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.OrderDetailId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailDTO {
    private OrderDetailId id;
    private int orderID;
    private int productID;
    private int quantity;
}
