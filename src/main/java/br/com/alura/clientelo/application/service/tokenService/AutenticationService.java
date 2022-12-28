package br.com.alura.clientelo.application.service.tokenService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.clientelo.domain.model.usuarioEntity.Usuario;
import br.com.alura.clientelo.domain.repository.UsuarioRepository;

@Service
public class AutenticationService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByLogin(username);

        if (usuario.isPresent()) {
            return (UserDetails) usuario.get();
        }

        throw new UsernameNotFoundException("Usuário inválido");
    }



}