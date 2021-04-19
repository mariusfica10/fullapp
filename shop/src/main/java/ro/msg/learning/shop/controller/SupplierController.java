package ro.msg.learning.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.msg.learning.shop.controller.dto.SupplierDTO;
import ro.msg.learning.shop.service.SupplierService;

@RestController
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @RequestMapping(value="/suppliers", method = RequestMethod.GET)
    public List<SupplierDTO> getSuppliers()
    {
        return supplierService.getSuppliers();
    }

    @RequestMapping(value="/suppliers/{id}", method = RequestMethod.GET)
    public SupplierDTO getSupplierByID(@PathVariable int id)
    {
        return supplierService.getSupplierByID(id);
    }

    //POST
    @RequestMapping(value="/suppliers/save", method= RequestMethod.POST)
    public void saveSupplier(@RequestBody SupplierDTO supplierDTO)
    {
        supplierService.saveSupplier(supplierDTO);
    }


}
