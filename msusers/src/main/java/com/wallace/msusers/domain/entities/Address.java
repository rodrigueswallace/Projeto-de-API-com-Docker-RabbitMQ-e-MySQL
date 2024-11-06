package com.wallace.msusers.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Address {

    @Id
    private String zipCode;
    private String street;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
}
