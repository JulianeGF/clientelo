//package br.com.alura.clientelo;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.text.NumberFormat;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Locale;
//import java.util.Set;
//
//public class RelatorioSintetico {
//    private static final Logger logger = LoggerFactory.getLogger(RelatorioSintetico.class);
//
//    static List<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
//
//    String[] categorias = new String[10];
//
//    private BigDecimal montanteDeVendas = BigDecimal.ZERO;
//    private boolean processouCategoria = false;
//    private int totalDePedidosRealizados = 0;
//    private int totalDeProdutosVendidos = 0;
//    private Pedido pedidoMaisBarato = null;
//    private Pedido pedidoMaisCaro = null;
//    private int totalDeCategorias = 0;
//    private Pedido pedidoAtual = null;
//
//    BigDecimal precoPedidoAtual = this.pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade()));
//
//    public void pedidoMaisBaratoEMaisCaro() {
//        for (Pedido pedido : pedidos) {
//            this.pedidoAtual = pedido;
//
//            if (pedidoAtual == null) {
//                break;
//            }
//
//            if (pedidoMaisBarato == null || precoPedidoAtual.compareTo(pedidoMaisBarato.getPreco().multiply(new BigDecimal(pedidoMaisBarato.getQuantidade()))) < 0) {
//                pedidoMaisBarato = pedidoAtual;
//            }
//
//            if (pedidoMaisCaro == null || precoPedidoAtual.compareTo(pedidoMaisCaro.getPreco().multiply(new BigDecimal(pedidoMaisCaro.getQuantidade()))) > 0) {
//                pedidoMaisCaro = pedidoAtual;
//            }
//        }
//
//        public void produtosVendidos() {
//            assert this.pedidoAtual != null;
//            montanteDeVendas = montanteDeVendas.add(this.pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade())));
//            totalDeProdutosVendidos += pedidoAtual.getQuantidade();
//            totalDePedidosRealizados++;
//        }
//
//        public void processaCategorias() {
//            for (String categoriasProcessada : categorias) {
//                if (pedidoAtual.getCategoria().equalsIgnoreCase(categoriasProcessada)) {
//                    processouCategoria = true;
//                    break;
//                }
//            }
//
//            if (!processouCategoria) {
//                totalDeCategorias++;
//
//                if (categorias [categorias.length - 1] != null) {
//                    categorias = Arrays.copyOf(categorias, categorias.length * 2);
//                } else {
//                    for (int k = 0; k < categorias.length; k++) {
//                        if (categorias[k] == null) {
//                            categorias[k] = pedidoAtual.getCategoria();
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        public void print(List<Pedido> pedidos) {
//            logger.info("##### RELATÓRIO DE VALORES TOTAIS #####");
//            logger.info("TOTAL DE PEDIDOS REALIZADOS: {}", totalDePedidosRealizados);
//            logger.info("TOTAL DE PRODUTOS VENDIDOS: {}", totalDeProdutosVendidos);
//            logger.info("TOTAL DE CATEGORIAS: {}", totalDeCategorias);
//            logger.info("MONTANTE DE VENDAS: {}", NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
//                    .format(montanteDeVendas.setScale(2, RoundingMode.HALF_DOWN)));
//            logger.info("PEDIDO MAIS BARATO: {} ({})", NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
//                            .format(pedidoMaisBarato.getPreco().multiply(new BigDecimal(pedidoMaisBarato.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN)),
//                    pedidoMaisBarato.getProduto());
//            logger.info("PEDIDO MAIS CARO: {} ({})\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR"))
//                            .format(pedidoMaisCaro.getPreco().multiply(new BigDecimal(pedidoMaisCaro.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN)),
//                    pedidoMaisCaro.getProduto());
//            logger.info("### FIM DO RELATÓRIO ###");
//        }
//    }
//}

