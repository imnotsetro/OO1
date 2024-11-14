package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
class ConsultaMedicaTest {
    ConsultaMedica consulta;
    Mascota mascota;
    Medico medico;


    @BeforeEach
    void setUp() {
        mascota = new Mascota("Pulga", LocalDate.now().minusYears(4),"Bulldog",new LinkedList<>());
        medico = new Medico("Marcos", LocalDate.now().minusYears(5),4000.0);
    }

    @Test
    void calcularCostoTotalSabado() {
        consulta = new ConsultaMedica(mascota, medico, LocalDate.of(2024, 12, 7));
        assertEquals(4800.0,this.consulta.calcularCosto());
    }

    @Test
    void calcularCostoTotalDomingo() {
        consulta = new ConsultaMedica(mascota, medico, LocalDate.of(2024, 12, 8));
        assertEquals(5000.0,this.consulta.calcularCosto());
    }

    @Test
    void calcularCostoTotalLunes() {
        consulta = new ConsultaMedica(mascota, medico, LocalDate.of(2024, 12, 9));
        assertEquals(4800.0,this.consulta.calcularCosto());
    }
}