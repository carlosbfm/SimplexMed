package simplexmed.dosagem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tb_controle_dosagens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ControleDosagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "controle_dosagem_seq")
    @SequenceGenerator(name = "controle_dosagem_seq", sequenceName = "sq_tb_controle_dosagens", allocationSize = 1)
    @Column(name = "id_controle", updatable = false)
    private Long idControle;

    @NotNull(message = "A associação à dosagem de origem é obrigatória.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dosagem", nullable = false, updatable = false)
    private DosagemEntity dosagem;

    @NotNull(message = "O status original/anterior deve ser registrado.")
    @Enumerated(EnumType.STRING)
    @Column(name = "status_origem", length = 20, nullable = false, updatable = false)
    private StatusDosagem statusOrigem;

    @NotNull(message = "O novo status deve ser registrado.")
    @Enumerated(EnumType.STRING)
    @Column(name = "status_novo", length = 20, nullable = false, updatable = false)
    private StatusDosagem statusNovo;

    @CreatedDate
    @NotNull(message = "A data e hora da alteração é obrigatória.")
    @Column(name = "data_alteracao", nullable = false, updatable = false)
    private LocalDateTime dataAlteracao;

    @NotBlank(message = "O motivo clínico da alteração deve ser justificado.")
    @Size(min = 10, max = 500, message = "A justificativa deve ter entre 10 e 500 caracteres.")
    @Column(name = "motivo_alteracao", length = 500, nullable = false)
    private String motivoAlteracao;

    @NotBlank(message = "O identificador do profissional responsável pela alteração é obrigatório.")
    @Column(name = "profissional_responsavel", length = 100, nullable = false)
    private String profissionalResponsavel;
}