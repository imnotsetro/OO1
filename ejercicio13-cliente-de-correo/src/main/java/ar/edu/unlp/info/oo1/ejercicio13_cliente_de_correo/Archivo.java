package ar.edu.unlp.info.oo1.ejercicio13_cliente_de_correo;

public class Archivo {
	String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTamaño() {
		return this.nombre.length();
	}
}
