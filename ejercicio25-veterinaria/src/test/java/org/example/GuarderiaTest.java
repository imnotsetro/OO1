package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Guard;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
class GuarderiaTest {
    Mascota mascota;
    Guarderia guarderia;

    @Test
    void calcularCostoServiciosVacio() {
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4),"Bulldog",new ArrayList<>());
        guarderia = new Guarderia(mascota, LocalDate.now(), 5);
        assertEquals(2500, this.guarderia.calcularCosto());
    }

    @Test
    void calcularCostoServiciosIgual4() {
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4),"Bulldog",new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            mascota.darAltaServicio(guarderia);
        }
        guarderia = new Guarderia(mascota, LocalDate.now(), 5);
        assertEquals(2500, this.guarderia.calcularCosto());
    }

    @Test
    void calcularCostoServiciosIgual5() {
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4),"Bulldog",new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            mascota.darAltaServicio(guarderia);
        }
        guarderia = new Guarderia(mascota, LocalDate.now(), 5);
        assertEquals(2500 * 0.90, this.guarderia.calcularCosto());
    }

    @Test
    void calcularCostoServiciosMayor5() {
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4),"Bulldog",new ArrayList<>());
        for (int i = 0; i < 6; i++) {
            mascota.darAltaServicio(guarderia);
        }
        guarderia = new Guarderia(mascota, LocalDate.now(), 5);
        assertEquals(2500 * 0.90, this.guarderia.calcularCosto());
    }

}