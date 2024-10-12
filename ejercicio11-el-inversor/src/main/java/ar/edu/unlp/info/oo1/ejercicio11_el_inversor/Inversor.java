package ar.edu.unlp.info.oo1.ejercicio11_el_inversor;

import java.util.List;

public class Inversor {
	String nombre;
	List<Inversion> inversiones;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Inversion> getInversiones() {
		return inversiones;
	}
	public void setInversiones(List<Inversion> inversiones) {
		this.inversiones = inversiones;
	}
	
	public double valorActual() {
		double total = 0;
		for (Inversion inversion : inversiones) {
			total += inversion.getValor();
		}
		return total;
	}
}
