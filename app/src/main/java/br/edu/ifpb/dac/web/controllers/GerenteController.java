package br.edu.ifpb.dac.web.controllers;

import br.edu.ifpb.dac.domain.Gerente;
import br.edu.ifpb.dac.service.GerenteService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class GerenteController implements Serializable {
    @EJB
    private GerenteService gerenteService;
    private Gerente gerente;


    @PostConstruct
    public void init() {
        this.gerente = new Gerente();
        this.gerenteService = new GerenteService();
    }
    public void gerenteByCpf(String cpf){
        this.gerente= this.gerenteService.gerenteComCPF(cpf);

    }

    public Gerente getGerente() {
        return this.gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
