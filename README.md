# 🏥 Tipos de Consultas — Java & POO

Sistema simples em **Java** desenvolvido como atividade prática de **Programação Orientada a Objetos (POO)**, simulando o agendamento, a aplicação de descontos, a filtragem e o fechamento financeiro diário de diferentes modalidades de consultas médicas.

---

## 📋 Modalidades de Consulta

Todas as modalidades herdam da classe abstrata `Consulta`, especializando seu comportamento de confirmação e contabilização:

| Modalidade | Classe | Comportamento específico |
| :--- | :--- | :--- |
| **Presencial** | `Presencial` | Armazena a sala de atendimento e orienta chegada com 15 minutos de antecedência. |
| **Teleconsulta** | `Teleconsulta` | Gera automaticamente um link de acesso único com `UUID` e formata o link na exibição. |
| **Domiciliar** | `ConsultaDomiciliar` | Armazena o endereço do paciente e confirma o deslocamento médico em até 1 hora. |

---

## 🧠 Conceitos de POO Aplicados

- **Abstração:** classe abstrata `Consulta` definindo o contrato comum (`getTipo`, `confirmar` e `contabilizarNoFechamento`).
- **Herança:** reutilização de atributos (`paciente`, `valor`) e métodos (`exibirAgendamento`, `aplicarDesconto`) nas subclasses.
- **Encapsulamento:** atributos privados com validação de percentual no cálculo de desconto (`0%` a `100%`).
- **Polimorfismo:** lista única `List<Consulta>` processando agendamentos, filtros por tipo e contabilização no `RelatorioConsultas` sem `if/else` por tipo no fechamento.

---

## 📂 Estrutura do Projeto

```text
TiposConsultas/
├── Consulta.java            # Classe abstrata base com regras comuns e desconto
├── Presencial.java          # Subclasse para consultas presenciais em sala
├── Teleconsulta.java        # Subclasse para consultas online com link via UUID
├── ConsultaDomiciliar.java  # Subclasse para atendimentos em domicílio
├── RelatorioConsultas.java  # Consolida quantidades e subtotais por modalidade
└── Main.java                # Demonstração com agendamentos, desconto, filtro e relatório
```

---

## ▶️ Como Executar

Com o **JDK** instalado, basta compilar e executar na raiz do projeto:

```bash
javac *.java
java Main
```

### Exemplo do relatório gerado no console

```text
========== RELATÓRIO DAS CONSULTAS DO DIA ==========
PRESENCIAL   | Qtd: 3 | Subtotal: R$ 530,00
TELECONSULTA | Qtd: 2 | Subtotal: R$ 225,00
DOMICILIAR   | Qtd: 2 | Subtotal: R$ 550,00
------------------------------------------------
TOTAL GERAL  | Qtd: 7 | ARRECADADO: R$ 1305,00
================================================
```
