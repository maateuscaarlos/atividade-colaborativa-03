package br.edu.ifpb.dac.service;

import br.edu.ifpb.dac.dao.Gerentes;
import br.edu.ifpb.dac.domain.CPF;
import br.edu.ifpb.dac.domain.Gerente;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.List;

@Local
@Stateless
public class GerenteService {
    @EJB
    private Gerentes gerentes ;

    public GerenteService() {
        this.gerentes =  new Gerentes();
    }

    public List<Gerente> listarTodos() {
        return gerentes.listarTodos();
    }

    public CPF salvar(Gerente gerente) {
        gerentes.salvar(gerente);
        return gerente.getCpf();
    }

    public void remover(Gerente gerente) {
        try {
            gerentes.remover(gerente);
        } catch (NoResultException ex) {
//            ex.printStackTrace();
        }
    }

    public void atualizar(Gerente gerente) {
        gerentes.atualizar(gerente);
    }

    public Gerente gerenteComCPF(String cpf) {
        try {
            return gerentes.gerenteComCPF(cpf);

        } catch (NoResultException ex) {
            return null;
        }

    }
}
