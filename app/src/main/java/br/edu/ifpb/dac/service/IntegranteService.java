package br.edu.ifpb.dac.service;

import br.edu.ifpb.dac.dao.Integrantes;
import br.edu.ifpb.dac.domain.CPF;
import br.edu.ifpb.dac.domain.Integrante;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.List;

@Local
@Stateless
public class IntegranteService {
    @EJB
    private Integrantes integrantes ;

    public IntegranteService() {
        this.integrantes =  new Integrantes();
    }

    public List<Integrante> listarTodos() {
        return integrantes.listarTodos();
    }

    public CPF salvar(Integrante integrante) {
        integrantes.salvar(integrante);
        return integrante.getCpf();
    }

    public void remover(Integrante integrante) {
        try {
            integrantes.remover(integrante);
        } catch (NoResultException ex) {
//            ex.printStackTrace();
        }
    }

    public void atualizar(Integrante integrante) {
        integrantes.atualizar(integrante);
    }

    public Integrante integranteComCPF(String cpf) {
        try {
            return integrantes.integranteComCPF(cpf);

        } catch (NoResultException ex) {
            return null;
        }

    }
    public List<Integrante> integrantePorNascimento() {
        return integrantes.integrantePorNascimento();
    }





}
