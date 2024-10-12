package ar.edu.unlp.info.oo1.ejercicio12_volumen_y_superficie_solidos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPieza {
	private ReporteDeConstruccion reporte;
	
	@BeforeEach
	void setUp() throws Exception {
		Esfera e = new Esfera("Hierro","Rojo",5);
		Cilindro c = new Cilindro("Acero","Azul",8,6);
		PrismaRectangular p = new PrismaRectangular ("Hierro","Verde",3,5,7);
		List<Pieza> lista = new LinkedList<Pieza>();
		lista.add(e);
		lista.add(c);
		lista.add(p);
		reporte = new ReporteDeConstruccion();
		reporte.setPiezas(lista);
	}

	@Test
	void testGetVolumenDeMaterial() {
		double res = (((4/3) * Math.PI * Math.pow(5, 3.0)) + (3 * 5 * 7));
		assertEquals(reporte.getVolumenDeMaterial("Hierro"),res);
	}

	@Test
	void testGetSuperficieDeColor() {
		double res= (2 * Math.PI * 8 * 6 + 2 * Math.PI * Math.pow(8, 2.0));
		assertEquals(reporte.getSuperficieDeColor("Azul"),res);
	}

}
