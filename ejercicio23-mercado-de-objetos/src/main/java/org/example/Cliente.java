package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cliente extends Persona{
    List<Pedido> pedidos;

    public Cliente(String nombre, String direccion, List<Pedido> pedidos) {
        super(nombre, direccion);
        this.pedidos = pedidos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void crearPedido(MetodoPago formaDePago, Envio formaDeEnvio, Producto unProducto, int cantSolicitada){
        if (unProducto.existeStock(cantSolicitada)){
            this.pedidos.add(new Pedido(this,formaDePago, formaDeEnvio, unProducto, cantSolicitada));
        }
    }

    public Map<String, Integer> conocerProductosCategoria(){
        return pedidos.stream()
                .collect(Collectors.groupingBy(
                        pedido -> pedido.getProductoSolicitado().getCategoria(),
                        Collectors.summingInt(Pedido::getCantSolicitada)
                ));
    }
}
