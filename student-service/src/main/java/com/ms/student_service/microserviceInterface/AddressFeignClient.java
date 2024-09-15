package com.ms.student_service.microserviceInterface;

import com.ms.student_service.configuration.feignConf.FeignAddressConf;
import com.ms.student_service.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "address-service",url = "${address.service.url}")//,configuration = FeignAddressConf.class)
public interface AddressFeignClient {

    @GetMapping("/address/StudentId")
    AddressDto getAllStudentAddress();

    @GetMapping("/addresses/{studentId}")
    AddressDto findAddressByStudentId(@PathVariable("studentId") Long StudentId);
}
