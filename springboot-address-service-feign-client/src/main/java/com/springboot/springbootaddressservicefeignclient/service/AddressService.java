package com.springboot.springbootaddressservicefeignclient.service;

import com.springboot.springbootaddressservicefeignclient.model.Address;
import com.springboot.springbootaddressservicefeignclient.model.AddressResponse;
import com.springboot.springbootaddressservicefeignclient.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper mapper;
    public String addAddress(Address address) {
        addressRepo.save(address);
        return "Address Added Successfully";
    }

    public AddressResponse findAddressByEmployeeId(int id) {
        Optional<Address> addressByEmployeeId = addressRepo.findById(id);
        AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);
        return addressResponse;
    }

}

