package ar.edu.unlp.objetos.uno.ejercicio17_alquiler_de_propiedades;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAlquiler {

    private Propiedad propiedad;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        propiedad = new Propiedad("Casa de Campo",500.0, "Calle Falsa 123","flexible");
        usuario = new Usuario("Juan Pérez","Calle Verdadera 456", 12345678);
        usuario.agregarPropiedad(propiedad);
    }

    @Test
    void testDisponibilidadSinReservas() {
        LocalDate fechaInicio = LocalDate.of(2024, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2024, 10, 25);
        assertTrue(propiedad.disponibilidad(fechaInicio, fechaFinal));
    }

    @Test
    void testDisponibilidadConReservasEnElPeriodo() {
        LocalDate fechaReservaInicio = LocalDate.of(2024, 10, 20);
        LocalDate fechaReservaFinal = LocalDate.of(2024, 10, 25);
        Reserva reserva = new Reserva(fechaReservaInicio, fechaReservaFinal, propiedad);
        propiedad.getReservas().add(reserva);
        LocalDate fechaInicio = LocalDate.of(2024, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2024, 10, 25);
        assertFalse(propiedad.disponibilidad(fechaInicio, fechaFinal));
    }

    @Test
    void testReservarPropiedad() {
        LocalDate fechaInicio = LocalDate.of(2024, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2024, 10, 25);

        assertTrue(propiedad.disponibilidad(fechaInicio, fechaFinal));

        // Crear y agregar la reserva
        Reserva nuevaReserva = new Reserva(fechaInicio, fechaFinal, propiedad);
        propiedad.getReservas().add(nuevaReserva);

        // Verificar que la reserva esté creada
        assertEquals(1, propiedad.getReservas().size());
        assertFalse(propiedad.disponibilidad(fechaInicio, fechaFinal));
    }

    @Test
    void testCancelarReservaFlexible() {
        LocalDate fechaInicio = LocalDate.of(2025, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2025, 10, 25);

        Reserva reserva = new Reserva(fechaInicio, fechaFinal, propiedad);
        propiedad.getReservas().add(reserva);

        // Cancelar la reserva
        assertEquals(500.0*3.0,propiedad.cancelarReserva(reserva));

        // Verificar que la reserva haya sido cancelada
        assertTrue(propiedad.getReservas().isEmpty());
        assertTrue(propiedad.disponibilidad(fechaInicio, fechaFinal));
    }

    @Test
    void testCancelarReservaModerada() {
        LocalDate fechaInicio = LocalDate.of(2025, 10, 23);
        LocalDate fechaFinal = LocalDate.of(2025, 10, 25);
        propiedad.setPoliticaCancelacion("moderada");
        Reserva reserva = new Reserva(fechaInicio, fechaFinal, propiedad);
        propiedad.getReservas().add(reserva);

        // Cancelar la reserva
        assertEquals((500.0*2.0),propiedad.cancelarReserva(reserva));

        // Verificar que la reserva haya sido cancelada
        assertTrue(propiedad.getReservas().isEmpty());
        assertTrue(propiedad.disponibilidad(fechaInicio, fechaFinal));
    }

    @Test
    void testCancelarReservaEstricta() {
        LocalDate fechaInicio = LocalDate.of(2025, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2025, 10, 25);
        propiedad.setPoliticaCancelacion("estricta");
        Reserva reserva = new Reserva(fechaInicio, fechaFinal, propiedad);
        propiedad.getReservas().add(reserva);

        // Cancelar la reserva
        assertEquals(0.0,propiedad.cancelarReserva(reserva));

        // Verificar que la reserva haya sido cancelada
        assertTrue(propiedad.getReservas().isEmpty());
        assertTrue(propiedad.disponibilidad(fechaInicio, fechaFinal));
    }
}
