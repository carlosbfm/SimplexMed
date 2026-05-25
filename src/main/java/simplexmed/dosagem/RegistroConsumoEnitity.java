package simplexmed.dosagem;

import java.time.LocalDateTime;


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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_registro_consumo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroConsumoEnitity {  
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reg_consumo_seq")
    @SequenceGenerator(name = "reg_consumo_seq", sequenceName = "sq_tb_registro_consumo", allocationSize = 1)  
    private Long resSeqConsumo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dosagem_id", nullable = false)
    private DosagemEntity dosagem;

    @Column(name = "data_hora_prevista", nullable = false)
    private LocalDateTime dataHoraPrevista;

    @Column(name = "data_hora_realizada")
    private LocalDateTime dataHoraRealizada;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_consumo", length = 20, nullable = false)
    private StatusConsumo status;
    
    @Column(name = "comentario_paciente",  length = 300)
    private String comentario;
}
