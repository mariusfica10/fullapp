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
public class RevenueDTO {
    private int revenueID;
    private int locationID;
    private LocalDateTime date;
    private int sum;
}
