package ar.edu.unlp.info.oo1.ejercicio15_distribucion_electrica;

public class Usuario {
	private String nombre;
	private String domicilio;
	private double consumoActivo;
	private double consumoReactivo;
	
	public Usuario(String nombre, String domicilio, double consumoActivo, double consumoReactivo) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumoActivo = consumoActivo;
		this.consumoReactivo = consumoReactivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public double getConsumoActivo() {
		return consumoActivo;
	}
	public void setConsumoActivo(double consumoActivo) {
		this.consumoActivo = consumoActivo;
	}
	public double getConsumoReactivo() {
		return consumoReactivo;
	}
	public void setConsumoReactivo(double consumoReactivo) {
		this.consumoReactivo = consumoReactivo;
	}
	public double getFactorPotencia() {
		return this.consumoActivo / Math.sqrt(Math.pow(this.consumoActivo, 2) + Math.pow(this.consumoReactivo, 2));
	}
	

}
