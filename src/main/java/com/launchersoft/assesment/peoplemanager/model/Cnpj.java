package com.launchersoft.assesment.peoplemanager.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cnpj implements DocumentoIdentificacao {

    public static final Cnpj NAO_INFORMADO = new Cnpj("");

    @JsonValue
    private final String value;

    public static Cnpj from(String value) {
        return new Cnpj(Objects.requireNonNull(value).replaceAll("\\D", ""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cnpj cnpj = (Cnpj) o;
        return Objects.equals(value, cnpj.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
