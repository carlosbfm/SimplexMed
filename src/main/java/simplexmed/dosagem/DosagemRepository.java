package simplexmed.dosagem;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosagemRepository extends JpaRepository<DosagemEntity, Long> {

    List<DosagemEntity> findByPacienteCodPaciente(Long codPaciente);

    List<DosagemEntity> findByPacienteCodPacienteAndStatusDosagem(Long codPaciente, StatusDosagem statusDosagem);

    boolean existsByPacienteCodPacienteAndMedicamentoCodMedicamentoAndStatusDosagem(
            Long codPaciente,
            Long codMedicamento,
            StatusDosagem statusDosagem);

    // query referente a receita para um determinado paciente e medicamento
    // útil pra consultas

    Optional<DosagemEntity> findByPacienteCodPacienteAndMedicamentoCodMedicamentoAndStatusDosagem(
            Long codPaciente,
            Long codMedicamento,
            StatusDosagem statusDosagem);
}
