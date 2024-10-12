package ar.edu.unlp.info.oo1.ejercicio13_cliente_de_correo;

import java.util.List;

public class Email {
	String titulo;
	String cuerpo;
	List<Archivo> archivos;
	
	public Email(String titulo, String cuerpo, List<Archivo> archivos) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.archivos = archivos;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCuerpo() {
		return cuerpo;
	}
	
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	public int getTamaño() {
		int res = (this.titulo.length() + this.cuerpo.length());
		res += this.archivos.stream().mapToInt(a -> a.getTamaño()).sum();
		return res;
	}
	
	public boolean contiene(String texto) {
		return this.titulo.contains(texto) || this.cuerpo.contains(texto);
	}
	
	public List<Archivo> getArchivos() {
		return archivos;
	}
	
	public void setArchivos(List<Archivo> archivos) {
		this.archivos = archivos;
	}
}
