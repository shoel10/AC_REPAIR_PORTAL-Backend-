package com.examly.springapp;
import com.examly.springapp.repository.CustomerRepository;
import com.examly.springapp.repository.DeviceRepository;
import com.examly.springapp.repository.EmployeeRepository;
import com.examly.springapp.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {SpringApplication.run(SpringbootBackendApplication.class, args);}


	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RepairRepository repairRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DeviceRepository deviceRepository;
	@Override
	public void run(String... args) throws Exception {

//		Employee employee = new Employee();
//		employee.setName("Ramesh");
//		employee.setEmailId("ramesh@gmail.com");
//		employee.setPhn("9848190021");
//		employee.setAct("Yes");
//		employeeRepository.save(employee);
////
//		Employee employee1 = new Employee();
//		employee1.setName("John");
//		employee1.setEmailId("cena@gmail.com");
//		employee1.setPhn("9876543212");
//		employee1.setAct("No");
//		employeeRepository.save(employee1);

//		Customer customer = new Customer();
//		customer.setName("shoel");
//		customer.setEmail("shoelh@gmail.com");
//		customer.setPhone_no("9848190021");
//		customerRepository.save(customer);
//
//		Device device1 =new Device();
//		device1.setId(1);
//		device1.setBrand("BlueStar");
//		device1.setType("Split AC");
//		device1.setModel("1 ton");
//		deviceRepository.save(device1);
//
//		Device device2 =new Device();
//		device2.setId(2);
//		device2.setBrand("Lyod");
//		device2.setType("Central AC");
//		device2.setModel("5 star");
//		deviceRepository.save(device2);
//
//		Repair repair = new Repair();
//		repair.setRepName("AC Compressor Replacement");
//		repair.setCustomer(customer);
//		repair.getDevice().add(device1);
//		repair.getDevice().add(device2);
//		repair.setDes("Replace faulty compressor in the air conditioning unit to restore cooling functionality.");
//		repair.setStatus("In Progress");
//		repairRepository.save(repair);



	}
}
