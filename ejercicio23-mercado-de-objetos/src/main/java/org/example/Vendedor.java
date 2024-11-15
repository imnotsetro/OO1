package org.example;

import java.util.List;

public class Vendedor extends Persona{
    private final List<Producto> productoEnVenta;

    public Vendedor(String nombre, String direccion, List<Producto> productoEnVenta) {
        super(nombre, direccion);
        this.productoEnVenta = productoEnVenta;
    }
}
