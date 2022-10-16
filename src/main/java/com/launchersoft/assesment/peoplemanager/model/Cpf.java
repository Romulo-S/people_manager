package com.launchersoft.assesment.peoplemanager.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cpf implements DocumentoIdentificacao {

    @JsonValue
    private final String value;

    public static Cpf from(String value) {
        return new Cpf(Objects.requireNonNull(value).replaceAll("\\D", ""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(value, cpf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
