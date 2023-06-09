package com.hyparxis.evm.evmApplication.Controllers;

import com.hyparxis.evm.evmApplication.Repositories.UserRepository;
import com.hyparxis.evm.evmApplication.Services.AddressService;
import com.hyparxis.evm.evmApplication.entity.Address;
import com.hyparxis.evm.evmApplication.entity.User;
import com.hyparxis.evm.evmApplication.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path ="/api/v1/address")

@RequiredArgsConstructor
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<Address> createAddress(@PathVariable(value = "userId") Integer userId,
                                                         @RequestBody Address address) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Not found User with id = " + userId));

        address.setUser(user);


        Address addressDetails = addressService.saveNewAddress(address);

        return new ResponseEntity<>(addressDetails, HttpStatus.CREATED);
    }



    @GetMapping(path = "/")
    public Address getAddress(){
        return addressService.getAddress();

    }
}
