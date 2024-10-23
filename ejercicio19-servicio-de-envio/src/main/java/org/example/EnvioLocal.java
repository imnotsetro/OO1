package org.example;

import java.time.LocalDate;

public class EnvioLocal extends Envio {
    boolean entregaRapida;

    public EnvioLocal(LocalDate fechaDespacho, String direccionOrigen, String direccionEnvio, double peso, boolean entregaRapida) {
        super(fechaDespacho, direccionOrigen, direccionEnvio, peso);
        this.entregaRapida = entregaRapida;
    }

    public double calcularMonto() {
        if (this.entregaRapida) {
            return 500.0;
        } else {
            return 1000.0;
        }
    }
}
