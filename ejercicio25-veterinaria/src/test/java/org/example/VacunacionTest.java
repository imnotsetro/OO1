package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VacunacionTest {
    Vacunacion vacuna;
    Mascota mascota;
    Medico medico;

    @BeforeEach
    void setUp() {
        mascota = new Mascota("Pulga",LocalDate.now().minusYears(4),"Bulldog",new LinkedList<>());
        medico = new Medico("Marcos", LocalDate.now().minusYears(5),4000.0);
        vacuna = new Vacunacion(mascota, LocalDate.now(), medico, "Corona", 2000.0);
    }

    @Test
    void calcularCosto() {
        assertEquals(6500.0, vacuna.calcularCosto());
    }
}