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
        if (this.viajes.stream().findAny().filter(v -> v.getFechaViaje().isBefore(LocalDate.now().minusDays(30))) != null) {
            return 0.90;
        }
        return 1.0;
    }

    public void registrarViaje(Viaje v) {
        if ((v.getEspacioDisponible() - 1) > 0) {
            this.viajes.add(v);
            v.agregarPasajero();
        }
    }

    public void procesarViaje(Viaje v) {
        if (this.viajes.stream().findAny() != null) {
            this.setSaldo(this.getSaldo() - (v.getCostoTotalIndividual() - 500.0));
        } else {
            this.setSaldo(this.getSaldo() - (v.getCostoTotalIndividual()));
        }
    }
}
