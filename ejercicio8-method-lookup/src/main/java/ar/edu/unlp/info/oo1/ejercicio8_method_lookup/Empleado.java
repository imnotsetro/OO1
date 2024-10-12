package ar.edu.unlp.info.oo1.ejercicio8_method_lookup;

public class Empleado {
	String nombre;
	
	public double montoBasico() {
		return 35000;
	}
	
	public double aportes() {
		return 13500;
	}
	
	public double sueldoBasico() {
		return this.montoBasico() + this.aportes();
	}

}
