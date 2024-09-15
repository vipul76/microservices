package com.ms.address_service.repository;

import com.ms.address_service.pojo.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query
    Address findAddressByStudentId(Long studentId);
}
