package ar.edu.unlp.objetos.uno.ejercicio17_alquiler_de_propiedades;

import java.time.LocalDate;

public class Reserva {
	private DataLapse tiempo;
	private Propiedad propiedadReservada;
	private Usuario inquilino;
	
	public Reserva(LocalDate fechaInicio, LocalDate fechaFinal, Propiedad propiedadReservada, Usuario inquilino) {
		if (propiedadReservada.disponibilidad(fechaInicio, fechaFinal)) {
			this.propiedadReservada = propiedadReservada;
			this.tiempo = new DataLapse(fechaInicio,fechaFinal);
			this.inquilino=inquilino;
		}
	}
	
	public DataLapse getTiempo() {
		return tiempo;
	}
	public void setTiempo(DataLapse tiempo) {
		this.tiempo = tiempo;
	}
	public Propiedad getPropiedadReservada() {
		return propiedadReservada;
	}

	public double getValorReserva() {
		return this.tiempo.sizeInDays() * this.propiedadReservada.getPrecioNoche();
	}
	
	public boolean estaOcupada(DataLapse pedido) {
		return (this.tiempo.overlaps(pedido));
	}
	
	public boolean puedeCancelar(){
		return tiempo.getFrom().isAfter(LocalDate.now()) ;// podrias agregar la comparacion de "or == hoy";
	}

	public LocalDate getInicio(){
		return tiempo.getFrom();
	}
}
