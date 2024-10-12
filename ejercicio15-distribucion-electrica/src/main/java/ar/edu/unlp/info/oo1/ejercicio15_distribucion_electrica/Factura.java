package ar.edu.unlp.info.oo1.ejercicio15_distribucion_electrica;

import java.time.LocalDate;

public class Factura {
	private Usuario pagador;
	private LocalDate fechaEmision;
	private double bonificacion;
	private double montoFinal;
	
	public Factura(Usuario pagador, LocalDate fechaEmision, double bonificacion, CuadroTarifario ct) {
		this.pagador = pagador;
		this.fechaEmision = fechaEmision;
		this.bonificacion = bonificacion;
		this.setMontoFinal(ct);
	}
	public Usuario getPagador() {
		return pagador;
	}
	public void setPagador(Usuario pagador) {
		this.pagador = pagador;
	}
	public LocalDate getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public double getBonificacion() {
		return bonificacion;
	}
	public void setBonificacion(double bonificacion) {
		this.bonificacion = bonificacion;
	}
	public double getMontoFinal() {
		return montoFinal;
	}
	public void setMontoFinal(CuadroTarifario ct) {
		double res = ((this.pagador.getConsumoActivo() * ct.getCostoActivo()) - this.bonificacion);
		System.out.println(this.pagador.getFactorPotencia());
		if (this.pagador.getFactorPotencia() > 0.8) {
			res = res - res * 0.10;
		}
		this.montoFinal = res;
	}
	
	
}
