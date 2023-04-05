package com.example.demo.domain.jpa;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="customer")
@Table(name = "customer",schema = "manage_customer")
public class CustomerJpa {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "identification")
    String identification;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_type")
    TypeJpa userType;

}
