package br.com.alura.clientelo.domain.repository;

import java.util.List;

import br.com.alura.clientelo.domain.model.produtoEntity.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Query("select p from Produto p where p.quantidadeEstoque > 0")
    public List<Produto> listaDisponiveis();

    @Query("select p from Produto p where p.quantidadeEstoque = 0")
    public List<Produto> listaIndisponiveis();

}
