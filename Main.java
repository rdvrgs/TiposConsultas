import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // 1. Cria a lista geral do dia (Tudo misturado, o sistema tem que se virar)
        List<Consulta> consultas = new ArrayList<>();

        // 2. Adiciona as consultas que aconteceram no dia
        consultas.add(new Presencial("Richard Vargas", 150.0, "Sala 1"));
        consultas.add(new Presencial("Joao Silva", 200.0, "Sala 2"));
        
        // As teleconsultas já aplicam os 10% de desconto no próprio construtor
        consultas.add(new Teleconsulta("Jorge Mendes", 100.0)); 
        consultas.add(new Teleconsulta("Roberto Santos", 150.0));
        
        consultas.add(new ConsultaDomiciliar("Maria Oliveira", 300.0, "Rua XV, 123"));
        consultas.add(new ConsultaDomiciliar("Gustavo Costa", 250.0, "Av Brasil, 400"));

        // ========== APLICAR DESCONTO DE 10% NAS TELECONSULTAS ==========
        for (Consulta c : consultas)
        {
            if (c instanceof Teleconsulta) 
            {
                c.aplicarDesconto(10); // Aplica os 10% de desconto
            }
        }

        // ========== EXIBIR TODOS OS AGENDAMENTOS ===========
        double totalDoDia = 0;
    
        for (Consulta c : consultas) 
        {
            c.exibirAgendamento();
            totalDoDia = totalDoDia + c.getValor();
        }   

        // ========== FILTRAR POR TIPO DE CONSULTA PRESENCIAL ===========
        filtrarPorTipo(consultas, "Presencial");

        // ========== EXIBIR O TOTAL DO DIA COM DESCONTOS APLICADOS ==========
        System.out.println("\nTotal do dia com descontos: R$ " + String.format("%.2f", totalDoDia));

        // 3. Aciona a funcionalidade de Fechamento do gestor
        RelatorioConsultas relatorio = new RelatorioConsultas();
        relatorio.gerarRelatorioConsultas(consultas); // O relatório é gerado a partir da lista geral chamada "consultas".
    }   

    // ========= MÉTODO EXTRA PARA FILTRAR POR TIPO ===========
    public static void filtrarPorTipo(List<Consulta> consultas, String tipo) 
    {

        // =========== EXIBE CONSULTAS DO TIPO ESPECÍFICO ===========
        System.out.println("\n-- Consultas " + tipo + " --");

        for (Consulta c : consultas) 
        {
            // SE O TIPO DA CONSULTA FOR IGUAL AO TIPO QUE QUEREMOS, O PRÓPRIO OBJETO SABE SE DEVE SE EXIBIR OU NÃO
            if (c.getTipo().equalsIgnoreCase(tipo)) 
            {
                System.out.println(c);
            }
        }
    }
}