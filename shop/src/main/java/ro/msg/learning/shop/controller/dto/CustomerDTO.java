package ro.msg.learning.shop.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private int customerID;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;

}
