package com.examly.springapp.service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Device;
import com.examly.springapp.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long deviceId) {
        return deviceRepository.findById(deviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Device not exist with id:"+ deviceId));
    }

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device updateDevice(Long deviceId, Device deviceDetails) {
        Device device = getDeviceById(deviceId);
        device.setBrand(deviceDetails.getBrand());
        device.setModel(deviceDetails.getModel());
        device.setType(deviceDetails.getType());
        // Update other fields as needed
        return deviceRepository.save(device);
    }

    public void deleteDevice(Long deviceId) {
        deviceRepository.deleteById(deviceId);
    }
}
