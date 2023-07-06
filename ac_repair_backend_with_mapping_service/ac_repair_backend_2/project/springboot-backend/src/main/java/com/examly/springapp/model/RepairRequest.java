package com.examly.springapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepairRequest {
    private long id;
    private String repName;
    private CustomerRequest customer;
    private List<DeviceRequest> device;
    private String des;
    private String status;

    public List<DeviceRequest> getDeviceList() {
        return device != null ? device : new ArrayList<>();
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    // Getters and setters
    public static class CustomerRequest {
        private long id;

        // Getters and setters
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeviceRequest {
        private long id;

        // Getters and setters
    }
}





