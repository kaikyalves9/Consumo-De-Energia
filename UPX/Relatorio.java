import java.util.List;

public class Relatorio {
    private List<ConsumoEnergia> consumos;

    public Relatorio(List<ConsumoEnergia> consumos) {
        this.consumos = consumos;
    }

    public void gerarRelatorio() {
        System.out.println("Relatório de Consumo de Energia:");
        for (ConsumoEnergia consumo : consumos) {
            System.out.printf("ID: %s, Consumo: %.2f kWh%n", consumo.getId(), consumo.getConsumo());
        }

        double mediaConsumo = ConsumoEnergia.calcularMediaConsumo(consumos);
        System.out.printf("Consumo médio: %.2f kWh%n", mediaConsumo);
        sugerirEconomia(mediaConsumo);
    }

    private void sugerirEconomia(double mediaConsumo) {
        System.out.println("Sugestões de Economia de Energia:");
        for (ConsumoEnergia consumo : consumos) {
            if (consumo.getConsumo() > mediaConsumo) {
                System.out.printf("Considere reduzir o uso do equipamento %s.%n", consumo.getId());
            }
        }
    }
}
