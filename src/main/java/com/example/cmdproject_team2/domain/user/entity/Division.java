package com.example.cmdproject_team2.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private Integer grader;

    @NotNull
    @Column
    private Integer schoolClass;

    @NotNull
    @Column
    private Integer number;

    @OneToMany(mappedBy = "division")
    private List<User> users;

    @Builder
    public Division(Integer grader, Integer schoolClass, Integer number) {
        this.grader = grader;
        this.number = number;
        this.schoolClass = schoolClass;
    }
}
