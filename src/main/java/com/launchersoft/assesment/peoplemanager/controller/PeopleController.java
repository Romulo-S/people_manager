package com.launchersoft.assesment.peoplemanager.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.launchersoft.assesment.peoplemanager.model.Cnpj;
import com.launchersoft.assesment.peoplemanager.model.Cpf;
import com.launchersoft.assesment.peoplemanager.model.DocumentoIdentificacao;
import com.launchersoft.assesment.peoplemanager.model.People;
import com.launchersoft.assesment.peoplemanager.model.TipoIdentificacao;
import com.launchersoft.assesment.peoplemanager.pojo.PeopleRest;
import com.launchersoft.assesment.peoplemanager.repository.PeopleRepository;

@RestController
@RequestMapping(path = "/api/v1/people", produces = APPLICATION_JSON_VALUE)
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping
    public People createPeople(@RequestBody PeopleRest people) {
        People.PeopleBuilder builder = People.builder();
        builder.name(people.getName());
        DocumentoIdentificacao identificacao = DocumentoIdentificacao.from(people.getDocumentoIdentificacao());
        builder.documentoIdentificacao(identificacao);
        //Seta tipo indetificacao se existir
        if (identificacao == null)
            throw new AssertionError();
        if(identificacao.getClass().equals(Cpf.class)) {
            builder.tipoIdentificacao(TipoIdentificacao.CPF);
        } else if(identificacao.getClass().equals(Cnpj.class)) {
            builder.tipoIdentificacao(TipoIdentificacao.CNPJ);
        }
        return peopleRepository.save( builder.build());
    }
}
