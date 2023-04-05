package com.example.demo.domain.jpa;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="status")
@Table(name = "status",schema = "manage_customer")
public class StatusJpa {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "identification")
    String identification;
    @Column(name = "status")
    Boolean status;
}
