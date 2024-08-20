package com.api.h2.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;

public interface ClienteView {
    String getName();

    Long getAge();

    String getDireccion();

    //@Column(name = "phone")
    @JsonProperty("numeroxD")
    String getPhone();
}
