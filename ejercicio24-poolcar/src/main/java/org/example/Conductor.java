package org.example;

public class Conductor extends Usuario{
    private Vehiculo vehiculoPropio;

    public Conductor(String nombre, double saldo, Vehiculo vehiculoPropio) {
        super(nombre, saldo);
        this.vehiculoPropio = vehiculoPropio;
    }

    public Vehiculo getVehiculoPropio() {
        return vehiculoPropio;
    }

    //Es llamado desde viaje
    public void procesarViaje(Viaje v, double monto) {
        this.setSaldo(this.getSaldo() - (monto - (this.vehiculoPropio.getValorMercado() * 0.1)));
    }

    @Override
    public double getComision() {
        if (this.vehiculoPropio.getAnioFabricacion() < 5) {
            return 0.99;
        }
        return 0.90;
    }
}
