package br.com.alura.clientelo.application.model.pedidoEntity.pedidoDao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.clientelo.application.model.pedidoEntity.ItemPedido;
import br.com.alura.clientelo.infra.JPAUtil;

public class ItemPedidoDao {

    private EntityManager em = JPAUtil.getEntityManager();

    public ItemPedido buscaPorId(Long id) {
        return em.find(ItemPedido.class, id);
    }

    public void atualiza(ItemPedido t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }

    public void remove(ItemPedido t) {
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
    }

    public List<ItemPedido> listaTodos() {
        return em.createQuery("select f from ItemPedido f", ItemPedido.class).getResultList();
    }
}

