package ar.edu.unlp.info.oo1.ejercicio8_method_lookup;

public @interface Respuesta {
	/*
	 * 1. En el primer codigo se ejecuta el constructor del Gerente, para despues ejecutar su
	 * monto basico, en este caso no ejecuta ningun metodo de alguna clase super.
	 * Mientras tanto, el segudo codigo llamada al metodo de la super clase "EmpleadoJerarquico"
	 * para ejecutar el metodo sueldo basico, este mismo metodo llama al metodo de la super clase
	 * del mismo nombre, el cual devuelve el valor 57000 (debido a que el this. hace referencia a
	 * gerente y no a Empleado) mas los aportes que son (57000 * 0.05) (debido tambien
	 * a que hace referencia al metodo de la clase que lo llamo), esto luego
	 * sera sumado por el bono de categoria de la clase "EmpleadoJerarquico" y luego devuelvo 
	 * el valor desde la clase inicial.
	 * 
	 * 2. aportesDeAlan tendra el valor 2850.
	 * mientras que la variable sueldoBasicoDeAlan tendra el valor 67850.
	 */
}
