package com.example.cmdproject_team2.domain.user.repository;

import com.example.cmdproject_team2.domain.user.entity.Authority;
import com.example.cmdproject_team2.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserId(String userId);

    Optional<User> findByAuthority(Authority authority);
}
