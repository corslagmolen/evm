package com.hyparxis.evm.evmApplication.Repositories;

import com.hyparxis.evm.evmApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
