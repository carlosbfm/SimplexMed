package simplexmed.medicamento;

import lombok.Getter;

@Getter
public enum CategoriaVia {
    ENTERAL("Passa pelo trato digestivo (Oral,Sublingual,Retal)"),
    PARENTERAL("Injetáveis que não passam pela digestão (Intravenosa,Intramuscular)"),
    TOPICA("Aplicação local em pele ou mucosas (Cutânea, Oftálmica,Otológica)"),
    RESPIRATORIA("Absorção pelos pulmões(Inalatória)");

    private final String descricao;

    CategoriaVia(String descricao){
        this.descricao = descricao;
    }

}
