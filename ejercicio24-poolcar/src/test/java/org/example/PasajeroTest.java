package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PasajeroTest {
    Pasajero pasajero;
    Conductor conductor;
    Vehiculo vehiculo;

    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculo(conductor, "alguna descripcion", 4, Year.of(2020), 5000.0);
    }

    @Test
    void pagarViajeSinViajes() {
        pasajero = new Pasajero("Michael", 5000.0, new ArrayList<>());
        this.pasajero.pagarViaje(1000);
        assertEquals(4000.0, this.pasajero.getSaldo());
    }

    @Test
    void pagarViajeConViajes() {
        ArrayList<Viaje> lista = new ArrayList<>();
        lista.add(new Viaje("test", "test", 1000.0, vehiculo, LocalDate.now()));
        pasajero = new Pasajero("Michael", 5000.0, lista);
        this.pasajero.pagarViaje(1000.0);
        assertEquals(4500.0, this.pasajero.getSaldo());
    }

    @Test
    void cargarSaldoUltimoViaje31dias() {
        ArrayList<Viaje> lista = new ArrayList<>();
        lista.add(new Viaje("test", "test", 1000.0, vehiculo, LocalDate.now().minusDays(31)));
        pasajero = new Pasajero("Michael", 5000.0, lista);
        this.pasajero.cargarSaldo(500.0);
        assertEquals(5000.0 + (500.0 * 0.90), this.pasajero.getSaldo());
    }

    @Test
    void cargarSaldoUltimoViaje30dias() {
        ArrayList<Viaje> lista = new ArrayList<>();
        lista.add(new Viaje("test", "test", 1000.0, vehiculo, LocalDate.now().minusDays(30)));
        pasajero = new Pasajero("Michael", 5000.0, lista);
        this.pasajero.cargarSaldo(500.0);
        assertEquals(5000.0 + (500.0 * 1), this.pasajero.getSaldo());
    }

    @Test
    void cargarSaldoUltimoViaje29dias() {
        ArrayList<Viaje> lista = new ArrayList<>();
        lista.add(new Viaje("test", "test", 1000.0, vehiculo, LocalDate.now().minusDays(29)));
        pasajero = new Pasajero("Michael", 5000.0, lista);
        this.pasajero.cargarSaldo(500.0);
        assertEquals((5000.0 + (500.0 * 1)), this.pasajero.getSaldo());
    }
}