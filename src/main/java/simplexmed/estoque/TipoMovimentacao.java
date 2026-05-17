package simplexmed.estoque;

import lombok.Getter;

@Getter
public enum TipoMovimentacao {
    
    ENTRADA_COMPRA("Entrada por Compra", "Medicamento adquirido pelo paciente via farmácia.", 1),
    ENTRADA_DOACAO("Entrada por Doação", "Medicamento recebido via SUS ou amostra grátis médica.", 1),
    AJUSTE_ENTRADA("Ajuste Manual de Entrada", "Correção manual de saldo físico positivo.", 1),

    SAIDA_CONSUMO("Saída por Consumo", "Dedução automática via registro de dosagem do paciente.", -1),
    SAIDA_VENCIMENTO("Saída por Validade", "Descarte do lote por expiração do prazo de validade.", -1),
    SAIDA_AVARIA("Saída por Avaria", "Perda física do medicamento (ex: quebra de frasco, umidade).", -1),
    AJUSTE_SAIDA("Ajuste Manual de Saída", "Correção manual de saldo físico negativo.", -1);

    private final String titulo;
    private final String descricao;
    private final int fatorMatematico;

    TipoMovimentacao(String titulo, String descricao, int fatorMatematico) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.fatorMatematico = fatorMatematico;
    }
}
