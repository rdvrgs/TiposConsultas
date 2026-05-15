import java.util.List;

public class RelatorioConsultas {

    // Variáveis para guardar contagem e subtotais
    private int qtdPresencial = 0;
    private double totalPresencial = 0;

    private int qtdTeleconsulta = 0;
    private double totalTeleconsulta = 0;

    private int qtdDomiciliar = 0;
    private double totalDomiciliar = 0;

    // ========== MÉTODOS PARA RECEBER OS VALORES =========
    public void somarPresencial(double valor) 
    {
        this.qtdPresencial++;
        this.totalPresencial += valor;
    }

    public void somarTeleconsulta(double valor) 
    {
        this.qtdTeleconsulta++;
        this.totalTeleconsulta += valor;
    }

    public void somarDomiciliar(double valor) 
    {
        this.qtdDomiciliar++;
        this.totalDomiciliar += valor;
    }

    // ========== LÓGICA DO RELATÓRIO ==========
    public void gerarRelatorioConsultas(List<Consulta> consultas) // O relatório é gerado a partir da lista geral chamada "consultas".
    {
        // Para cada consulta do dia, o próprio objeto sabe onde deve guardar seu valor no fechamento
        for (Consulta c : consultas)  
        {
            c.contabilizarNoFechamento(this); // O polimorfismo resolve tudo sozinho
        }

        // ========== Cálculos finais para o relatório ==========
        int totalConsultas = qtdPresencial + qtdTeleconsulta + qtdDomiciliar;
        double valorGeral = totalPresencial + totalTeleconsulta + totalDomiciliar;

        // ========== Exibição do relatório organizado ===========
        System.out.println("\n========== RELATÓRIO GERENCIAL DO DIA ==========");
        System.out.printf("PRESENCIAL   | Qtd: %d | Subtotal: R$ %.2f%n", qtdPresencial, totalPresencial);
        System.out.printf("TELECONSULTA | Qtd: %d | Subtotal: R$ %.2f%n", qtdTeleconsulta, totalTeleconsulta);
        System.out.printf("DOMICILIAR   | Qtd: %d | Subtotal: R$ %.2f%n", qtdDomiciliar, totalDomiciliar);
        System.out.println("------------------------------------------------");
        System.out.printf("TOTAL GERAL  | Qtd: %d | ARRECADADO: R$ %.2f%n", totalConsultas, valorGeral);
        System.out.println("================================================\n");
    }
}