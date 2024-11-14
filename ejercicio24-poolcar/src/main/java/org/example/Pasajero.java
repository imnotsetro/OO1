package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario{
    private List<Viaje> viajes;

    public Pasajero(String nombre, double saldo, List<Viaje> viajes) {
        super(nombre, saldo);
        this.viajes = new ArrayList<>();
    }

    @Override
    public double getComision(){
        if (this.viajes.stream().findAny().filter(v -> v.fechaAnteriorADias(30)).isPresent()) {
            return 0.90;
        }
        return 1.0;
    }

    public void registrarViaje(Viaje viaje) {
        viaje.agregarPasajero(this);
    }

    public void pagarViaje(double monto) {
        if (!this.viajes.isEmpty()) {
            this.descontarSaldo(monto - 500.0);
        } else {
            this.descontarSaldo(monto);
        }
    }
}
