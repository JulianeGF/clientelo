package br.com.alura.clientelo.application.model.categoriaEntity.categoriaDao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.clientelo.application.model.Dao;
import br.com.alura.clientelo.application.model.categoriaEntity.Categoria;
import br.com.alura.clientelo.infra.JPAUtil;

public class CategoriaDao implements Dao<Categoria> {

    private EntityManager em = JPAUtil.getEntityManager();

    @Override
    public void cadastra(Categoria t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    @Override
    public void atualiza(Categoria t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }

    @Override
    public List<Categoria> listaTodos() {
        return em.createQuery("select f from Categoria f", Categoria.class).getResultList();
    }

    @Override
    public Categoria buscaPorId(Long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public void remove(Categoria t) {
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
    }
}
