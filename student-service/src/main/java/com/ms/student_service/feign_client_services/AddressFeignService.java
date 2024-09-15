package com.ms.student_service.feign_client_services;

import com.ms.student_service.dto.AddressDto;
import com.ms.student_service.microserviceInterface.AddressFeignClient;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AddressFeignService {

    private static final Logger log =  Logger.getLogger(AddressFeignService.class.getName());

    @Autowired
    AddressFeignClient addressFeignClient;
    int count =0;
    int fallbackCount=0;

    @CircuitBreaker(name = "address-service", fallbackMethod = "fallbackMethod")
    public AddressDto getStudentAddress(long studentId) {
        System.out.println("count : "+ ++count);
        AddressDto addressDto = new AddressDto();
        try{
            addressDto = addressFeignClient.findAddressByStudentId(studentId);
        }
        catch (FeignException ex){
            log.info("Feign Exception : "+ ex.getMessage());
        }
        catch (RuntimeException ex){
            log.info("Runtime exception : "+ex.getMessage());
        }
        return addressDto;
    }

    public AddressDto fallbackMethod(long studentId){//, Throwable th){
        //log.info("Circuit Breaker triggered for studentId {}: {}"+ studentId+ th.getMessage());
        System.out.println("fallbackCount : "+ ++fallbackCount);
        //log.info("Circuit Breaker is working : Error due to -> "+th.getMessage());
        return new AddressDto();
    }
}