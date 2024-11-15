package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario{

    public Pasajero(String nombre, double saldo, List<Viaje> viajesRealizados) {
        super(nombre, saldo, viajesRealizados);
    }

    @Override
    public double getComision(){
        if (this.getViajesRealizados().stream().findAny().filter(v -> v.fechaAnteriorADias(30)).isPresent()) {
            return 0.90;
        }
        return 1.0;
    }

    public void registrarViaje(Viaje viaje) {
        viaje.agregarPasajero(this);
    }

    public void pagarViaje(double monto) {
        if (!this.getViajesRealizados().isEmpty()) {
            this.descontarSaldo(monto - 500.0);
        } else {
            this.descontarSaldo(monto);
        }
    }
}
