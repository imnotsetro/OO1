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
        propiedad = new Propiedad("Casa de Campo",500.0, "Calle Falsa 123");
        usuario = new Usuario("Juan Pérez","Calle Verdadera 456", 12345678);
        usuario.agregarPropiedad(propiedad);
    }

    @Test
    void testDisponibilidadSinReservas() {
        LocalDate fechaInicio = LocalDate.of(2024, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2024, 10, 25);
        assertTrue(propiedad.disponibilidad(fechaInicio, fechaFinal),
                "La propiedad debería estar disponible si no hay reservas.");
    }

    @Test
    void testDisponibilidadConReservasEnElPeriodo() {
        // Creamos una reserva que coincida con las fechas de prueba
        LocalDate fechaReservaInicio = LocalDate.of(2024, 10, 20);
        LocalDate fechaReservaFinal = LocalDate.of(2024, 10, 25);
        Reserva reserva = new Reserva(fechaReservaInicio, fechaReservaFinal, propiedad);
        propiedad.getReservas().add(reserva);
        LocalDate fechaInicio = LocalDate.of(2024, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2024, 10, 25);
        assertFalse(propiedad.disponibilidad(fechaInicio, fechaFinal),
                "La propiedad no debería estar disponible si hay reservas en el período.");
    }

    @Test
    void testReservarPropiedad() {
        LocalDate fechaInicio = LocalDate.of(2024, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2024, 10, 25);

        assertTrue(propiedad.disponibilidad(fechaInicio, fechaFinal),
                "La propiedad debería estar disponible para la reserva.");

        // Crear y agregar la reserva
        Reserva nuevaReserva = new Reserva(fechaInicio, fechaFinal, propiedad);
        propiedad.getReservas().add(nuevaReserva);

        // Verificar que la reserva esté creada
        assertEquals(1, propiedad.getReservas().size(),
                "Debería haber una reserva en la propiedad.");
        assertFalse(propiedad.disponibilidad(fechaInicio, fechaFinal),
                "La propiedad ya no debería estar disponible después de la reserva.");
    }

    @Test
    void testCancelarReserva() {
        LocalDate fechaInicio = LocalDate.of(2024, 10, 22);
        LocalDate fechaFinal = LocalDate.of(2024, 10, 25);

        Reserva reserva = new Reserva(fechaInicio, fechaFinal, propiedad);
        propiedad.getReservas().add(reserva);

        // Cancelar la reserva
        propiedad.cancelarReserva(reserva);

        // Verificar que la reserva haya sido cancelada
        assertTrue(propiedad.getReservas().isEmpty(),
                "La reserva debería haberse cancelado.");
        assertTrue(propiedad.disponibilidad(fechaInicio, fechaFinal),
                "La propiedad debería estar disponible después de cancelar la reserva.");
    }
}
