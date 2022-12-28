package br.com.alura.clientelo.application.controller.PedidoController.pedidoDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.clientelo.application.controller.clienteController.clienteDto.ClienteDto;
import br.com.alura.clientelo.domain.model.pedidoEntity.Pedido;
import br.com.alura.clientelo.domain.model.pedidoEntity.TipoDescontoPedidoEnum;

public class PedidoDto {

    private Long id;
    private ClienteDto cliente;
    private BigDecimal desconto;
    private TipoDescontoPedidoEnum tipoDesconto;
    private BigDecimal totalPedido;
    private LocalDate data;
    private List<ItemPedidoDto> itens = new ArrayList<>();

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = new ClienteDto(pedido.getCliente());
        this.desconto = pedido.getDesconto();
        this.tipoDesconto = pedido.getTipoDesconto();
        this.totalPedido = pedido.getTotalPedido();
        this.data = pedido.getData();
        this.itens = ItemPedidoDto.converter(pedido.getItens());// ajustar essa chamada
    }

    public static List<PedidoDto> converter(List<Pedido> objs) {
        List<PedidoDto> retorno = new ArrayList<>();
        objs.forEach(obj -> retorno.add(new PedidoDto(obj)));
        return retorno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipoDescontoPedidoEnum getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(TipoDescontoPedidoEnum tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemPedidoDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDto> itens) {
        this.itens = itens;
    }
}
