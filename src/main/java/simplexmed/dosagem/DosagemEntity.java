package simplexmed.dosagem;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simplexmed.medicamento.MedicamentoEntity;
import simplexmed.paciente.PacienteEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_dosagens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DosagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dosagem_seq")
    @SequenceGenerator(name = "dosagem_seq", sequenceName = "sq_tb_dosagens", allocationSize = 1)
    @Column(name = "id_dosagem")
    private Long dosagemId;

    @NotNull(message = "A associação a um paciente é obrigatória.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity paciente;

    @NotNull(message = "A associação a um medicamento é obrigatória.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medicamento", nullable = false)
    private MedicamentoEntity medicamento;

    @NotNull(message = "A quantidade da dose é obrigatório")
    @DecimalMin(value = "0.01", message = "A dose deve ser maior que zero")
    @Column(name = "quantidade_dose", precision = 10, scale = 2, nullable = false)
    private BigDecimal quantidadeDose;

    @Embedded
    private Frequencia frequencia; 

    @NotNull(message = "A data de início do tratamento é obrigatória.")
    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim; 

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status_dosagem", length = 20, nullable = false)
    private StatusDosagem status;

    @Column(name = "observacoes_clinicas", length = 500)
    private String observacoes;

}