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
		assertTrue(raul.getLimiteDescubierto() == 0);
		assertTrue(perez.getSaldo() == 0);
	}

	@Test
	void testDepositarYExtraer() {
		raul.depositar(500.0);
		assertTrue(raul.getSaldo() == 500.0);
		raul.extraer(300.0);
		assertTrue(raul.getSaldo() == 200.0);
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
		assertTrue(raul.getSaldo() == -100.0);
	}
	
	@Test
	void testTransferir() {
		raul.depositar(500.0);
		assertTrue(raul.getSaldo() == 500.0);
		raul.transferirACuenta(200.0, perez);
		assertTrue(raul.getSaldo() == 300.0);
		assertTrue(perez.getSaldo() == 196.0);
	}
}
