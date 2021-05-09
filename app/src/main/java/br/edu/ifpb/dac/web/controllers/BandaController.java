package br.edu.ifpb.dac.web.controllers;

import br.edu.ifpb.dac.domain.Banda;
import br.edu.ifpb.dac.domain.CPF;
import br.edu.ifpb.dac.domain.Gerente;
import br.edu.ifpb.dac.domain.Integrante;
import br.edu.ifpb.dac.service.BandaService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Named
@SessionScoped
public class BandaController implements Serializable {

    @EJB
    private BandaService bandaService;

    private List<Banda> bandas;

    private Banda banda;

    private String busca;


    @PostConstruct
    public void init() {
        this.banda = new Banda();
        this.bandas = listar();
    }
    public void bandaById(int id){
        this.banda= this.bandaService.bandaById(id);

    }
    public void buscar() {
        this.bandas = this.bandaService.bandaByLocalDeOrigem(busca);

    }


    public List<Banda> listar() {
        return bandaService.listarTodos();
    }
    public String preencher() {
        LocalDate localDate1= LocalDate.of(1995, 12, 12);
        LocalDate localDate2= LocalDate.of(1999, 05, 05);
        LocalDate localDate3= LocalDate.of(2004, 05, 25);
        LocalDate localDate4= LocalDate.of(2008, 04, 15);



        CPF cpf1 = new CPF("11111111111");
        CPF cpf2 = new CPF("22222222222");
        CPF cpf3 = new CPF("33333333333");
        CPF cpf4 = new CPF("44444444444");
        CPF cpf5 = new CPF("55555555555");

        Integrante integrante = new Integrante("Jose carlos", localDate1,cpf1);
        Integrante integrante2 = new Integrante("Katia carlos", localDate2,cpf2);

        Integrante integrante3 = new Integrante("Thomas carlos", localDate3,cpf4);
        Integrante integrante4 = new Integrante("Tiago carlos", localDate4,cpf5);
        Gerente gerente = new Gerente("Lucas Carlos",banda,"lucascarlos@hotmail.com",cpf3);

        banda.setGerente(gerente);
        banda.getIntegrantes().add(integrante);
        banda.getIntegrantes().add(integrante2);
        banda.getIntegrantes().add(integrante3);
        banda.getIntegrantes().add(integrante4);
        banda.setLocalDeOrigem("umari");
        banda.setNomeFantasia("Forro Moral");
        gerente.setBanda(banda);

        bandaService.salvar(banda);

        System.out.println("Ver se gravou");
        this.bandas = bandaService.listarTodos();
        System.out.println(bandas);
        return "nextIndex.xhtml";

    }

    public Banda getBanda() {
        return this.banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public List<Banda> getBandas() {
        return bandas;
    }

    public void setBandas(List<Banda> bandas) {
        this.bandas = bandas;
    }
}
