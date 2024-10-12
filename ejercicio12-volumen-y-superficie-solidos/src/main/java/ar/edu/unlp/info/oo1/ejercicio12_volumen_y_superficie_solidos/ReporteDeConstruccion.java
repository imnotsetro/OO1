package ar.edu.unlp.info.oo1.ejercicio12_volumen_y_superficie_solidos;

import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;

	public List<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}
	
	public double getVolumenDeMaterial(String nombreDeMaterial) {
		return this.piezas.stream().filter(p -> p.getMaterial().equals(nombreDeMaterial)).mapToDouble(p -> p.getVolumen()).sum();
	}
	
	public double getSuperficieDeColor(String nombreDeColor) {
		return this.piezas.stream().filter(p -> p.getColor().equals(nombreDeColor)).mapToDouble(p -> p.getSuperficie()).sum();
	}
}
