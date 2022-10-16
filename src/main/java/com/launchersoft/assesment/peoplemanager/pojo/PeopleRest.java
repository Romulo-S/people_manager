package com.launchersoft.assesment.peoplemanager.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.launchersoft.assesment.peoplemanager.model.DocumentoIdentificacao;
import com.launchersoft.assesment.peoplemanager.model.TipoIdentificacao;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeopleRest {

    @NotNull
    private String name;

    @NotNull
    private String documentoIdentificacao;

    private TipoIdentificacao tipoIdentificacao;
}
