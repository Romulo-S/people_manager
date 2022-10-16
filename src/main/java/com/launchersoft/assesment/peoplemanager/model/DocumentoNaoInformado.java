package com.launchersoft.assesment.peoplemanager.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentoNaoInformado implements DocumentoIdentificacao {

    @JsonValue
    private final String value;

    public static DocumentoNaoInformado from(String value) {
        return new DocumentoNaoInformado(Objects.requireNonNull(value).replaceAll("\\D", ""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DocumentoNaoInformado documentoNaoInformado = (DocumentoNaoInformado) o;
        return Objects.equals(value, documentoNaoInformado.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
