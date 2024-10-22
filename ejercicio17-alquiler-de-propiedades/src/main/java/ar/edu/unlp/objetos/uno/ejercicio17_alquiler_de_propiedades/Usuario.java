package ar.edu.unlp.objetos.uno.ejercicio17_alquiler_de_propiedades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	String nombre;
	String direccion;
	int dni;
	List<Propiedad> propiedades;

	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public List<Propiedad> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
	
	public void agregarPropiedad (Propiedad unaPropiedad) {
		this.propiedades.add(unaPropiedad);
	}
	
	public double precioTotal (DataLapse fechas) {
		return this.propiedades.stream().mapToDouble(p -> p.getPrecioTotal(fechas)).sum();
	}
	
	
	
}
