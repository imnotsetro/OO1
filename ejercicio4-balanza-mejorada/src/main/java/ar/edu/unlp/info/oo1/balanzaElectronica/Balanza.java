package ar.edu.unlp.info.oo1.balanzaElectronica;
import java.util.List;

public class Balanza {
	List<Producto> listaProductos;
	
	public int getCantidadDeProductos() {
		return listaProductos.size();
	}
	
	public List<Producto> getProductos() {
		return this.listaProductos;
	}

	public double getPrecioTotal() {
		double aux = 0;
		for (Producto p : listaProductos) {
			aux += p.getPrecio();
		}
		return aux;
	}

	public double getPesoTotal() {
		double aux = 0;
		for (Producto p : listaProductos) {
			aux += p.getPeso();
		}
		return aux;
	}

	public void ponerEnCero() {
		this.listaProductos.clear();
	}
	
	public void agregarProducto(Producto unProducto) {
		this.listaProductos.add(unProducto);
	}
	
	public Ticket emitirTicket() {
		Ticket unTicket = new Ticket(this.listaProductos.size(),this.getPrecioTotal(),this.getPesoTotal());
		return unTicket;
	}
}
