package org.example;

public class Producto {
    private final String nombre;
    private final String categoria;
    private final double precio;
    private final Vendedor vendedor;
    private int cantUnidades;

    public Producto(String nombre, String categoria, double precio, Vendedor vendedor, int cantUnidades) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.vendedor = vendedor;
        this.cantUnidades = cantUnidades;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantUnidades() {
        return cantUnidades;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public boolean existeStock(int cant){
        return this.cantUnidades >= cant;
    }

    public void retirarProductos(int cant){
        this.cantUnidades -= cant;
    }

    public double getPrecioTotal(int cant){
        return this.precio * cant;
    }
}
