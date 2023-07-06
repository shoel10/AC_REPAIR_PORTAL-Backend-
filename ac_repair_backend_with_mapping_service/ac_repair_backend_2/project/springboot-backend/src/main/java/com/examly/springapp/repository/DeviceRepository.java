package com.examly.springapp.repository;


import com.examly.springapp.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository <Device,Long> {
    //all curd database methods

}
