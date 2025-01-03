package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConductorTest {
    Conductor conductor;
    Vehiculo vehiculo;

    @Test
    void cargarSaldoAntiguedad4Anios() {
        vehiculo = new Vehiculo(conductor, "alguna descripcion", 4, Year.of(2020), 5000.0);
        conductor = new Conductor("Javier", 500, new ArrayList<>(), vehiculo);
        this.conductor.cargarSaldo(1000);
        assertEquals(500.0 + 1000.0 * 0.99, this.conductor.getSaldo());
    }

    @Test
    void cargarSaldoAntiguedad5Anios() {
        vehiculo = new Vehiculo(conductor, "alguna descripcion", 4, Year.of(2019), 5000.0);
        conductor = new Conductor("Javier", 500, new ArrayList<>(), vehiculo);
        this.conductor.cargarSaldo(1000);
        assertEquals(500.0 + 1000.0 * 0.90, this.conductor.getSaldo());
    }

    @Test
    void cargarSaldoAntiguedad6Anios() {
        vehiculo = new Vehiculo(conductor, "alguna descripcion", 4, Year.of(2018), 5000.0);
        conductor = new Conductor("Javier", 500, new ArrayList<>(), vehiculo);
        this.conductor.cargarSaldo(1000);
        assertEquals(500.0 + 1000.0 * 0.90, this.conductor.getSaldo());
    }
}