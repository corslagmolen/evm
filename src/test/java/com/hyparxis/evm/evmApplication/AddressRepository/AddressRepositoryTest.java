package com.hyparxis.evm.evmApplication.AddressRepository;

import com.hyparxis.evm.evmApplication.Repositories.AddressRepository;
import com.hyparxis.evm.evmApplication.entity.Address;
import com.hyparxis.evm.evmApplication.entity.TeamMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;


    @Test
    public void saveAddress() {

        TeamMember teamMember = TeamMember.builder()
                .firstName("Boon")
                .lastName("Cat")
                .role("Sleep whole day")
                .email("boon@gmail.com")
                .phone("77777777777")
                .build();

        Address address = Address.builder()
                .street("Woestenweg")
                .number("6")
                .postalCode("7738PN")
                .city("Witharen")
                .country("The Netherlands")
                .teamMember(teamMember)
                .build();

        addressRepository.save(address);
    }

    @Test
    public void listAllAddresses() {
        List<Address> addresses =
                addressRepository.findAll();
        System.out.println("all addresses  :" + addresses);
    }

}