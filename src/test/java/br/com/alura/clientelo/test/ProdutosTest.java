package br.com.alura.clientelo.test;

import br.com.alura.clientelo.Pedido;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutosTest {

    static List<Pedido> pedidos = new ArrayList<>();

    @BeforeAll
    static void setup() {
        pedidos.add(new Pedido("binoculo", "lesma", null, new BigDecimal(10), 3, null));
        pedidos.add(new Pedido("seila", "xexelento", null, new BigDecimal(20), 2, null));
        pedidos.add(new Pedido("qualquer", "cria", null, new BigDecimal(30), 9, null));
        pedidos.add(new Pedido("naosei", "xarizardo", null, new BigDecimal(40), 5, null));
        pedidos.add(new Pedido("xablau", "juliet", null, new BigDecimal(50), 7, null));
        pedidos.add(new Pedido("xablonso", "batata", null, new BigDecimal(60), 15, null));
    }

    @Test
    public void deveRetornarPedidoMaisBaratoFalso() {
        assertFalse(pedidos.get(0).isMaisBaratoQue(pedidos.get(1)));
    }

    @Test
    public void deveRetornarPedidoMaisBaratoVerdadeiro() {
        assertTrue(pedidos.get(1). isMaisBaratoQue(pedidos.get(0)));
    }

    @Test
    public void deveRetornarPedidoMaisCaroFalso() {
        assertFalse(pedidos.get(0).isMaisCaroQue(pedidos.get(1)));
    }

    @Test
    public void deveRetornarPedidoMaisCaroVerdadeiro() {
        assertTrue(pedidos.get(1). isMaisBaratoQue(pedidos.get(0)));
    }
}