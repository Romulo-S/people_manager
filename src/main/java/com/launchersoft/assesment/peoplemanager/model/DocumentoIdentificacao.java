package com.launchersoft.assesment.peoplemanager.model;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.Map;

import javax.swing.text.MaskFormatter;

import lombok.SneakyThrows;



public interface DocumentoIdentificacao extends Serializable {

    String getValue();

    static DocumentoIdentificacao from(String valor) {
        if (valor.isEmpty())
            return null;

        valor = valor.replaceAll("\\D", "");
        switch (valor.length()) {
            case 11:
                return Cpf.from(valor);
            case 14:
                return Cnpj.from(valor);
            default:
                return DocumentoNaoInformado.from(valor);
        }
    }

    @SneakyThrows
    default String formatar() {

        var value = getValue();
        var mask = Map
            .of(11, "###.###.###-##", 14, "###.###.###/####-##")
            .get(value.length());

        if (isNull(mask))
            return value;

        var formatter = new MaskFormatter();
        formatter.setValueContainsLiteralCharacters(false);
        formatter.setMask(mask);

        return formatter.valueToString(value);
    }

    static DocumentoIdentificacao exemplo() {
        return () -> "11111111111";
    }
}