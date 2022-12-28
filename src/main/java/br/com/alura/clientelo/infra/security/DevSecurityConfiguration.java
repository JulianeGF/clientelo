package br.com.alura.clientelo.infra.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Profile("dev")
@Configuration
public class DevSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override // configuracao de autorizacao
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/categorias/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/clientes/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/pedidos/*").permitAll()
                .anyRequest().authenticated();
    }

    @Override //configuracoes de autenticacao
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override //configuracao de recurso estatico(js, css, imgs...)
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
