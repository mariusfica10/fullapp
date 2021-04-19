package ro.msg.learning.shop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class StockId implements Serializable {  
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "product")
    private Integer product;

    @Column(name = "location")
    private Integer location;
}