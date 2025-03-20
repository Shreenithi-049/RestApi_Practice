package com.shree.springapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shree.springapp.model.Address;
import com.shree.springapp.model.User;
import com.shree.springapp.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    public Address saveAddress(Address address)
    {
        return addressRepository.save(address);
    }

    public Optional<Address> getAddressById(Long id)
    {
       return addressRepository.findById(id);
    }

    public Address updateAddress(long id,Address newAddress)
    {
        return addressRepository.findById(id).map(existingAddress -> {
            existingAddress.setId(newAddress.getId());
            existingAddress.setCity(newAddress.getCity());
            existingAddress.setStreet(newAddress.getStreet());
            existingAddress.setUser(newAddress.getUser());
            return addressRepository.save(existingAddress);

        }).orElseThrow(() -> new RuntimeException("Course not found with id"+id));
    }

    public void deleteAddress(Long id)
    {
        addressRepository.deleteById(id);
    }

}
