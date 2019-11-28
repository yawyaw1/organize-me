package com.service.admin.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "FirstName can't br empty ")
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;

    @NotEmpty(message = "LastName can't br empty ")
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;

    @NotEmpty(message = "LastName can't br empty ")
    @Size(max = 500, message = "Address can't br empty ")
    @Embedded
    private Address Address;

    @CreatedDate
    @Column(name = "CREATION_DATE")
    private LocalDate createDate;

    @Column(name = "USERNAME")
    private String username;

    @JsonIgnore
    @Column(name = "PASSWORD")
    @Pattern(regexp = "")
    private String password;

    @JsonIgnore
    @Transient
    private String confirmPassword;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
