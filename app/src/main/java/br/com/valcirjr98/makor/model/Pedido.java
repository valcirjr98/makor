package br.com.valcirjr98.makor.model;

public class Pedido {

    private Double dataDoPedido;

    public Pedido(){

    }

    public Pedido(Double dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    public Double getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(Double dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }
}
