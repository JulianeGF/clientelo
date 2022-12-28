package br.com.alura.clientelo.domain.repository;

import java.util.Optional;

import br.com.alura.clientelo.domain.model.usuarioEntity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    Optional<Usuario> findByLogin(String login);
}