package ro.msg.learning.shop.controller.converter;

import java.util.Random;

import org.springframework.stereotype.Component;

import ro.msg.learning.shop.controller.dto.SupplierDTO;
import ro.msg.learning.shop.model.Supplier;

@Component
public class SupplierConverter implements Converter<Supplier, SupplierDTO>{

    @Override
    public SupplierDTO convert(Supplier obj) {
        return SupplierDTO.builder()
                .supplierID(new Random().nextInt())
                .name(obj.getName())
                .build();
    }

    @Override
    public Supplier reverse(SupplierDTO obj) {
        return Supplier.builder()
                .name(obj.getName())
                .build();
    }

}
