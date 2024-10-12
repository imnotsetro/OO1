package ar.edu.unlp.info.oo1.ejercicio13_cliente_de_correo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Carpeta {
	String nombre;
	List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new LinkedList<Email>();
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Email> getEmails() {
		return emails;
	}
	
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	
	public void agregarEmail (Email unEmail) {
		this.emails.add(unEmail);
	}
	
	public Email buscarEmail (String texto) {
		return emails.stream().filter(e -> e.contiene(texto)).findFirst().orElse(null);
	}
	
	public int devolverEspacio() {
		return this.emails.stream().mapToInt(e -> e.getTamaño()).sum();
	}
	
	public void mover(Email email, Carpeta destino) {
		destino.agregarEmail(email);
		this.borrarEmail(email);
	}
	
	public void borrarEmail (Email unEmail) {
		this.emails.remove(unEmail);
	}
}
