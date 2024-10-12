package ar.edu.unlp.info.oo1.ejercicio3_presupuesto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Presupuesto{
	LocalDate fecha;
	String cliente;
	List<Item> items;
	
	public Presupuesto(String cliente) {
		super();
		this.fecha = LocalDate.now();
		this.cliente = cliente;
		this.items = new ArrayList<Item>();
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public void agregarItem(Item unItem) {
		items.add(unItem);
	}
	
	public double calcularTotal() {
		double aux = 0;
		for (Item it : items) {
			aux += it.costoUnitario * it.cantidad;
		}
		return aux;
	}
	

}
