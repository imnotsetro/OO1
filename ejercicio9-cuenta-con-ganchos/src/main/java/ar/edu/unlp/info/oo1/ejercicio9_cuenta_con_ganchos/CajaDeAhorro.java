package ar.edu.unlp.info.oo1.ejercicio9_cuenta_con_ganchos;

public class CajaDeAhorro extends Cuenta {

	//public boolean extraer(double monto) {
	//	return super.extraer(monto + monto * 0.02);
	//}

	private double adicional(){
		return 1.02;
	}

	@Override
	protected boolean puedeExtraer(double monto) {
		return (this.saldo - monto*adicional() >= 0);
	}

	@Override
	public void extraerSinControlar(double monto){
		this.saldo -= monto*adicional();
	}
	//public void extraerSinControlar(double monto){
	//	super.extraerSinControlar( monto*adicional()); // si la variable saldo fuera privada, no peudo accederla con this. debo llamar con super al metodo con el parametro sobrescrito
	//}


	public void depositar(double monto){
		this.saldo += monto - monto * 0.02;
	}
}
