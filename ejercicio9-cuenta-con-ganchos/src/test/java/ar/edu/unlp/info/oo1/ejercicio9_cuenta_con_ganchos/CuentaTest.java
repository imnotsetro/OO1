package ar.edu.unlp.info.oo1.ejercicio9_cuenta_con_ganchos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {
	private CuentaCorriente raul;
	private CajaDeAhorro perez;
	
	@BeforeEach
	void setUp() throws Exception {
		this.raul = new CuentaCorriente();
		this.perez = new CajaDeAhorro();
	}
	
	@Test
	void testConstructor() {
		assertEquals(raul.getSaldo(),0);
        assertEquals(0, raul.getLimiteDescubierto());
        assertEquals(0, perez.getSaldo());
	}

	@Test
	void testDepositarYExtraer() {
		raul.depositar(500.0);
        assertEquals(500.0, raul.getSaldo());
		raul.extraer(300.0);
        assertEquals(200.0, raul.getSaldo());
	}
	
	@Test
	void testCajaDeAhorro() {
		perez.depositar(200.0);
		assertEquals(perez.getSaldo(),196.0);
	}
	
	@Test
	void testCuentaCorriente() {
		raul.setLimiteDescubierto(-300.0);
		raul.depositar(200.0);
		raul.extraer(300.0);
        assertEquals(-100.0, raul.getSaldo());
	}
	
	@Test
	void testTransferir() {
		raul.depositar(500.0);
        assertEquals(500.0, raul.getSaldo());
		raul.transferirACuenta(200.0, perez);
        assertEquals(300.0, raul.getSaldo());
        assertEquals(196.0, perez.getSaldo());
	}
}
