package com.hyparxis.evm.evmApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.TituloEleitoral;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamMember {

    @Id
    @SequenceGenerator(
            name = "teamMember_sequence",
            sequenceName = "teamMember_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teamMember_sequence"
    )
    private Long memberId;
    private String firstName;
    private String lastName;

    private String role;
    @Email
    private String email;
    @Size(min = 6, max = 12)
    private String phone;

    @OneToOne(
            mappedBy = "teamMember"
    )
    private Address address;


}
