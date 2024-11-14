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

    @Override
    public double getComision() {
        if (this.vehiculoPropio.esMenosViejo(5)) {
            return 0.99;
        }
        return 0.90;
    }

    public void pagarViaje(double monto) {
        this.descontarSaldo(monto - (this.vehiculoPropio.getValorMercado() * 0.1));
    }

}
