package br.edu.ifpb.dac.web.controllers;

import br.edu.ifpb.dac.domain.CPF;
import br.edu.ifpb.dac.domain.Gerente;
import br.edu.ifpb.dac.domain.Integrante;
import br.edu.ifpb.dac.domain.Pessoa;
import br.edu.ifpb.dac.service.GerenteService;
import br.edu.ifpb.dac.service.IntegranteService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@SessionScoped
public class PessoaController implements Serializable {

    @EJB
    private IntegranteService integranteService;

    @EJB
    private GerenteService gerenteService;

    private Gerente gerente;
    private Integrante integrante;

    private String busca;
    private String tipoBusca;


    private List<Pessoa> pessoas;


    @PostConstruct
    public void init() {
        this.gerente = new Gerente();
        this.integrante = new Integrante();
        this.pessoas =  new ArrayList<>();
    }
    public void buscar() {

        switch (tipoBusca.toLowerCase()) {
            case "gerente":
                 this.gerente = this.gerenteService.gerenteComCPF(busca);
                 Pessoa pessoa = new Pessoa();

                 pessoa.setNome(gerente.getNome());
                 pessoa.setCpf(gerente.getCpf());
                 pessoas.add(pessoa);

                 break;
            case "integrante":
                 this.integrante = this.integranteService.integranteComCPF(busca);
                Pessoa pessoa2 = new Pessoa();

                pessoa2.setNome(integrante.getNome());
                pessoa2.setCpf(integrante.getCpf());
                pessoas.add(pessoa2);
                 break;
        }

    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getTipoBusca() {
        return tipoBusca;
    }

    public void setTipoBusca(String tipoBusca) {
        this.tipoBusca = tipoBusca;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
