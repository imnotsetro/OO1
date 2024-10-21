package ar.edu.unlp.objetos.uno.ejercicio17_alquiler_de_propiedades;

import java.time.LocalDate;

public class Reserva {
	DataLapse tiempo;
	Propiedad propiedadReservada;
	
	public Reserva(LocalDate fechaInicio, LocalDate fechaFinal, Propiedad propiedadReservada) {
		if (propiedadReservada.disponibilidad(fechaInicio, fechaFinal)) {
			this.propiedadReservada = propiedadReservada;
			this.tiempo = new DataLapse(fechaInicio,fechaFinal);
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
	public void setPropiedadReservada(Propiedad propiedadReservada) {
		this.propiedadReservada = propiedadReservada;
	}
	
	public double getValorReserva() {
		return this.tiempo.sizeInDays() * this.propiedadReservada.getPrecio();
	}
	
	public boolean disponibilidad(DataLapse pedido) {
		return (! this.tiempo.overlaps(pedido));
	}
	
	
}
