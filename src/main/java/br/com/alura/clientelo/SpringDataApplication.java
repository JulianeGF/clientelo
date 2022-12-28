package br.com.alura.clientelo;

import br.com.alura.clientelo.domain.repository.CategoriaRepository;
import br.com.alura.clientelo.domain.repository.ClienteRepository;
import br.com.alura.clientelo.domain.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaRepositories({"br.com.alura.clientelo.repository"})
@EntityScan("br.com.alura.clientelo.model")
@EnableSwagger2
@EnableSpringDataWebSupport
@EnableCaching

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    public SpringDataApplication(CategoriaRepository categoriaRepository, ClienteRepository clienteRepository, UsuarioRepository usuarioRepository) {
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        new TestePersistenciaCategoriaSpringData(categoriaRepository).valida();
//        new TestePersistenciaClienteSpringData(clienteRepository).valida();
//        new TestePaginacaoClienteSpringData(clienteRepository).valida(2);
//        new TestePaginacaoClienteSpringData(clienteRepository).validaComOrdenacao(2);
//
//        List<RelatorioClientePedidosVo> listaPorMaisPedidos = clienteRepository.listaPorMaisPedidos();
//        listaPorMaisPedidos.forEach(p -> System.out.println(p.getNomeDoCliente()));
//
//        List<RelatorioClientePorMontanteVo> listaPorMaiorValorGasto = clienteRepository.listaPorMaiorValorGasto();
//        listaPorMaiorValorGasto.forEach(p -> System.out.println(p.getMontanteGasto()));
//
//        List<Cliente> clientes = clienteRepository
//                .findAll(SpecificationCliente.nome("Pedro da Silva") //passar specification na service
//                        .and(SpecificationCliente.cpf("455.666.444-57")));
//
//        clientes.forEach(c -> System.out.println(c.getNome()));
    }
}
