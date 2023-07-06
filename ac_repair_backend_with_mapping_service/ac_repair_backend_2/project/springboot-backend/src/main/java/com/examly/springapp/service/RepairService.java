package com.examly.springapp.service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Customer;
import com.examly.springapp.model.Device;
import com.examly.springapp.model.Repair;
import com.examly.springapp.model.RepairRequest;
import com.examly.springapp.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepairService {

    private final RepairRepository repairRepository;
    @Autowired
    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    public List<Repair> getAllRepairs() {
        return repairRepository.findAll();
    }

    public Repair getRepairById(int repairId) {
        return repairRepository.findById(repairId)
                .orElseThrow(() -> new ResourceNotFoundException("Repair not exist with id: " + repairId));
    }

    public void deleteRepair(int repairId) {
        repairRepository.deleteById(repairId);
    }

    public Repair createRepair(RepairRequest repairRequest) {
        Repair repair = new Repair();
        repair.setId(repairRequest.getId());
        repair.setRepName(repairRequest.getRepName());

        Customer customer = new Customer();
        customer.setId(repairRequest.getCustomer().getId());
        repair.setCustomer(customer);

        List<Device> deviceList = new ArrayList<>();
        for (RepairRequest.DeviceRequest deviceRequest : repairRequest.getDeviceList()) {
            Device device1 = new Device();
            device1.setId(deviceRequest.getId());
            deviceList.add(device1);
        }
        repair.setDevice(deviceList);
        repair.setDes(repairRequest.getDes());
        repair.setStatus(repairRequest.getStatus());
        return repairRepository.save(repair);
    }
    public Repair updateRepair(int id, RepairRequest repairRequest) {
        Repair repair = repairRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        repair.setRepName(repairRequest.getRepName());
        Customer customer = new Customer();
        customer.setId(repairRequest.getCustomer().getId());
        repair.setCustomer(customer);

        List<Device> deviceList = new ArrayList<>();
        for (RepairRequest.DeviceRequest deviceRequest : repairRequest.getDeviceList()) {
            Device device1 = new Device();
            device1.setId(deviceRequest.getId());
            deviceList.add(device1);
        }
        repair.setDevice(deviceList);
        repair.setDes(repairRequest.getDes());
        repair.setStatus(repairRequest.getStatus());

        return repairRepository.save(repair);
    }
}
