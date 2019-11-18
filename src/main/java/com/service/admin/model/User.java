package com.service.admin.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity(name = "User")
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Embedded
    private Address Address;

    @CreatedDate
    @Column(name = "CREATION_DATE")
    private LocalDate createDate;

    @Column(name = "USERNAME")
    private String username;

    @JsonIgnore
    @Column(name = "PASSWORD")
    private String password;

    @JsonIgnore
    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();
}
