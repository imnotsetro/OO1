package org.example;

import java.time.LocalDate;

public class Guarderia extends Servicio{
    private final int cantDias;
    private LocalDate fechaIngreso;

    public Guarderia(Mascota mascota, LocalDate fechaAtencion, int cantDias) {
        super(mascota, fechaAtencion);
        this.cantDias = cantDias;
    }

    public int getCantDias() {
        return cantDias;
    }

    private double getCostoDia() {
        return 500.0;
    }

    private double getCostoDiaTotal(){
        return this.getCostoDia() * this.cantDias;
    }

    public double calcularCosto() {
        if (this.getMascota().isCantMayor(5)) {
            return this.getCostoDiaTotal() * 0.90;
        }
        return this.getCostoDiaTotal();
    }
}
