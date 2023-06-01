package com.hyparxis.evm.evmApplication.Repositories;

import com.hyparxis.evm.evmApplication.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById();
}
