import java.util.List;

public class ConsumoEnergia {
    private String id;
    private double consumo;

    public ConsumoEnergia(String id, double consumo) {
        this.id = id;
        this.consumo = consumo;
    }

    public String getId() {
        return id;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public static double calcularMediaConsumo(List<ConsumoEnergia> consumos) {
        if (consumos.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (ConsumoEnergia consumo : consumos) {
            total += consumo.getConsumo();
        }
        return total / consumos.size();
    }
}
