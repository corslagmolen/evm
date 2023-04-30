package com.hyparxis.evm.evmApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDetails {
    @Column(
            name = "team_domain",
            nullable = true
    )
    private String teamDomain;
    @Column(
            name = "team_organization",
            nullable = true
    )
    private String teamOrganization;
}
