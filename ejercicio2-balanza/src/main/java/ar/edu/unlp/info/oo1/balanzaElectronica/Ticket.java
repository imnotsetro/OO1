package ar.edu.unlp.info.oo1.balanzaElectronica;
import java.time.LocalDate;

public class Ticket {
	LocalDate fecha;
	int cantidadDeProductos;
	double pesoTotal;
	double precioTotal;
	
	public Ticket(int cantidadDeProductos, double pesoTotal, double precioTotal) {
		super();
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
	}

	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}



	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}



	public double getPesoTotal() {
		return pesoTotal;
	}



	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}



	public double getPrecioTotal() {
		return precioTotal;
	}



	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}



	public double impuesto() {
		return precioTotal * 1.21;
	}
}
