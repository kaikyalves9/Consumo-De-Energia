public class Equipamento {
    private String nome;
    private double consumoPorHora; // em kWh

    public Equipamento(String nome, double consumoPorHora) {
        this.nome = nome;
        this.consumoPorHora = consumoPorHora;
    }

    public String getNome() {
        return nome;
    }

    public double getConsumoPorHora() {
        return consumoPorHora;
    }

    public double calcularCustoOperacao(double tarifa, int horas) {
        return consumoPorHora * horas * tarifa;
    }
}
