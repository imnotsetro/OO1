package ar.edu.unlp.info.oo1.ejercicio11_el_inversor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestInversion {
	private InversionEnAcciones nvidia;
	private PlazoFijo bancoProvincia;
	
	@BeforeEach
	void setUp() throws Exception {
		this.nvidia = new InversionEnAcciones("nvidia",5,30.0);
		LocalDate unaFecha = LocalDate.now().minusDays(20);
		this.bancoProvincia = new PlazoFijo(unaFecha, 3000.0, 0.20);
	}
	
	@Test
	void testConstructor() {
		assertEquals(nvidia.getCantidad(),5);
		assertEquals(nvidia.getNombre(),"nvidia");
		assertEquals(bancoProvincia.getMontoDepositado(),3000.0);
		assertEquals(bancoProvincia.getPorcentajeDeInteresDiario(),0.20);
	}
	
	@Test
	void testValorInversionEnAcciones() {
		assertEquals(nvidia.getValor(),150.0);
	}
	
	@Test
	void testValorPlazoFijo() {
		assertEquals(bancoProvincia.getValor(),12000.0);
	}

}
