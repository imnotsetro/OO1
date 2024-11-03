package ar.edu.unlp.info.oo1.ejercicio13_cliente_de_correo;

import java.util.*;

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

	public int cantEmails() {
		return this.emails.size();
	}

	public Map<String, Integer> cantEmailsCategorizados() {
		Map<String, Integer> m = new HashMap<>();
		m.put("Pequeño", 0);
		m.put("Mediano", 0);
		m.put("Grande", 0);
		m.replace("Pequeño", this.emails.stream().filter(e -> e.getTamaño() <= 300).mapToInt(e -> e.getTamaño()).sum());
		m.replace("Mediano", this.emails.stream().filter(e -> (e.getTamaño() >= 301) && (e.getTamaño() <= 500)).mapToInt(e -> e.getTamaño()).sum());
		m.replace("Grande", this.emails.stream().filter(e -> e.getTamaño() >= 501).mapToInt(e -> e.getTamaño()).sum());
		return m;
	}
	
	public void borrarEmail (Email unEmail) {
		this.emails.remove(unEmail);
	}
}
