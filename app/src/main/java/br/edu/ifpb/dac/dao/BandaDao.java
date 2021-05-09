package br.edu.ifpb.dac.dao;

import br.edu.ifpb.dac.domain.Banda;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Local
@Stateless(name = "BandaDao")
public class BandaDao {
    @PersistenceContext
    private final EntityManager entityManager;

    public BandaDao() {
        this.entityManager = Persistence.createEntityManagerFactory("bandas").createEntityManager();
    }
    public List<Banda> listarTodos() throws NoResultException {
        return entityManager.createQuery("FROM Banda b").getResultList();
    }


    public void salvar(Banda banda) {
        entityManager.persist(banda);
    }


    public void remover(Banda banda) throws NoResultException {
        Banda bandaToRemove = entityManager.find(Banda.class, banda.getId());
        entityManager.remove(bandaToRemove);
    }


    public void atualizar(Banda banda) {
        entityManager.merge(banda);
    }


    public Banda bandaById(int id) throws NoResultException {
        return (Banda) entityManager
                .createQuery("FROM Banda b WHERE b.id = :id")
                .setParameter("id", id)
                .getSingleResult();

    }
    public List<Banda> bandaByLocalDeOrigem(String local) throws NoResultException {
        return entityManager.createQuery("FROM Banda b").getResultList();

    }

}
