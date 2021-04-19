package ro.msg.learning.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ro.msg.learning.shop.controller.dto.SupplierDTO;
import ro.msg.learning.shop.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.controller.converter.*;

import lombok.RequiredArgsConstructor;
import ro.msg.learning.shop.repository.SupplierRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("SupplierService")
@RequiredArgsConstructor
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private Converter<Supplier, SupplierDTO> converterSupplier;

    Logger logger = LoggerFactory.getLogger(SupplierService.class);

    //get all
    public List<SupplierDTO> getSuppliers()
    {
        logger.info("getting the suppliers for http");
        List<Supplier> list = supplierRepository.findAll();
        List<SupplierDTO> listOutput = new ArrayList<SupplierDTO>();
        for (Supplier obj : list) {
            SupplierDTO object = converterSupplier.convert(obj);
            object.setSupplierID(obj.getId());
            listOutput.add(object);
        }
        return listOutput;
    }

    //get
    public SupplierDTO getSupplierByID(int id)
    {
        logger.info("getting a supplier for http");
        Optional<Supplier> object = supplierRepository.findById(id);
        if(object.isPresent())
        {
            logger.info("found");
            SupplierDTO obj = converterSupplier.convert(object.get());
            obj.setSupplierID(object.get().getId());
            return obj;
            
        }
        logger.info("not found");
        return null;
    }

    //get
    public Supplier getSupplier(int id)
    {
        logger.info("getting a supplier");
        return supplierRepository.getOne(id);
    }

    //save
    public void saveSupplier(SupplierDTO object)
    {
        logger.info("saving a supplier");
        Supplier obj = converterSupplier.reverse(object);
        supplierRepository.save(obj);
    }



}
