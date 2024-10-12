package ar.edu.info.oo1.ej3_presupuestos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Presupuesto{
	LocalDate fecha;
	String cliente;
	List<Item> items;
	
	public Presupuesto(Date fecha, String cliente, List<Item> items) {
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
