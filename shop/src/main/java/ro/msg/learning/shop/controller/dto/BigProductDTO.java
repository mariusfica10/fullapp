package ro.msg.learning.shop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BigProductDTO {
    private int bigProductID;
    private String name;
    private String description;
    private Double price;
    private Double weight;
    private int productCategory;
    private String nameCategory;
    private String descrptionCategory;
    private int supplier;
    private String imageurl;
}
