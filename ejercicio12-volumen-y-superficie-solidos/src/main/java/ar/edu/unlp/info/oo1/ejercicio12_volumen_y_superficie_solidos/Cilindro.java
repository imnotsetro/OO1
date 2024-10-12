package ar.edu.unlp.info.oo1.ejercicio12_volumen_y_superficie_solidos;

public class Cilindro extends Pieza{
	private Integer radio;
	private Integer altura;
	
	public Cilindro(String material, String color, Integer radio, Integer altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}

	public Integer getRadio() {
		return radio;
	}
	
	public void setRadio(Integer radio) {
		this.radio = radio;
	}
	
	public Integer getAltura() {
		return altura;
	}
	
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	
	public double getVolumen() {
		return (Math.PI * Math.pow(this.getRadio(), 2.0) * this.getAltura());
	}
	
	public double getSuperficie() {
		return (2 * Math.PI * this.getRadio() * this.getAltura() + 2 * Math.PI * Math.pow(this.getRadio(), 2.0));
	}
}
