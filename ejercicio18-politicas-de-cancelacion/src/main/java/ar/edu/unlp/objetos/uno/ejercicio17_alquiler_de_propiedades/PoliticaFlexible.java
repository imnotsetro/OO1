package ar.edu.unlp.objetos.uno.ejercicio17_alquiler_de_propiedades;

public class PoliticaFlexible implements PoliticaDeCancelacion{

    @Override
    public double montoAReembolsar(Reserva unaReserva) {
        return unaReserva.getValorReserva();
    }
}
