package br.com.alura.clientelo.domain;

import br.com.alura.clientelo.domain.model.clienteEntity.Cliente;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationCliente {

    public static Specification<Cliente> nome(String nome){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Cliente> cpf(String cpf){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<Cliente> telefone(String telefone){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("telefone"), telefone);
    }
}
//criar specification pra pedido