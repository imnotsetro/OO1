package org.example;

import java.util.List;

public abstract class Usuario {
    private final String nombre;
    private double saldo;
    private List<Viaje> viajesRealizados;

    public Usuario(String nombre, double saldo, List<Viaje> viajesRealizados) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.viajesRealizados = viajesRealizados;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setViajesRealizados(List<Viaje> viajesRealizados) {
        this.viajesRealizados = viajesRealizados;
    }

    public List<Viaje> getViajesRealizados() {
        return viajesRealizados;
    }

    public boolean tieneSaldo(){
        return this.getSaldo() > 0;
    }

    abstract public double getComision();

    abstract public void pagarViaje(double monto);

    protected void procesarViaje(Viaje viaje, double monto){
        this.pagarViaje(monto);
        this.viajesRealizados.add(viaje);
    }

    protected void cargarSaldo(double monto){
        this.saldo += (monto * this.getComision());
    }

    protected void descontarSaldo(double monto){
        this.saldo -= monto;
    }
}
