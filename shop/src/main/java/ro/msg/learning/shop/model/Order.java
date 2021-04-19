package ro.msg.learning.shop.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity(name = "order_ship")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_ship")
public class Order extends BaseEntity{
    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shipped_from")
    private Location location;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer")
    private Customer customer;
    @Column(name="date")
    private LocalDateTime date;
    @Column(name="adress_country")
    private String countryAdress;
    @Column(name="adress_city")
    private String cityAdress;
    @Column(name="adress_county")
    private String countyAdress;
    @Column(name="street_adress")
    private String streetAdress;
}
