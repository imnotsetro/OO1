package ar.edu.unlp.info.oo1.ejercicio5_figurasycuerpos;

public class Circulo extends Forma {
	double radio;
	double diametro;
	
	
	
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return diametro;
	}
	
	public void setDiametro(double diametro) {
		this.diametro = this.radio * 2;
	}
	
	public double getPerimetro() {
		return (3.14 * this.diametro);
	}
	
	public double getArea() {
		return (3.14 * (Math.sqrt(this.radio)));
	}
}
