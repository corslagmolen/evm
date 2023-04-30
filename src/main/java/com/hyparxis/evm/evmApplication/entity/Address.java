package com.hyparxis.evm.evmApplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "teamMember")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long addressId;
    private String street;
    private String number;
    private String postalCode;

    private String city;
    private String country;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = true
    )
    @JoinColumn(
            name = "team_member_id",
            referencedColumnName = "memberId")
    private TeamMember teamMember;

}
