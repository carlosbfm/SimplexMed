package simplexmed.dosagem;

import lombok.Getter;

@Getter
public enum StatusConsumo {
    PENDENTE("Pendente", "A dose está agendada e aguarda a ação do paciente."),
    TOMADO("Tomado", "O paciente confirmou a ingestão dentro da janela de horário correta."),
    ATRASADO("Atrasado", "A dose foi tomada, porém fora da janela de tolerância recomendada."),
    PULADO("Pulado", "O paciente indicou ativamente que decidiu não tomar esta dose."),
    CANCELADO("Cancelado", "Dose abortada pelo sistema devido a pausa ou alteração da prescrição.");

    private final String titulo;
    private final String descricao;

    StatusConsumo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
}