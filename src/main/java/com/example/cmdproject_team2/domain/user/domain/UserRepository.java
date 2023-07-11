package com.example.cmdproject_team2.domain.user.domain;

import com.example.cmdproject_team2.domain.user.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    List<User> findAllByType(UserType userType);

    Optional<User> findByUserId(String userId);

    Optional<User> findBySchoolClassAndNumberAndGrader(Long schoolClass, Long number, Long grader);
}
