package ar.edu.unlp.info.oo1.balanzaElectronica;

public class Balanza {
	int cantidadDeProductos;
	double precioTotal;
	double pesoTotal;
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public void ponerEnCero() {
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}
	
	public void agregarProducto(Producto unProducto) {
		this.cantidadDeProductos += 1;
		this.pesoTotal += unProducto.getPeso();
		this.precioTotal += unProducto.getPrecio();
	}
	
	public Ticket emitirTicket() {
		Ticket unTicket = new Ticket(this.cantidadDeProductos,this.precioTotal,this.pesoTotal);
		return unTicket;
	}

}
