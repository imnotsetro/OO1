package org.example;

public abstract class Usuario {
    private String nombre;
    private double saldo;

    public Usuario(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    abstract public double getComision();

    protected void cargarSaldo(Double monto){
        this.saldo = this.saldo + this.getComision();
    }
}
