package org.example;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class TestEmpleado {

    private Empleado empleadoPlanta;
    private Empleado empleadoHoras;
    private ContratoDePlanta contratoDePlanta;
    private ContratoPorHoras contratoPorHoras;

    @BeforeEach
    void setUp() {
        contratoDePlanta = new ContratoDePlanta(
                LocalDate.of(2010, 1, 1),
                null,
                100, // montoHijo
                200, // montoConyuge
                3000 // sueldoMensual
        );
        empleadoPlanta = new Empleado(
                "Juan",
                "Perez",
                12345678,
                LocalDate.of(1985, 5, 15),
                true,  // tieneHijo
                true   // tieneConyuge
        );
        contratoDePlanta.setPropietario(empleadoPlanta);
        empleadoPlanta.getContratosHoras().clear(); // sin contrato por horas
        empleadoPlanta.getContratosPlanta().setPropietario(empleadoPlanta);

        // Configuración para empleado con contrato por horas
        contratoPorHoras = new ContratoPorHoras(
                LocalDate.of(2023, 1, 1),
                null,
                50,    // valorHora
                160,   // cantHoras
                LocalDate.of(2024, 12, 31) // fechaFin
        );
        empleadoHoras = new Empleado(
                "Maria",
                "Lopez",
                87654321,
                LocalDate.of(1990, 3, 20),
                false,  // sin hijo
                false   // sin conyuge
        );
        contratoPorHoras.setPropietario(empleadoHoras);
        empleadoHoras.getContratosHoras().add(contratoPorHoras); // contrato activo
    }

    @Test
    void testCalculoMontoTotalContratoDePlanta() {
        // Verificar cálculo del monto total para contrato de planta
        double total = contratoDePlanta.getTotal();
        assertEquals(3300, total, "El monto total de contrato de planta debería ser 3300");
    }

    @Test
    void testCalculoMontoTotalContratoPorHoras() {
        // Verificar cálculo del monto total para contrato por horas
        double total = contratoPorHoras.getTotal();
        assertEquals(8000, total, "El monto total de contrato por horas debería ser 8000");
    }

    @Test
    void testBonusAntiguedadEmpleadoPlanta() {
        // Verificar el cálculo del bono de antigüedad para empleado con contrato de planta
        double bonus = empleadoPlanta.getBonusAntiguedadEmpleado();
        assertEquals(1.5, bonus, "El bono de antigüedad para 10 años debería ser 1.5");
    }

    @Test
    void testBonusAntiguedadEmpleadoPorHoras() {
        double bonus = empleadoHoras.getBonusAntiguedadEmpleado();
        assertEquals(1.0, bonus, "El bono de antigüedad para antigüedad menor a 5 años debería ser 1.0");
    }

    @Test
    void testCalculoReciboEmpleadoPlanta() {
        Recibo recibo = new Recibo(empleadoPlanta);
        double expectedMonto = contratoDePlanta.getTotal() * empleadoPlanta.getBonusAntiguedadEmpleado();
        assertEquals(expectedMonto, recibo.getMontoTotal(), "El monto total del recibo debería coincidir con el cálculo esperado");
    }

    @Test
    void testCalculoReciboEmpleadoPorHoras() {
        // Verificar el cálculo del monto total en recibo de sueldo para empleado por horas
        Recibo recibo = new Recibo(empleadoHoras);
        double expectedMonto = contratoPorHoras.getTotal() * empleadoHoras.getBonusAntiguedadEmpleado();
        assertEquals(expectedMonto, recibo.getMontoTotal(), "El monto total del recibo debería coincidir con el cálculo esperado");
    }
}
