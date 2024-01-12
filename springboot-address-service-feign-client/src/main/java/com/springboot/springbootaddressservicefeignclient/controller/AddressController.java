package com.springboot.springbootaddressservicefeignclient.controller;

import com.springboot.springbootaddressservicefeignclient.model.Address;
import com.springboot.springbootaddressservicefeignclient.model.AddressResponse;
import com.springboot.springbootaddressservicefeignclient.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping("/addNewAddress")
    public String addNewUser(@RequestBody Address address) {
        return service.addAddress(address);
    }


    @GetMapping("/address/{id}")
    private ResponseEntity<AddressResponse> getAddressDetails(@PathVariable("id") int id) {
        AddressResponse address = service.findAddressByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

}

