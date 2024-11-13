package org.example;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {

    public EnvioInternacional(LocalDate fechaDespacho, String direccionOrigen, String direccionEnvio, double peso) {
        super(fechaDespacho, direccionOrigen, direccionEnvio, peso);
    }

    public double calcularMonto() {
        if (this.peso < 1000.0) {
            return 5000.0 + 10.0 * this.peso; // reemplazar los numeros por metodos o constantes representativas
        } else {
            return 5000.0 + 12.0 * this.peso;
        }
    }
}
