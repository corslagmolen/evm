package com.hyparxis.evm.evmApplication.Repositories;

import com.hyparxis.evm.evmApplication.entity.Team;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    public List<Team> findByTeamDetailsTeamOrganization(String teamOrganization);

    public Team findByTeamName(String teamName);

    public List<Team> findByTeamNameContaining(String teamName);

    @Query("select s.teamName from Team s where s.teamName = ?1")
    String getTeamName(String name);

    @Query(value = "SELECT * FROM tbl_team;", nativeQuery = true)
    List<Team> getAllTeamsNative();

    @Query(value = "SELECT * FROM tbl_team s where s.team_name = :name", nativeQuery = true)
    Team getTeamByNameNative(String name);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_team set team_name = :name where team_id = :id",
            nativeQuery = true
    )
    int updateTeamNameByTeamId(Long id, String name);

}
