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

    @BeforeEach
    void setUp() {
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4),"Bulldog",new LinkedList<>());
        guarderia = new Guarderia(mascota, LocalDate.now(), 5);
    }

    @Test
    void calcularCosto() {
        assertEquals(2500, this.guarderia.calcularCosto());
    }
}