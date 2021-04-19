package ro.msg.learning.shop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable {  
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "order_ship")
    private Integer order;

    @Column(name = "product")
    private Integer product;
}