package br.com.alura.clientelo.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.clientelo.application.model.pedidoEntity.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long>{

}
