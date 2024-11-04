package org.example;

import java.util.List;

public class Vendedor extends Persona{
    private List<Producto> productoEnVenta;

    public Vendedor(String nombre, String direccion, List<Producto> productoEnVenta) {
        super(nombre, direccion);
        this.productoEnVenta = productoEnVenta;
    }

    public List<Producto> getProductoEnVenta() {
        return productoEnVenta;
    }
}
