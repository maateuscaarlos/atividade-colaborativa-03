package br.edu.ifpb.dac.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Gerente implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @OneToOne
    private Banda banda;
    private String email;
    @Embedded
    private CPF cpf = new CPF("");

    public Gerente() {
    }

    public Gerente( String nome, Banda banda, String email, CPF cpf) {
        this.nome = nome;
        this.banda = banda;
        this.email = email;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }


}

