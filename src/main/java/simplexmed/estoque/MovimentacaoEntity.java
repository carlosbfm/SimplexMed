package simplexmed.estoque;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_movimentacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovimentacaoEntity {
    @Id
    @Column(name = "id_movimentacao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimento_seq")
    @SequenceGenerator(name = "movimento_seq", sequenceName = "sq_tb_movimentacao", allocationSize = 1)
    private Long idMovimentacao;

    @NotNull(message = "O vínculo com um estoque físico é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_estoque", nullable = false)
    private EstoqueEntity estoque;

    @NotNull(message = "Dentro do simplex tudo deve ser registrado em movimento")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimentacao", length = 30, nullable = false)
    private TipoMovimentacao tipoMovimentacao;

    @NotNull(message = "A quantidade alterada deve ser obrigatória")
    @DecimalMin(value = "0.01", message = "O saldo não deve ser igual a zero ou menor que o próprio")
    @Column(name = "quantidade_movimentada", precision = 10, scale = 2 , nullable = false )
    private BigDecimal quantidadeMovimentada;

    @Column(name = "justificativa", length = 255)
    private String justificativa;

    @CreationTimestamp
    @Column(name = "data_hora_mov", updatable = false)
    private LocalDateTime dataHoraMovimento;
}
