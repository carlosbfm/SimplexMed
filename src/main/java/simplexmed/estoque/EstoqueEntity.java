package simplexmed.estoque;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import simplexmed.medicamento.MedicamentoEntity;
import simplexmed.paciente.PacienteEntity;

@Entity
@Table(name = "tb_estoque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class EstoqueEntity {

    @Id
    @Column(name = "cod_estoque")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_seq")
    @SequenceGenerator(name = "estoque_seq", sequenceName = "sq_tb_estoque", allocationSize = 1)
    private Long codEstoque;

    @NotNull(message = "O paciente dono do estoque é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_paciente", nullable = false)
    private PacienteEntity paciente;

    @NotNull(message = "O medicamento armazenado deve ser obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_medicamento", nullable = false)
    private MedicamentoEntity medicamento;

    @NotNull(message = "A quantidade atual é obrigatória.")
    @DecimalMin(value = "0.0", message = "O estoque físico não pode ficar negativo")
    @Column(name = "quantidade_atual", precision = 10, scale = 2, nullable = false)
    private BigDecimal quantidadeAtual;

    @NotNull(message = "Alerta de quantidade mínima de estoque é obrigatória")
    @DecimalMin(value = "0.0")
    @Column(name = "quantidade_min_alerta", precision = 10, scale = 2, nullable = false)
    private BigDecimal quantidadeAlertaMinimo;

    @NotNull(message = "Obrigatório a unidade de medida")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_und_medida", nullable = false)
    private UnidadeMedidaEntity unidadeMedida;

    @LastModifiedDate
    @Column(name = "data_ultima_atualizacao")
    private LocalDate dataUltimaAtualizacao;

    @CreatedDate
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Version
    @Column(name = "versao_lock")
    private Long versao;
}
