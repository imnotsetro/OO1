package ar.edu.unlp.info.oo1.ejercicio15_distribucion_electrica;

public class CuadroTarifario {
	private double costoActivo;
	
	public CuadroTarifario(double costoActivo) {
		this.costoActivo = costoActivo;
	}

	public double getCostoActivo() {
		return costoActivo;
	}

	public void setCostoActivo(double costoActivo) {
		this.costoActivo = costoActivo;
	}

}
