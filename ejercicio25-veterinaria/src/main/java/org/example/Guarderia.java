package org.example;

import java.time.LocalDate;

public class Guarderia extends Servicio{
    private int cantDias;
    private LocalDate fechaIngreso;

    public Guarderia(Mascota mascota, LocalDate fechaAtencion, int cantDias, LocalDate fechaIngreso) {
        super(mascota, fechaAtencion);
        this.cantDias = cantDias;
        this.fechaIngreso = fechaIngreso;
    }

    public int getCantDias() {
        return cantDias;
    }

    private double getCostoDia() {
        return 500.0;
    }

    private double getCostoDiaTotal(){
        return this.getCostoDia() + this.cantDias;
    }

    protected double calcularCosto() {
        if (this.getMascota().isCantMayor(5)) {
            return this.getCostoDiaTotal() * 0.90;
        }
        return this.getCostoDiaTotal();
    }
}
