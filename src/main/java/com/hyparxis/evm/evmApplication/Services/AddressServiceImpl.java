package com.hyparxis.evm.evmApplication.Services;

import com.hyparxis.evm.evmApplication.Repositories.AddressRepository;
import com.hyparxis.evm.evmApplication.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveNewAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddress() {
        return addressRepository.findById();
    }
}
