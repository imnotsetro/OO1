package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestMap {
    Map<String, Integer> m;

    @BeforeEach
    void setUp() {
        m = new HashMap<>();
        m.put("Lionel Messi", 111);
        m.put("Gabriel Bautista", 56);
        m.put("Kun Aguero", 42);
    }

    @Test
    void testRemoveKun() {
        assertEquals(42, m.remove("Kun Aguero"));
    }

    @Test
    void testRemplazarGolesMessi() {
        assertEquals(111, m.replace("Lionel Messi", 112));
    }

    @Test
    void testDuplicado() {
        assertEquals(56, m.put("Gabriel Bautista", 57));
        assertEquals(57, m.getOrDefault("Gabriel Bautista", 56));
    }

    @Test
    void testTotalGoles() {
        assertEquals(209, m.values().stream().mapToInt(Integer::intValue).sum());
    }
}
