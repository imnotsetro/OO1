package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Producto {
	double peso;
	double precioPorKilo;
	String descripcion;
	
	
	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public double getPrecioPorKilo() {
		return precioPorKilo;
	}



	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public double getPrecio() {
		return precioPorKilo * peso;
	}
	
}
