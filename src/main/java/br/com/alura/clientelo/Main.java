package br.com.alura.clientelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");

        //Relatorios.gerarRelatorioProdutosMaisVendidos(pedidos);
        //Relatorios.gerarRelatorioVendasPorCategoria(pedidos);

    }
}
