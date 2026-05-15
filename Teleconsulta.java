import java.util.UUID;

public class Teleconsulta extends Consulta {

    // ========== ATRIBUTOS ==========
    private String linkAcesso;

    // ======== CONSTRUTOR ==========
    public Teleconsulta(String paciente, double valor) 
    {
        super(paciente, valor);
        // Gera o link no construtor para nunca ficar null
        this.linkAcesso = "https://consultasrichard.com/" + UUID.randomUUID().toString().substring(0, 8);
    }
    
    // ======== GETTERS E SETTERS =========
    public String getLinkAcesso() { return linkAcesso; }
    public void setLinkAcesso(String linkAcesso) { this.linkAcesso = linkAcesso; }

    // Retorna o tipo específico da consulta, que é "Teleconsulta"
    @Override
    public String getTipo() { return "Teleconsulta"; }

    // ======== MÉTODOS ========
    @Override
    public void confirmar() {
        System.out.println("Link de acesso: " + this.linkAcesso);
        System.out.println("É recomendado entrar no link 5 minutos antes do combinado.\n");
    }

    // Polimorfismo: O objeto sabe a própria gaveta onde deve guardar o valor
    @Override
    public void contabilizarNoFechamento(RelatorioConsultas relatorio)
    {
        relatorio.somarTeleconsulta(this.getValor());
    }

    @Override
    public String toString() {
        return getPaciente() + " | R$" + String.format("%.2f", getValor()) + " | Link: " + linkAcesso;
    }
}