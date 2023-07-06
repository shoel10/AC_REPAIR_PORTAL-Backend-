package com.examly.springapp.controller;

import com.examly.springapp.service.DeviceService;
import com.examly.springapp.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping
    public ResponseEntity<Boolean> createDevice(@RequestBody Device device) {
        deviceService.createDevice(device);
        return  ResponseEntity.ok(true);
    }

    @GetMapping("{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable long id) {
        Device device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

    @PutMapping("{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable long id, @RequestBody Device deviceDetails) {
        Device updatedDevice = deviceService.updateDevice(id, deviceDetails);
        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Device> deleteDevice(@PathVariable long id) {
        Device device=deviceService.getDeviceById(id);
        deviceService.deleteDevice(id);
        return  ResponseEntity.ok(device);
    }
}

