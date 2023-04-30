package com.hyparxis.evm.evmApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_team",
        uniqueConstraints = @UniqueConstraint(
                name = "teamName_unique",
                columnNames = "team_name"
        ))
public class Team {
    @Id
    @SequenceGenerator(
            name = "team_sequence",
            sequenceName = "team_sequence",
            allocationSize = 10
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_sequence"
    )
    private Long teamId;
    @Column(
            name = "team_name",
            nullable = false
    )
    @NotBlank(message = "Please fill in Team name!!")
    private String teamName;
    @NotBlank(message = "Please fill in Team purpose" +
            "!!")
    private String teamPurpose;
    @Column(
            name = "team_type",
            nullable = false
    )
    private String teamType;

    @Embedded
    private TeamDetails teamDetails;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "team_id",
            referencedColumnName = "teamId"
    )
    private List<TeamMember> teamMembers;

}
