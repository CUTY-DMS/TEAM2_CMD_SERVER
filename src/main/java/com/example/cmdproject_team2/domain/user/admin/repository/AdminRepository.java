package com.example.cmdproject_team2.domain.user.admin.repository;

import com.example.cmdproject_team2.domain.user.admin.entity.Admin;
import com.example.cmdproject_team2.domain.user.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);
    List<Admin> findAllByType(UserType userType);
}
