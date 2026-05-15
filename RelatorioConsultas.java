import java.util.List;

public class RelatorioConsultas {

    // ========== VARIAVEIS DE QUANTIDADE E TOTAIS ===========
    private int qtdPresencial = 0;
    private double totalPresencial = 0;

    private int qtdTeleconsulta = 0;
    private double totalTeleconsulta = 0;

    private int qtdDomiciliar = 0;
    private double totalDomiciliar = 0;


    // ========== MÉTODOS DE SOMA PARA RECEBER OS VALORES DE CADA TIPO DE CONSULTA ==========
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
        // Percorre cada consulta da lista
        for (Consulta c : consultas)  
        {
            // Cada consulta sabe onde se registrar no relatorio.
            c.contabilizarNoFechamento(this); 
        }

        // ========== CÁLCULOS FINAIS PARA O RELATÓRIO ==========
        int totalConsultas = qtdPresencial + qtdTeleconsulta + qtdDomiciliar;
        double valorGeral = totalPresencial + totalTeleconsulta + totalDomiciliar;

        // ========== EXIBIÇÃO DO RELATÓRIO ORGANIZADO ===========
        System.out.println("\n========== RELATÓRIO DAS CONSULTAS DO DIA ==========");
        System.out.printf("PRESENCIAL   | Qtd: %d | Subtotal: R$ %.2f%n", qtdPresencial, totalPresencial);
        System.out.printf("TELECONSULTA | Qtd: %d | Subtotal: R$ %.2f%n", qtdTeleconsulta, totalTeleconsulta);
        System.out.printf("DOMICILIAR   | Qtd: %d | Subtotal: R$ %.2f%n", qtdDomiciliar, totalDomiciliar);
        System.out.println("------------------------------------------------");
        System.out.printf("TOTAL GERAL  | Qtd: %d | ARRECADADO: R$ %.2f%n", totalConsultas, valorGeral);
        System.out.println("================================================\n");
    }
}