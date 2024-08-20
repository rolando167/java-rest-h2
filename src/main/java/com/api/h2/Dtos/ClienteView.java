package com.api.h2.Dtos;

import jakarta.persistence.Column;

public interface ClienteView {
    String getName();
    Long getAge();
    String getDireccion();

    //@Column(name = "number_phone")
    String getNumberPhone();
}
