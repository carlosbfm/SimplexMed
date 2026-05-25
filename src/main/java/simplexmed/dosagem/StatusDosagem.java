package simplexmed.dosagem;

import lombok.Getter;

@Getter
public enum StatusDosagem {
    ATIVA("Ativa", "O tratamento está em curso e a gerar alertas."),
    PAUSADA("Pausada", "O tratamento foi temporariamente interrompido (ex: cirurgia ou exames)."),
    FINALIZADA("Finalizada", "O ciclo do tratamento foi totalmente concluído."),
    AJUSTADA("Posologia Ajustada",
            "A dose original foi modificada. Esta prescrição está inativa e foi substituída por uma nova versão.");

    private final String titulo;
    private final String descricao;

    StatusDosagem(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}