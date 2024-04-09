package com.jmatheus.portfolio.portfolio.models;

import com.jmatheus.portfolio.portfolio.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "roles")
public class Role {
    @Id
    private int id;


    @Enumerated(EnumType.STRING)
    private RoleEnum name;
}
