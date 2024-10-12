package ar.edu.unlp.info.oo1.ejercicio14_intervalo_de_tiempo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLapseTest {
	DataLapse dl;
	
	@BeforeEach
	void setUp() throws Exception {
		dl = new DataLapse(LocalDate.now(),LocalDate.now().plusDays(36));
	}

	@Test
	void testConstructor() {
		assertEquals(dl.getFrom(), LocalDate.now());
		assertEquals(dl.getTo(), LocalDate.now().plusDays(36));
	}

	@Test
	void testSizeInDays() {
		assertEquals(dl.sizeInDays(),36);
	}
	
	@Test
	void testIncludesDate() {
		assertTrue(dl.includesDate(LocalDate.now().plusDays(3)));
	}

}
