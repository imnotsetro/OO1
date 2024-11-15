package org.example;

public class ExpressDomicilio implements Envio{
    private final String direccionCliente;
    private final String direccionVendedor;

    public ExpressDomicilio(String direccionCliente, String direccionVendedor) {
        this.direccionCliente = direccionCliente;
        this.direccionVendedor = direccionVendedor;
    }

    private double getCostoKM(){
        return 0.5;
    }

    @Override
    public double calcularCosto() {
        return CalculadoraDeDistancia.distanciaEntre(this.direccionCliente, this.direccionVendedor) * this.getCostoKM();
    }
}
