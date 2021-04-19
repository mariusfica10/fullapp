package ro.msg.learning.shop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private int productID;
    private String name;
    private String description;
    private Double price;
    private Double weight;
    private int productCategory;
    private int supplier;
    private String imageurl;
}