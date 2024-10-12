package ar.edu.unlp.info.oo1.ejercicio12_volumen_y_superficie_solidos;

public class PrismaRectangular extends Pieza {
	private Integer ladoMayor;
	private Integer ladoMenor;
	private Integer altura;

	public PrismaRectangular(String material, String color, Integer ladoMayor, Integer ladoMenor, Integer altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}

	public Integer getLadoMayor() {
		return ladoMayor;
	}
	
	public void setLadoMayor(Integer ladoMayor) {
		this.ladoMayor = ladoMayor;
	}
	
	public Integer getLadoMenor() {
		return ladoMenor;
	}
	
	public void setLadoMenor(Integer ladoMenor) {
		this.ladoMenor = ladoMenor;
	}
	
	public Integer getAltura() {
		return altura;
	}
	
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	
	public double getVolumen() {
		return (this.getLadoMayor() * this.getLadoMenor() * this.getAltura());
	}
	
	public double getSuperficie() {
		return (2 * (this.getLadoMayor() * this.getLadoMenor() + this.getLadoMenor() * this.getAltura() + this.getLadoMenor() * this.getAltura()));
	}
}
