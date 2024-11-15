package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    Pedido pedido;
    Cliente cliente;
    Vendedor vendedor;
    Producto producto;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Martin", "30", new ArrayList<>());
        vendedor = new Vendedor("Marcos", "28", new ArrayList<>());
        producto = new Producto("Heladera 500X", "Electrodomestico", 5000.0, this.vendedor, 10);
    }

    @Test
    void crearPedidoConMenorStock() {
        cliente.crearPedido(new AlContado(), new RetirarEnComercio(), producto, 9);
        assertEquals(1, this.cliente.getPedidos().size());
    }

    @Test
    void crearPedidoConIgualStock() {
        cliente.crearPedido(new AlContado(), new RetirarEnComercio(), producto, 10);
        assertEquals(1, this.cliente.getPedidos().size());
    }

    @Test
    void crearPedidoSinStock() {
        cliente.crearPedido(new AlContado(), new RetirarEnComercio(), producto, 12);
        assertEquals(0, this.cliente.getPedidos().size());
    }

    @Test
    void conocerProductosCategoria() {
        cliente.crearPedido(new AlContado(), new RetirarEnComercio(), producto, 2);
        Map<String, Integer> m = new HashMap<>();
        m.put(producto.getCategoria(), 2);
        producto = new Producto("Computadora Asus", "Computadora", 5000.0, this.vendedor, 10);
        cliente.crearPedido(new AlContado(), new RetirarEnComercio(), producto, 3);
        m.put(producto.getCategoria(), 3);
        assertEquals(m, this.cliente.conocerProductosCategoria());
    }
}