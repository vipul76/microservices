package com.ms.address_service.service;

import com.ms.address_service.pojo.Address;
import com.ms.address_service.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address findAddressStudentId(Long studentId) {

        return addressRepository.findAddressByStudentId(studentId);
    }
}
