package ar.edu.unlp.info.oo1.ejercicio15_distribucion_electrica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {
	private Factura f1;
	private CuadroTarifario ct;
	private Usuario u1,u2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.ct = new CuadroTarifario(20.0);
		this.u1 = new Usuario("Martin Dominguez","Gonnet",100.0,80.0);
		this.u2 = new Usuario("Luis Dominguez","Gonnet",150.0,40.0);
		this.f1 = new Factura(u1,LocalDate.now(),10,this.ct);
	}

	@Test
	void testConstructor() {
		assertEquals(ct.getCostoActivo(),20.0);
		assertEquals(u1.getConsumoActivo(),100.0);
		assertEquals(f1.getMontoFinal(),(100.0 * 20.0)-10);
		this.f1.setBonificacion(80);
		this.f1.setMontoFinal(ct);
		assertEquals(f1.getMontoFinal(),(100.0 * 20.0)-80);
		this.f1.setPagador(u2);
		this.f1.setMontoFinal(ct);
		assertEquals(f1.getMontoFinal(),((150.0*20.0)-80)*0.90);
	}
}
