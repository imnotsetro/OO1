package org.example;

public class Pedido {
    private final Cliente cliente;
    private final Vendedor vendedor;
    private final Producto productoSolicitado;
    private final int cantSolicitada;
    private final MetodoPago formaDePago;
    private final Envio formaDeEnvio;

    public Pedido(Cliente cliente, MetodoPago formaDePago, Envio formaDeEnvio, Producto productoSolicitado, int cantSolicitada) {
            this.cliente = cliente;
            this.vendedor = productoSolicitado.getVendedor();
            this.productoSolicitado = productoSolicitado;
            this.cantSolicitada = cantSolicitada;
            this.formaDePago = formaDePago;
            this.formaDeEnvio = formaDeEnvio;
            this.productoSolicitado.retirarProductos(this.cantSolicitada);
    }

    public Producto getProductoSolicitado() {
        return productoSolicitado;
    }

    public int getCantSolicitada() {
        return cantSolicitada;
    }

    private double calcularCostoProducto(){
        return this.productoSolicitado.getPrecioTotal(this.cantSolicitada);
    }

    public double calcularCosto(){
        return this.calcularCostoProducto() + this.formaDeEnvio.calcularCosto() + this.formaDePago.calcularCosto(this.calcularCostoProducto());
    }
}
