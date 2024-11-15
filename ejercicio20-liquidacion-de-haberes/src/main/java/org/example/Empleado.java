package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private final String nombre;
    private final String apellido;
    private final int CUIL;
    private final LocalDate fechaNacimiento;
    private final boolean tieneHijo;
    private final boolean tieneConyuge;
    private List<ContratoPorHoras> contratosHoras;
    private ContratoDePlanta contratosPlanta;

    public Empleado(String nombre, String apellido, int CUIL, LocalDate fechaNacimiento, boolean tieneHijo, boolean tieneConyuge) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CUIL = CUIL;
        this.fechaNacimiento = fechaNacimiento;
        this.tieneHijo = tieneHijo;
        this.tieneConyuge = tieneConyuge;
        this.contratosHoras = new ArrayList<>();
        this.contratosHoras = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCUIL() {
        return CUIL;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isTieneHijo() {
        return tieneHijo;
    }

    public boolean isTieneConyuge() {
        return tieneConyuge;
    }

    public List<ContratoPorHoras> getContratosHoras() {
        return contratosHoras;
    }

    public ContratoDePlanta getContratosPlanta() {
        return contratosPlanta;
    }

    public double getBonusAntiguedadEmpleado() {
        double bonus = 1.0;
        int aux = this.getContratosHoras().stream().mapToInt(ch -> ch.getAntiguedadContrato()).sum();
        aux += this.getContratosPlanta().getAntiguedadContrato();
        int antiguedad = aux / 365;
        if (antiguedad >= 20) {
            bonus = 2.0;
        } else if (antiguedad >= 15) {
            bonus = 1.7;
        } else if (antiguedad >= 10) {
            bonus = 1.5;
        } else if (antiguedad >= 5) {
            bonus = 1.3;
        }
        return bonus;
    }

    public double getTotalContratos(){
        double monto = this.getContratosHoras().stream().filter(ch -> ch.isActivo()).mapToDouble(ch -> ch.getTotal()).sum();
        monto += this.getContratosPlanta().getTotal();
        return monto;
    }
}
