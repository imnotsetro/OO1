package org.example;

public class Pedido {
    private Cliente cliente;
    private Vendedor vendedor;
    private Producto productoSolicitado;
    private int cantSolicitada;
    private String formaDePago;
    private String formaDeEnvio;

    public Pedido(Cliente cliente, Vendedor vendedor, Producto productoSolicitado, int cantSolicitada, String formaDePago, String formaDeEnvio) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.productoSolicitado = productoSolicitado;
        this.cantSolicitada = cantSolicitada;
        this.formaDePago = formaDePago;
        this.formaDeEnvio = formaDeEnvio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProductoSolicitado() {
        return productoSolicitado;
    }

    public int getCantSolicitada() {
        return cantSolicitada;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public String getFormaDeEnvio() {
        return formaDeEnvio;
    }

    //Calcular el costo total de un pedido. Dado un pedido, se retorna su costo total que se calcula de la siguiente forma: (precio final en base a la forma de pago seleccionada) + (costo de envío en base a la forma de envío seleccionada).
    //Si la forma de pago es "al contado", el precio final es el que se indica en el producto
    //Si la forma de pago es "6 cuotas", el precio final se incrementa en un 20%
    //Si la forma de envío es  "retirar en el comercio" no hay costo adicional de envío.
    //Si la forma de envío es "retirar en sucursal del correo" el costo es de $3000.
    //Si la forma de envío es "express a domicilio" el costo es $0.5 por Km de distancia entre la dirección del vendedor y del cliente. Asuma que existe una clase CalculadoraDeDistancia, cuyas instancias entienden el mensaje #distanciaEntre que recibe dos direcciones y retorna la distancia en Km entre ellas. Por ahora trabaje con una implementación propia para pruebas que siempre retorna 100 (sin importar las direcciones recibidas).

    public double calcularCosto(){
        double costo = this.getProductoSolicitado().getPrecio() * this.getCantSolicitada();
        if (this.formaDePago == "6 cuotas") { costo = costo * 1.20; }
        if (this.formaDeEnvio == "retirar en sucursal del correo"){ costo = costo + 3000.0; }
            else if(this.formaDeEnvio == "express a domicilio") {
                CalculadoraDeDistancia cdd = new CalculadoraDeDistancia();
                costo = costo - (0.5 * cdd.distanciaEntre(this.cliente.getDireccion(), this.vendedor.getDireccion()));
            }
        return costo;
    }
}
