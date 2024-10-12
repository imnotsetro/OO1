package ar.edu.unlp.info.oo1.ejercicio7_red_de_alumbrado;

import java.util.LinkedList;
import java.util.List;

public class Farola extends Object {
	boolean estado;
	List<Farola> vecinas;
	
	public Farola() {
		this.estado = false;
		this.vecinas = new LinkedList<>();
	}
	
	public void pairWithNeighbor(Farola unaFarola) {
		this.vecinas.add(unaFarola);
		unaFarola.getNeighbors().add(this);
	}
	
	public List<Farola> getNeighbors() {
		return vecinas;
	}
	
	public void turnOn() {
		if (!estado) {
			estado = true;
			this.vecinas.stream().forEach(f -> f.turnOn());
		}
	}
	
	public void turnOff() {
		if (estado) {
			this.estado = false;
				this.vecinas.stream().forEach(f -> f.turnOff());
		}
	}
	
	public boolean isOn() {
		return estado;
	}
	
	public boolean isOff() {
		return !estado;
	}
}
