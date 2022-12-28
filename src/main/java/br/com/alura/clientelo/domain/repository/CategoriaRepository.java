package br.com.alura.clientelo.domain.repository;

import java.util.List;

import br.com.alura.clientelo.domain.model.categoriaEntity.Categoria;
import br.com.alura.clientelo.application.view.vo.VendasVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

    List<Categoria> findByNome(String nome);

    List<Categoria> findByAtiva(Boolean ativa);

    @Query("SELECT c FROM Categoria c WHERE c.nome = :nome AND c.ativa = :ativa")
    List<Categoria> findByNomeEAtiva(String nome, Boolean ativa);

    @Query("select new br.com.alura.clientelo.vo.VendasVo (c.nome, sum(ip.quantidade), sum(ip.precoUnitario * ip.quantidade)) " +
            "from br.com.alura.clientelo.model.ItemPedido ip " +
            "join ip.produto p join p.categoria c group by c.id")
    List<VendasVo> vendasPorCategoria();
}