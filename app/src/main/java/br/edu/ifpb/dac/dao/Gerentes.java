package br.edu.ifpb.dac.dao;

import br.edu.ifpb.dac.domain.CPF;
import br.edu.ifpb.dac.domain.Gerente;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Local
@Stateless(name = "Gerentes")
public class Gerentes {
    @PersistenceContext
    private final EntityManager entityManager;

    public Gerentes() {
        this.entityManager = Persistence.createEntityManagerFactory("bandas").createEntityManager();
    }
    public List<Gerente> listarTodos() throws NoResultException {
        return entityManager.createQuery("FROM Gerente g").getResultList();
    }


    public void salvar(Gerente gerente) {

        entityManager.persist(gerente);

    }


    public void remover(Gerente gerente) throws NoResultException {
        Gerente gerenteToRemove = entityManager.find(Gerente.class, gerente.getCpf());
        entityManager.remove(gerenteToRemove);
    }


    public void atualizar(Gerente gerente) {
        entityManager.merge(gerente);
    }


    public Gerente gerenteComCPF(String cpf) throws NoResultException {
        CPF cpf1 = new CPF(cpf);
        return (Gerente) entityManager
                .createQuery("FROM Gerente g WHERE g.cpf = :cpf")
                .setParameter("cpf", cpf1)
                .getSingleResult();

    }
}
