package Modelos;

public class Divisa {
    private String moneda1;
    private String moneda2;
    private double valorTotal;
    private double valorUnitario;
    private double cantidad;

    public Divisa(DivisaAPI miDivisaAPI) {
        this.moneda1 = miDivisaAPI.base_code();
        this.moneda2 = miDivisaAPI.target_code();
        this.valorTotal = miDivisaAPI.conversion_result();
        this.valorUnitario = miDivisaAPI.conversion_rate();
    }

    public String getMoneda1() {
        return moneda1;
    }

    public void setMoneda1(String moneda1) {
        this.moneda1 = moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }

    public void setMoneda2(String moneda2) {
        this.moneda2 = moneda2;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return
                "Tú(s) " + cantidad + " "+ moneda1 + " en " + moneda2 +
                        " equivalen a = " + valorTotal + " " + moneda2;
    }
}
