package ar.edu.unlp.info.oo1.ejercicio9_cuenta_con_ganchos;

public class CajaDeAhorro extends Cuenta {

	public boolean extraer(double monto) {
		return super.extraer(monto + monto * 0.02);
	}
	
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		return super.transferirACuenta(monto + monto * 0.02, cuentaDestino);
	}
	
	public void depositar(double monto){
		this.saldo += monto - monto * 0.02;
	}
}
