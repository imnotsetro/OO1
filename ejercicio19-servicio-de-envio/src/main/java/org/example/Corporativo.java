package org.example;

import java.time.LocalDate;

public class Corporativo extends Cliente {
    int cuil;

    public Corporativo(String direccion, String nombre, int cuil) {
        super(direccion, nombre);
        this.cuil = cuil;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    @Override
    protected double descuento() {
        return 0;
    }
}
