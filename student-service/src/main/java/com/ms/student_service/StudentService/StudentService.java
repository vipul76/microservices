package com.ms.student_service.StudentService;

import com.ms.student_service.dto.AddressDto;
import com.ms.student_service.feign_client_services.AddressFeignService;
import com.ms.student_service.microserviceInterface.AddressFeignClient;
import com.ms.student_service.pojo.Student;
import com.ms.student_service.repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentService {

    private static final Logger log =  Logger.getLogger(StudentService.class.getName());
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressFeignService addressFeignService;

    List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        students = studentRepository.findAll();
        for(Student student : students){
            AddressDto address = addressFeignService.getStudentAddress(student.getId());
            System.out.println(address.toString());
            student.setAddress(address);
        }
        return students;
    }

}
