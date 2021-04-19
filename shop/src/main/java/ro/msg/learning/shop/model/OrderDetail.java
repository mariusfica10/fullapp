package ro.msg.learning.shop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "order_detail")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_detail")
@Builder
public class OrderDetail implements Serializable{

    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("order")
    @JoinColumn(name = "order_ship")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("product")
    @JoinColumn(name = "product")
    private Product product;
    
    @Column(name="quantity")
    private Integer quantity;
}
