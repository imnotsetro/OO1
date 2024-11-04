package org.example;

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private Vendedor vendedor;
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
}
