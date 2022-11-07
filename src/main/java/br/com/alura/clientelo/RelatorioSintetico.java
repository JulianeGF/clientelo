package br.com.alura.clientelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class RelatorioSintetico {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    static List<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");

    String[] categoriasProcessadas = new String[10];

    BigDecimal montanteDeVendas = BigDecimal.ZERO;
    int totalDePedidosRealizados = 0;
    int totalDeProdutosVendidos = 0;
    Pedido pedidoMaisBarato = null;
    Pedido pedidoMaisCaro = null;
    int totalDeCategorias = 0;
    Pedido pedidoAtual = null;

    BigDecimal precoPedidoAtual = this.pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade()));

    public void pedidoMaisBaratoEMaisCaro() {

        for (int i = 0; i < pedidos.toArray().length; i++) {
            this.pedidoAtual = pedidos.get(i);

            if (pedidoAtual == null) {
                break;
            }

            if (pedidoMaisBarato == null || precoPedidoAtual.compareTo(pedidoMaisBarato.getPreco().multiply(new BigDecimal(pedidoMaisBarato.getQuantidade()))) < 0) {
                pedidoMaisBarato = pedidoAtual;
            }

            if (pedidoMaisCaro == null || precoPedidoAtual.compareTo(pedidoMaisCaro.getPreco().multiply(new BigDecimal(pedidoMaisCaro.getQuantidade()))) > 0) {
                pedidoMaisCaro = pedidoAtual;
            }
        }

        public void produtosVendidos() {
            assert this.pedidoAtual != null;
            montanteDeVendas = montanteDeVendas.add(this.pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade())));
            totalDeProdutosVendidos += pedidoAtual.getQuantidade();
            totalDePedidosRealizados++;
        }

        public void processaCategorias() {
            boolean processouCategoria = false;

            for (String categoriasProcessada : categoriasProcessadas) {
                if (pedidoAtual.getCategoria().equalsIgnoreCase(categoriasProcessada)) {
                    processouCategoria = true;
                    break;
                }
            }

            if (!processouCategoria) {
                totalDeCategorias++;

                if (categoriasProcessadas[categoriasProcessadas.length - 1] != null) {
                    categoriasProcessadas = Arrays.copyOf(categoriasProcessadas, categoriasProcessadas.length * 2);
                } else {
                    for (int k = 0; k < categoriasProcessadas.length; k++) {
                        if (categoriasProcessadas[k] == null) {
                            categoriasProcessadas[k] = pedidoAtual.getCategoria();
                            break;
                        }
                    }
                }
            }
        }

        public static void print() {
            logger.info("##### RELATÓRIO DE VALORES TOTAIS #####");
            logger.info("TOTAL DE PEDIDOS REALIZADOS: {}", totalDePedidosRealizados);
            logger.info("TOTAL DE PRODUTOS VENDIDOS: {}", totalDeProdutosVendidos);
            logger.info("TOTAL DE CATEGORIAS: {}", totalDeCategorias);
            logger.info("MONTANTE DE VENDAS: {}", NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
                    .format(montanteDeVendas.setScale(2, RoundingMode.HALF_DOWN)));
            logger.info("PEDIDO MAIS BARATO: {} ({})", NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
                            .format(pedidoMaisBarato.getPreco().multiply(new BigDecimal(pedidoMaisBarato.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN)),
                    pedidoMaisBarato.getProduto());
            logger.info("PEDIDO MAIS CARO: {} ({})\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
                            .format(pedidoMaisCaro.getPreco().multiply(new BigDecimal(pedidoMaisCaro.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN)),
                    pedidoMaisCaro.getProduto());
            logger.info("### FIM DO RELATÓRIO ###");
        }
    }
}

