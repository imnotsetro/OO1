package ar.edu.unlp.info.oo1.ejercicio5_figurasycuerpos;

public class Cuadrado extends Forma {
	double lado;

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getPerimetro() {
		return (this.lado * 4);
	}
	
	public double getArea() {
		return (this.lado * this.lado);
	}
}
