package com.hyparxis.evm.evmApplication.Services;

import com.hyparxis.evm.evmApplication.entity.Address;

import java.util.List;

public interface AddressService {

    Address saveNewAddress(Address address);

    Address getAddress();
}
