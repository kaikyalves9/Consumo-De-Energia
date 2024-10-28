import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<ConsumoEnergia> listaConsumos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir Consumo de Equipamento");
            System.out.println("2. Gerar Relatório");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                continue;
            }

            if (opcao == 3) break;

            switch (opcao) {
                case 1:
                    System.out.print("Digite ID do equipamento: ");
                    String id = scanner.nextLine();
                    
                    double consumo = 0;
                    while (true) {
                        System.out.print("Digite o consumo em kWh: ");
                        try {
                            consumo = Double.parseDouble(scanner.nextLine());
                            if (consumo < 0) {
                                System.out.println("Consumo não pode ser negativo. Tente novamente.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Digite um número válido.");
                        }
                    }

                    ConsumoEnergia consumoEnergia = new ConsumoEnergia(id, consumo);
                    listaConsumos.add(consumoEnergia);
                    break;

                case 2:
                    Relatorio relatorio = new Relatorio(listaConsumos);
                    relatorio.gerarRelatorio();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
