package ar.edu.unlp.info.oo1.ejercicio12_volumen_y_superficie_solidos;

public class Esfera extends Pieza{
	private Integer radio;

	public Esfera(String material, String color, Integer radio) {
		super(material, color);
		this.radio = radio;
	}

	public Integer getRadio() {
		return radio;
	}

	public void setRadio(Integer radio) {
		this.radio = radio;
	}
	
	public double getVolumen() {
		return ((4/3) * Math.PI  * Math.pow(this.getRadio(), 3.0));
	}
	
	public double getSuperficie() {
		return (4 * Math.PI * Math.pow(this.getRadio(), 2.0));
	}
}
