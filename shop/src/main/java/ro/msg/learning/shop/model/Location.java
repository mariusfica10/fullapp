package ro.msg.learning.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity(name = "location")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location")
public class Location extends BaseEntity {

    @Column(name="name")
    private String name;
    @Column(name="adress_country")
    private String countryAdress;
    @Column(name="adress_city")
    private String cityAdress;
    @Column(name="adress_county")
    private String countyAdress;
    @Column(name="street_adress")
    private String streetAdress;

}
