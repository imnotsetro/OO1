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
    void registrarViajeA3Dias() {
        conductor = new Conductor("Javier", 500, new ArrayList<>(), vehiculo);
        vehiculo.setPropietario(conductor);
        Viaje viaje = new Viaje("testOrigen", "testDestino", 5000.0, vehiculo, LocalDate.now().minusDays(3));
        pasajero = new Pasajero("Michael", 5000.0, new ArrayList<>());
        pasajero.registrarViaje(viaje);
        assertEquals(2, viaje.getCantPasajeros());
    }

    @Test
    void registrarViajeA2Dias() {
        conductor = new Conductor("Javier", 500, new ArrayList<>(), vehiculo);
        vehiculo.setPropietario(conductor);
        Viaje viaje = new Viaje("testOrigen", "testDestino", 5000.0, vehiculo, LocalDate.now().minusDays(2));
        pasajero = new Pasajero("Michael", 5000.0, new ArrayList<>());
        pasajero.registrarViaje(viaje);
        assertEquals(1, viaje.getCantPasajeros());
    }

    @Test
    void registrarViajeA1Dias() {
        conductor = new Conductor("Javier", 500, new ArrayList<>(), vehiculo);
        vehiculo.setPropietario(conductor);
        Viaje viaje = new Viaje("testOrigen", "testDestino", 5000.0, vehiculo, LocalDate.now().minusDays(1));
        pasajero = new Pasajero("Michael", 5000.0, new ArrayList<>());
        pasajero.registrarViaje(viaje);
        assertEquals(1, viaje.getCantPasajeros());
    }

    @Test
    void registrarViajeSaldoNegativo() {
        conductor = new Conductor("Javier", 500, new ArrayList<>(), vehiculo);
        vehiculo.setPropietario(conductor);
        Viaje viaje = new Viaje("testOrigen", "testDestino", 5000.0, vehiculo, LocalDate.now().minusDays(1));
        pasajero = new Pasajero("Michael", 0, new ArrayList<>());
        pasajero.registrarViaje(viaje);
        assertEquals(1, viaje.getCantPasajeros());
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