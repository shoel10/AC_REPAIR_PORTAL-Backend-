package com.examly.springapp.controller;

import com.examly.springapp.service.RepairService;
import com.examly.springapp.model.*;
import com.examly.springapp.repository.CustomerRepository;
import com.examly.springapp.repository.DeviceRepository;
import com.examly.springapp.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/repairs")
public class RepairController {
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private RepairService repairService;

//    @GetMapping
//    public List<Repair> getAllRepairs(){
//        return repairRepository.findAll();
//    }
    @GetMapping
    public List<Repair> getAllRepairs() {
        return repairService.getAllRepairs();
    }
    // build create employee REST API
//

//    @PostMapping
//    public ResponseEntity<Repair> createRepair(@RequestBody RepairRequest repairRequest) {
//        Repair repair = new Repair();
//        repair.setId(repairRequest.getId());
//        repair.setRepName(repairRequest.getRepName());
//
//        Customer customer = new Customer();
//        customer.setId(repairRequest.getCustomer().getId());
//        repair.setCustomer(customer);
//
//        List<Device> deviceList = new ArrayList<>();
//        for (RepairRequest.DeviceRequest deviceRequest : repairRequest.getDeviceList()) {
//            Device device1 = new Device();
//            device1.setId(deviceRequest.getId());
//            deviceList.add(device1);
//        }
//        repair.setDevice(deviceList);
//        repair.setDes(repairRequest.getDes());
//        repair.setStatus(repairRequest.getStatus());
//        Repair savedRepair = repairRepository.save(repair);
//        return new ResponseEntity<>(savedRepair, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<Repair> createRepair(@RequestBody RepairRequest repairRequest) {
        Repair repair = repairService.createRepair(repairRequest);
        return ResponseEntity.ok(repair);
    }

    @PutMapping("{id}")
    public ResponseEntity<Repair> updateRepair(@PathVariable int id,@RequestBody RepairRequest repairRequest) {
        Repair repair = repairService.updateRepair(id,repairRequest);
        return ResponseEntity.ok(repair);
    }
//    @PutMapping("{id}")
//    public ResponseEntity<Repair> updateRepair(@PathVariable int id,@RequestBody RepairRequest repairRequest) {
//        Repair repair = repairRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
//        repair.setRepName(repairRequest.getRepName());
//        Customer customer = new Customer();
//        customer.setId(repairRequest.getCustomer().getId());
//        repair.setCustomer(customer);
//
//        List<Device> deviceList = new ArrayList<>();
//        for (RepairRequest.DeviceRequest deviceRequest : repairRequest.getDeviceList()) {
//            Device device1 = new Device();
//            device1.setId(deviceRequest.getId());
//            deviceList.add(device1);
//        }
//        repair.setDevice(deviceList);
//        repair.setDes(repairRequest.getDes());
//        repair.setStatus(repairRequest.getStatus());
//
//        Repair updateRepair = repairRepository.save(repair);
//        return new ResponseEntity<>(updateRepair, HttpStatus.CREATED);
//    }



    @GetMapping("{id}")
    public ResponseEntity<Repair> getRepairById(@PathVariable int id) {
        Repair repair = repairService.getRepairById(id);
        return ResponseEntity.ok(repair);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteRepair(@PathVariable int id) {
        repairService.deleteRepair(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
