package simplexmed.paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_pacientes")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PacienteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_seq") // Sequencia Nativa do PostgreSQL
    @SequenceGenerator(name = "paciente_seq", sequenceName = "sq_tb_pacientes", allocationSize = 1) // Evitar saltos de 50 em 50
    @Column(name = "cod_paciente")
    private Long codPaciente;

    @Column(name = "nome_paciente" , length = 100, nullable = false)
    private String nomePaciente;

    @Column(name = "cpf" , length = 14, unique = true, nullable = false)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "telefone", length = 15)
    private String telefonePaciente;

    @Embedded
    private Endereco endereco;

    @Column(name = "data_cadastro", updatable = false)
    @CreatedDate
    private LocalDateTime dataCadastro;
}
