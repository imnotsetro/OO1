package ar.edu.unlp.info.oo1.ejercicio5_figurasycuerpos;

public class Cuerpo3D extends Object{
	double altura;
	Forma caraBasal;
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public Forma getCaraBasal() {
		return caraBasal;
	}
	
	public void setCaraBasal(Forma caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public void setCaraBasal(Cuadrado caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public double getSuperficieExterior() {
		return (2 * this.caraBasal.getArea() + (this.caraBasal.getPerimetro() * this.altura));
	}
	
	public double getVolumen() {
		return (this.caraBasal.getArea() * this.altura);
	}
}
