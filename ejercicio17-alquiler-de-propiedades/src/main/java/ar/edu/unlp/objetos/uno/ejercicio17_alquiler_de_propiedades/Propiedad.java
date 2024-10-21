package ar.edu.unlp.objetos.uno.ejercicio17_alquiler_de_propiedades;

import java.time.LocalDate;
import java.util.List;

public class Propiedad {
	String nombreDescriptivo;
	String direccion;
	double precio;
	List<Reserva> reservas;
	
	public String getNombreDescriptivo() {
		return nombreDescriptivo;
	}
	public void setNombreDescriptivo(String nombreDescriptivo) {
		this.nombreDescriptivo = nombreDescriptivo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getPrecioNoche() {
		return precio;
	}
	public void setPrecioNoche(double precio) {
		this.precio = precio;
	}
	public double getPrecioTotal(DataLapse fechas) {
		this.reservas.stream().collect(r -> r.disponibilidad(fechas))
			.forEach();
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	public void cancelarReserva(Reserva unaReserva) {
		if (! unaReserva.getTiempo().includesDate(LocalDate.now())) {
			this.reservas.remove(unaReserva);
		}
	}
	
	public boolean disponibilidad(LocalDate fechaInicial, LocalDate fechaFinal) {
		DataLapse pedido = new DataLapse(fechaInicial,fechaFinal);
		return reservas.stream().anyMatch(r -> r.disponibilidad(pedido));
	}
}
