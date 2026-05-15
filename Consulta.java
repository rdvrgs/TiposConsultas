public abstract class Consulta {
    
    // ========== ATRIBUTOS ==========
    private String paciente;
    private double valor;
    private String tipo;

    // ========== CONSTRUTOR ==========
    public Consulta(String paciente, double valor) 
    {
        this.paciente = paciente;
        this.valor = valor;
    }

    // ========== GETTERS E SETTERS ==========
    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    // Definir getTipo como abstrato para cada subclasse implementar seu próprio TIPO.
    public abstract String getTipo();
    public void setTipo(String tipo) { this.tipo = tipo; }

    // ========== MÉTODOS ABSTRATOS ==========
    public abstract void confirmar();
    
    // ========== MÉTODO ABSTRATO PARA CONTABILIZAÇÃO NO RELATORIO DAS CONSULTAS ==========
    public abstract void contabilizarNoFechamento(RelatorioConsultas relatorio); // Cada subclasse é obrigada a usar o metodo

    // ========= METODO PARA EXIBIR ==========
    public void exibirAgendamento() {
        System.out.println("Paciente: " + paciente + " | R$" + String.format("%.2f", valor));
        confirmar();
    }

    // ========== METODO PARA APLICAR DESCONTO ===========
    public void aplicarDesconto(double percentual) 
    {
        if (percentual < 0 || percentual > 100) 
        {   
            System.out.println("Percentual inválido.");
        } 
        else 
        {
            // Se for um percentual valido, pega o valor e multiplica ele pelo percentual / 100.
            double valorDoDesconto = getValor() * (percentual / 100);
            setValor(getValor() - valorDoDesconto);
        }
    }

    // ========= SOBREPOSIÇÃO ==========
    @Override
    public String toString() 
    {
        return getPaciente() + " | R$" + String.format("%.2f", getValor());
    }
}