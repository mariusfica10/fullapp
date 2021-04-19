package ro.msg.learning.shop.controller.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private int orderID;
    private int locationID;
    private int customerID;
    private LocalDateTime date;
    private String countryAdress;
    private String cityAdress;
    private String countyAdress;
    private String streetAdress;
}
