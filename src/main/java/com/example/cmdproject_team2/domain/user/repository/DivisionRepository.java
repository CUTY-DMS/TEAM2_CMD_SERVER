package com.example.cmdproject_team2.domain.user.repository;

import com.example.cmdproject_team2.domain.user.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DivisionRepository extends JpaRepository<Division, Long> {

    Optional<Division> findBySchoolClassAndNumberAndGrader(Integer schoolClass,Integer number, Integer grader);

}
