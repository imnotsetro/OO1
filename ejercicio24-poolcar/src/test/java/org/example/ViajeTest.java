package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ViajeTest {
    Viaje viaje;
    Vehiculo vehiculo;
    Conductor conductor;
    Pasajero pasajero;

    @Test
    void agregarPasajero() {
        vehiculo = new Vehiculo(conductor, "alguna descripcion", 4, Year.of(2020), 1000.0);
        viaje = new Viaje("test", "test", 2500.0, vehiculo, LocalDate.now());
        pasajero = new Pasajero("Michael", 5000.0, new ArrayList<>());
        viaje.agregarPasajero(pasajero);
        assertEquals(2, this.viaje.getCantPasajeros());
        viaje.agregarPasajero(pasajero);
        assertEquals(3, this.viaje.getCantPasajeros());
        viaje.agregarPasajero(pasajero);
        assertEquals(4, this.viaje.getCantPasajeros());
        viaje.agregarPasajero(pasajero);
        assertEquals(4, this.viaje.getCantPasajeros());
    }

    @Test
    void procesarViaje() {
        vehiculo = new Vehiculo(conductor, "alguna descripcion", 4, Year.of(2020), 1000.0);
        conductor = new Conductor("Javier", 10000.0, new ArrayList<>(), vehiculo);
        vehiculo.setPropietario(conductor);
        viaje = new Viaje("test", "test", 2500.0, vehiculo, LocalDate.now());
        pasajero = new Pasajero("Michael", 5000.0, new ArrayList<>());
        viaje.agregarPasajero(pasajero);
        viaje.procesarViaje();
        assertEquals(3750, this.pasajero.getSaldo());
        assertEquals(8850, this.conductor.getSaldo());
    }
}