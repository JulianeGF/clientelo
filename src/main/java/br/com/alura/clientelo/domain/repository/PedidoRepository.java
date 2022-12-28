package br.com.alura.clientelo.domain.repository;

import java.util.List;

import br.com.alura.clientelo.domain.model.pedidoEntity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p join FETCH p.itens as itens "
            + "join FETCH itens.produto as prod "
            + "join FETCH prod.categoria as cat")
    public List<Pedido> getAll();


}
