package br.edu.ifpb.dac.web.controllers;

import br.edu.ifpb.dac.domain.Integrante;
import br.edu.ifpb.dac.service.IntegranteService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class IntegranteController implements Serializable {



    @EJB
    private IntegranteService integranteService;
    private Integrante integrante;
    private List<Integrante> integrantes;



    @PostConstruct
    public void init() {
        this.integrante = new Integrante();
        this.integrantes=getDataDeNascimento();
    }
    public List<Integrante> getTodosOsClientes() {
        return integranteService.listarTodos();
    }
    public List<Integrante> getDataDeNascimento() {
        return integranteService.integrantePorNascimento();
    }

    public Integrante getIntegrante() {
        return this.integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
}
