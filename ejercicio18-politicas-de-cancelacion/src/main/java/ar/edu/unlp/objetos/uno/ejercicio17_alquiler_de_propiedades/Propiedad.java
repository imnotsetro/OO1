package ar.edu.unlp.objetos.uno.ejercicio17_alquiler_de_propiedades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Propiedad {
	String nombreDescriptivo;
	String direccion;
	String politicaCancelacion;
	double precio;
	List<Reserva> reservas;

	public Propiedad(String nombreDescriptivo, double precio, String direccion, String politica) {
		this.nombreDescriptivo = nombreDescriptivo;
		this.reservas = reservas;
		this.precio = precio;
		this.direccion = direccion;
		this.politicaCancelacion=politica;
		this.reservas = new ArrayList<>();
	}

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

	public String getPoliticaCancelacion() {
		return politicaCancelacion;
	}

	public void setPoliticaCancelacion(String politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	}

	public double getPrecioNoche() {
		return precio;
	}

	public void setPrecioNoche(double precio) {
		this.precio = precio;
	}

	public double getPrecioTotal(DataLapse fechas) {
		return this.reservas.stream().filter(r -> r.getTiempo().overlaps(fechas)).mapToDouble(r -> r.getValorReserva()).sum();
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public double cancelarReserva(Reserva unaReserva) {
		double monto = 0;
		if (! unaReserva.getTiempo().includesDate(LocalDate.now()) || this.politicaCancelacion.equals("estricta")) {
			switch (this.politicaCancelacion) {
				case "flexible":
					monto = this.getPrecioNoche() * unaReserva.getTiempo().sizeInDays();
				case "moderada":
					if (ChronoUnit.DAYS.between(LocalDate.now(), unaReserva.getTiempo().getFrom()) >= 7) {
						monto = this.getPrecioNoche() * unaReserva.getTiempo().sizeInDays();
					} else {
						if (ChronoUnit.DAYS.between(LocalDate.now(), unaReserva.getTiempo().getFrom()) >= 2) {
							monto = (this.getPrecioNoche() * unaReserva.getTiempo().sizeInDays()) * 0.5;
						}
					}
			}
		}
			this.reservas.remove(unaReserva);;
			return monto;
    }
	
	public boolean disponibilidad(LocalDate fechaInicial, LocalDate fechaFinal) {
		DataLapse pedido = new DataLapse(fechaInicial,fechaFinal);
		return reservas.stream().noneMatch(r -> r.disponibilidad(pedido));
	}
}
