package org.example;

import java.time.LocalDate;
import java.util.List;

public class Empleado {
    private String nombre;
    private String apellido;
    private int CUIL;
    private LocalDate fechaNacimiento;
    private boolean tieneHijo;
    private boolean tieneConyuge;
    private List<Contrato> contratos;

    public Empleado(String nombre, String apellido, int CUIL, LocalDate fechaNacimiento, boolean tieneHijo, boolean tieneConyuge, List<Contrato> contratos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CUIL = CUIL;
        this.fechaNacimiento = fechaNacimiento;
        this.tieneHijo = tieneHijo;
        this.tieneConyuge = tieneConyuge;
        this.contratos = contratos;
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

    public List<Contrato> getContratos() {
        return contratos;
    }
}
