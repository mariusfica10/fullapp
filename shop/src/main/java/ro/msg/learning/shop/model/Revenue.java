package ro.msg.learning.shop.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity(name="revenue")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Revenue extends BaseEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="location")
    private Location location;
    @Column(name="date")
    private LocalDateTime date;
    @Column(name="sum")
    private Integer sum;
    
}
