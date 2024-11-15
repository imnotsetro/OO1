package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {
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
    void calcularCostoAlContado() {
        pedido = new Pedido(cliente, new AlContado(), new RetirarEnComercio(), producto, 2);
        assertEquals(10000.0,this.pedido.calcularCosto());
    }

    @Test
    void calcularCosto6Cuotas() {
        pedido = new Pedido(cliente, new Cuotas(), new RetirarEnComercio(), producto, 2);
        assertEquals(12000.0,this.pedido.calcularCosto());
    }

    @Test
    void calcularCostoRetirarComercio() {
        pedido = new Pedido(cliente, new AlContado(), new RetirarEnComercio(), producto, 2);
        assertEquals(10000.0,this.pedido.calcularCosto());
    }

    @Test
    void calcularCostoRetirarEnSucursal() {
        pedido = new Pedido(cliente, new AlContado(), new RetirarEnSucursal(), producto, 2);
        assertEquals(13000.0,this.pedido.calcularCosto());
    }

    @Test
    void calcularCostoExpressDomicilio() {
        pedido = new Pedido(cliente, new AlContado(), new ExpressDomicilio(this.cliente.getDireccion(), this.vendedor.getDireccion()), producto, 2);
        assertEquals(10000.0 + (0.5 * 100),this.pedido.calcularCosto());
    }
}