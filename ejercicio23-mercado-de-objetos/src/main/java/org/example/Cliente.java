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

    public void crearPedido(String formaDePago, String formaDeEnvio, Producto unProducto, int cantSolicitada){
        if ((unProducto.getCantUnidades() - cantSolicitada) >= 0) {
            this.pedidos.add(new Pedido(this,unProducto, cantSolicitada,formaDePago,formaDeEnvio));
        }
    }

    public Map<String, Integer> conocerProductosCategoria(){
        Map<String, Integer> m = pedidos.stream()
                .collect(Collectors.toMap(
                pedido -> pedido.getProductoSolicitado().getCategoria(),
                        Pedido::getCantSolicitada,
                        Integer::sum
        ));
        return m;
    }
}
