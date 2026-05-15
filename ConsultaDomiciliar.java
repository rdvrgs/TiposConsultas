public class ConsultaDomiciliar extends Consulta {

    // ========== ATRIBUTOS ==========
    private String endereco;

    // ========= CONSTRUTOR ==========
    public ConsultaDomiciliar(String paciente, double valor, String endereco) 
    {
        super(paciente, valor);
        this.endereco = endereco;
    }

    // ========= GETTERS E SETTERS ==========
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    // Retorna o tipo específico da consulta, que é Domiciliar
    @Override
    public String getTipo() { return "Domiciliar"; }

    // ========== MÉTODO ABSTRATO DE MENSAGEM DE CONFIRMAÇÃO ==========
    @Override
    public void confirmar() 
    {
        System.out.println("Consulta Domiciliar aprovada!");
        System.out.println("Endereço: " + getEndereco().toUpperCase());
        System.out.println("O médico chegará em até 1 hora.\n");
    }

    // Pega o valor da consulta domiciliar e joga ela no relatorio na soma das consultas domiciliares.
    @Override
    public void contabilizarNoFechamento(RelatorioConsultas relatorio) 
    {
        relatorio.somarDomiciliar(this.getValor());
    }
}