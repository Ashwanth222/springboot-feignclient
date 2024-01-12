package com.springboot.springbootfeignclient.service;

import com.springboot.springbootfeignclient.client.AddressClient;
import com.springboot.springbootfeignclient.model.AddressResponse;
import com.springboot.springbootfeignclient.model.Employee;
import com.springboot.springbootfeignclient.model.EmployeeResponse;
import com.springboot.springbootfeignclient.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AddressClient addressClient;
    @Autowired
    private ModelMapper mapper;

    public String addUser(Employee employee) {
        employeeRepo.save(employee);
        return "Employee Added Successfully";
    }

    public EmployeeResponse getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());
        return employeeResponse;
    }

}

