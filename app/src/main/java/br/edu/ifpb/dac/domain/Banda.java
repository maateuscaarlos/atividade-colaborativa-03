package br.edu.ifpb.dac.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Banda implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String localDeOrigem;
    private String nomeFantasia;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Integrante> integrantes =  new ArrayList<>();
    @OneToOne(mappedBy = "banda",cascade = CascadeType.PERSIST)
    private Gerente gerente;

    public Banda() {
    }

    public Banda( String localDeOrigem, String nomeFantasia, List<Integrante> integrantes, Gerente gerente) {
        this.localDeOrigem = localDeOrigem;
        this.nomeFantasia = nomeFantasia;
        this.integrantes = integrantes;
        this.gerente = gerente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Banda{" +
                "id=" + id +
                ", localDeOrigem='" + localDeOrigem + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", integrantes=" + integrantes +
                ", gerente=" + gerente +
                '}';
    }
}
