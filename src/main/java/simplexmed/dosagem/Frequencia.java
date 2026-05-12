package simplexmed.dosagem;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Frequencia {

    @Column(name = "intervalo_hora")
    private Integer intervaloHoras;

    @ElementCollection
    @CollectionTable(
        name = "tb_dosagem_h_fixos",
        joinColumns = @JoinColumn(name = "dosagem_id")
    )
    @Column(name = "horario_fixo")
    private List<LocalTime> horariosFixos;

    @Column(name = "is_sos")
    private Boolean isSos;

    @Column(name = "obs_horario", length = 100)
    private String observacao;
}   
