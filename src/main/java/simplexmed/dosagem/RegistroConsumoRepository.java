package simplexmed.dosagem;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroConsumoRepository extends JpaRepository<RegistroConsumoEnitity, Long> {

    List<RegistroConsumoEnitity> findByDosagemPacienteCodPacienteAndDataHoraPrevistaBetween(
            Long codPaciente,
            LocalDateTime inicioDia,
            LocalDateTime fimDia);

    List<RegistroConsumoEnitity> findByDosagemIdAndStatus(Long idDosagem, StatusConsumo status);
}
