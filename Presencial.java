public class Presencial extends Consulta {
    
    // ========== ATRIBUTOS ==========
    private String sala;

    // ========== CONSTRUTOR ==========
    public Presencial(String paciente, double valor, String sala) {
        super(paciente, valor);
        this.sala = sala;
    }

    // ========== GETTERS E SETTERS ==========
    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }

    // Retorna o tipo específico da consulta, que é "Presencial"
    @Override
    public String getTipo() { return "Presencial"; }

    // ========== MÉTODOS ==========
    @Override
    public void confirmar() {
        System.out.println("Consulta presencial confirmada para o paciente " + getPaciente().toUpperCase() + " na sala " + sala + ".");
        System.out.println("Por gentileza, compareça à clínica com 15 minutos de antecedência para o atendimento.\n");
    }

    // Polimorfismo: O objeto sabe a própria gaveta onde deve guardar o valor
    @Override
    public void contabilizarNoFechamento(RelatorioConsultas relatorio) 
    {
        relatorio.somarPresencial(this.getValor());
    }
}