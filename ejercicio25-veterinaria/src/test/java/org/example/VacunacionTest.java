package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacunacionTest {
    Vacunacion vacuna;
    Mascota mascota;
    Medico medico;

    @BeforeEach
    void setUp() {
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4), "Bulldog", new LinkedList<>());
        medico = new Medico("Marcos", LocalDate.now().minusYears(5), 4000.0);
    }

    @Test
    void calcularCostoSabado() {
        vacuna = new Vacunacion(mascota, LocalDate.of(2024, 12, 7), medico, "Corona", 2000.0);
        assertEquals(6500.0, vacuna.calcularCosto());
    }

    @Test
    void calcularCostoDomingo() {
        vacuna = new Vacunacion(mascota, LocalDate.of(2024, 12, 8), medico, "Corona", 2000.0);
        assertEquals(6700.0, vacuna.calcularCosto());
    }

    @Test
    void calcularCostoLunes() {
        vacuna = new Vacunacion(mascota, LocalDate.of(2024, 12, 9), medico, "Corona", 2000.0);
        assertEquals(6500.0, vacuna.calcularCosto());
    }
}