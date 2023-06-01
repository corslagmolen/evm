package com.hyparxis.evm.evmApplication.Services;

import com.hyparxis.evm.evmApplication.Repositories.AddressRepository;
import com.hyparxis.evm.evmApplication.Repositories.TeamMemberRepository;
import com.hyparxis.evm.evmApplication.entity.Address;
import com.hyparxis.evm.evmApplication.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
