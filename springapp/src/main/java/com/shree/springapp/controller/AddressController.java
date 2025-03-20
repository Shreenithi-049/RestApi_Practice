package com.shree.springapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.springapp.model.Address;
import com.shree.springapp.model.User;
import com.shree.springapp.service.AddressService;

@RestController
@RequestMapping("/ADDRESS")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address creatUser(@RequestBody Address address)
    {
        return addressService.saveAddress(address);
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id)
    {
        return addressService.getAddressById(id);
    }

     @PutMapping("/{id}")
    public ResponseEntity<Address>updateAddress(@PathVariable long id,@RequestBody Address newAddress)
    {
        try{
            return new ResponseEntity<>(addressService.updateAddress(id,newAddress),HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAddress/{id}")
    public String deleteUserById(@PathVariable Long id)
    {
        addressService.deleteAddress(id);
        return "Address deleted Successfully";
    }


    
    

}
