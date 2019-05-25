package com.service.administration.model;


import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String street;

    private String city;

    private String state;

    private String country;
}
