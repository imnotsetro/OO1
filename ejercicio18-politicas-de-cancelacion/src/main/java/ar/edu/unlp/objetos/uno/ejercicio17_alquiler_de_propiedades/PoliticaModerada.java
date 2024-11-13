package ar.edu.unlp.objetos.uno.ejercicio17_alquiler_de_propiedades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements PoliticaDeCancelacion{
    @Override
    public double montoAReembolsar(Reserva unaReserva) {
        int diasDesdeInicioReserva=(int) ChronoUnit.DAYS.between(unaReserva.getInicio(), LocalDate.now());
        return  diasDesdeInicioReserva >= 7 ? unaReserva.getValorReserva() : diasDesdeInicioReserva>=2?0.5*unaReserva.getValorReserva(): 0 ;
    }
}
