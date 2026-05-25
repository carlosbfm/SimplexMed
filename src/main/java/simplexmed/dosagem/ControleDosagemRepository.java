package simplexmed.dosagem;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleDosagemRepository {
    @Query("SELECT c FROM ControleDosagemEntity c " +
           "WHERE c.dosagem.dosagemId = :dosagemId " +
           "AND (:inicio IS NULL OR c.dataAlteracao >= :inicio) " +
           "AND (:fim IS NULL OR c.dataAlteracao <= :fim) " +
           "AND (:status IS NULL OR c.statusNovo = :status) " +
           "ORDER BY c.dataAlteracao DESC")
    List<ControleDosagemEntity> buscarHistoricoFiltrado(
            @Param("dosagemId") Long dosagemId,
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim,
            @Param("status") StatusDosagem status);
}   
