package ar.edu.unlp.info.oo1.ejercicio13_cliente_de_correo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo(Carpeta inbox) {
		this.inbox = inbox;
		this.carpetas = new LinkedList<Carpeta>();
		this.carpetas.add(inbox);
	}

	public Carpeta getInbox() {
		return inbox;
	}
	
	public void setInbox(Carpeta inbox) {
		this.inbox = inbox;
	}
	
	public List<Carpeta> getCarpetas() {
		return carpetas;
	}
	
	public void setCarpetas(List<Carpeta> carpetas) {
		this.carpetas = carpetas;
	}
	
	public void recibir (Email unEmail) {
		this.inbox.agregarEmail(unEmail);	
	}
	
	public Email buscar (String texto) {
		return carpetas.stream().map(c -> c.buscarEmail(texto)).filter(e -> e != null)
				.findFirst().orElse(null);
	}
	
	public void mover (Email unEmail, Carpeta origen, Carpeta destino) {
		origen.mover(unEmail, destino);
	}
}
