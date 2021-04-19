package ro.msg.learning.shop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO {
    private StockId id;
    private int productID;
    private int locationID;
    private int quantity;
}
