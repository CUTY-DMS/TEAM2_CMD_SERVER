package com.example.cmdproject_team2.domain.user.repository;

import com.example.cmdproject_team2.domain.user.entity.User;
import com.example.cmdproject_team2.domain.user.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    List<User> findAllByType(UserType userType);
}
