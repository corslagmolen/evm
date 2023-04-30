package com.hyparxis.evm.evmApplication.Repositories;

import com.hyparxis.evm.evmApplication.entity.Team;
import com.hyparxis.evm.evmApplication.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

}
