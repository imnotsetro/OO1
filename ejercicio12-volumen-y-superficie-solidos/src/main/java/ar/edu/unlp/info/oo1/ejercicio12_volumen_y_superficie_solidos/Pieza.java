package ar.edu.unlp.info.oo1.ejercicio12_volumen_y_superficie_solidos;

public abstract class Pieza {
	private String material;
	private String color;
	
	public Pieza(String material, String color) {
		super();
		this.material = material;
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	abstract public double getVolumen();
	
	abstract public double getSuperficie();
}
