// biblioteca usada para gerar sequencia de letras aleatorias
import java.util.UUID;

public class Teleconsulta extends Consulta {

    // ========== ATRIBUTOS ==========
    private String linkAcesso;

    // ======== CONSTRUTOR ==========
    public Teleconsulta(String paciente, double valor) 
    {
        super(paciente, valor);
        // Gera um link unico automaticamente para nunca ficar vazio
        this.linkAcesso = "https://consultasrichard.com/" + UUID.randomUUID().toString().substring(0, 8);
    }
    
    // ======== GETTERS E SETTERS =========
    public String getLinkAcesso() { return linkAcesso; }
    public void setLinkAcesso(String linkAcesso) { this.linkAcesso = linkAcesso; }

    // Retorna o tipo específico da consulta, que é Teleconsulta
    @Override
    public String getTipo() { return "Teleconsulta"; }

    // ======== MÉTODOS ABSTRATO DE MENSAGEM DE CONFIRMAÇÃO ========
    @Override
    public void confirmar() 
    {
        // Exibe o link de acesso gerado para a teleconsulta
        System.out.println("Link de acesso: " + getLinkAcesso());
        System.out.println("É recomendado entrar no link 5 minutos antes do combinado.\n");
    }

    // Pega o valor da consulta online e joga ela no relatorio na soma das teleconsultas.
    @Override
    public void contabilizarNoFechamento(RelatorioConsultas relatorio)
    {
        relatorio.somarTeleconsulta(this.getValor());
    }

    // Define o objeto Teleconsulta como um texto, formatando ele.
    @Override
    public String toString() {
        return getPaciente() + " | R$" + String.format("%.2f", getValor()) + " | Link: " + linkAcesso;
    }
}