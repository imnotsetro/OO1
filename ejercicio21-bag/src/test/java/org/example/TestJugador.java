package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {
    Map<Jugador, Integer> m;
    Jugador lm = new Jugador ("Lionel", "Messi");
    Jugador gb = new Jugador ("Gabriel", "Batistuta");
    Jugador ka = new Jugador ("Kun", "Aguero");

    @BeforeEach
    void setUp() {
        m = new HashMap<>();
        m.put(lm, 111);
        m.put(gb, 56);
        m.put(ka, 42);
    }

    @Test
    void testRemoveKun() {
        assertEquals(42, m.remove(ka));
    }

    @Test
    void testRemplazarGolesMessi() {
        assertEquals(111, m.replace(lm, 112));
    }

    @Test
    void testDuplicado() {
        assertEquals(56, m.put(gb, 57));
        assertEquals(57, m.getOrDefault(gb, 56));
    }

    @Test
    void testTotalGoles() {
        assertEquals(209, m.values().stream().mapToInt(Integer::intValue).sum());
    }
}
