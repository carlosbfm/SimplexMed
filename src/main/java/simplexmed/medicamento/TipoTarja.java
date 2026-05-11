package simplexmed.medicamento;

import lombok.Getter;

@Getter
public enum TipoTarja {
    SEM_TARJA("Sem Tarja", "Venda livre; isento de prescrição (MIP)."),
    VERMELHA("Tarja Vermelha", "Exige receita médica; pode haver retenção."),
    PRETA("Tarja Preta", "Controle especial com retenção obrigatória de receita."),
    AMARELA("Tarja Amarela", "Medicamento genérico conforme legislação.");

    private final String tipoTarja;
    private final String descricao;

    TipoTarja(String tipoTarja, String descricao){
        this.tipoTarja = tipoTarja;
        this.descricao = descricao;
    }

}
