package com.ms.address_service.Controller;

import com.ms.address_service.pojo.Address;
import com.ms.address_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value="/{studentId}")
    public ResponseEntity<?> findAddressByStudentId(@PathVariable Long studentId){
        Address address = addressService.findAddressStudentId(studentId);
        return address!=null? new ResponseEntity<>(address, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
