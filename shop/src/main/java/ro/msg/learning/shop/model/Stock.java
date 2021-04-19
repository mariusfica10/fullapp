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

@Builder
@Data
@Entity(name = "stock")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="stock")
public class Stock implements Serializable{

    @EmbeddedId
    private StockId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("product")
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("location")
    @JoinColumn(name = "location")
    private Location location;
    
    @Column(name="quantity")
    private Integer quantity;

}
