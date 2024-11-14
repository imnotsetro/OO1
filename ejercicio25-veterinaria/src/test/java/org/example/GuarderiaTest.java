package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Guard;
import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
class GuarderiaTest {
    Mascota mascota;
    Guarderia guarderia;

    @Test
    void calcularCostoMenor5() {
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4),"Bulldog",new LinkedList<>());
        guarderia = new Guarderia(mascota, LocalDate.now(), 5);
        assertEquals(2500, this.guarderia.calcularCosto());
    }

    @Test
    void calcularCostoMayor5() {
        LinkedList<Servicio> L = new LinkedList<Servicio>();
        for (int i = 0; i < 5; i++) {
            L.add(guarderia);
        }
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4),"Bulldog",L);
        guarderia = new Guarderia(mascota, LocalDate.now(), 5);
        assertEquals(2500 * 0.90, this.guarderia.calcularCosto());
    }
}