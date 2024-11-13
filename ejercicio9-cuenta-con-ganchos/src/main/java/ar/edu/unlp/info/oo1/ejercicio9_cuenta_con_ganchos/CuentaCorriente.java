package ar.edu.unlp.info.oo1.ejercicio9_cuenta_con_ganchos;

public class CuentaCorriente extends Cuenta {
	double limiteDescubierto;

	public CuentaCorriente() {
		super();
		this.limiteDescubierto = 0;
	}
	
	public double getLimiteDescubierto() {
		return limiteDescubierto;
	}

	public void setLimiteDescubierto(double limiteDescubierto) {
		this.limiteDescubierto = limiteDescubierto;
	}

	@Override
	protected boolean puedeExtraer(double monto) {
		return (this.saldo - monto >= limiteDescubierto);
	}


}
