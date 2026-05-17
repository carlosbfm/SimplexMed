package simplexmed.estoque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_und_medida")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnidadeMedidaEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "und_seq")
   @SequenceGenerator(name = "und_seq" , sequenceName = "sq_tb_und_medida", allocationSize = 1)
   @Column(name = "nome_unidade", nullable = false)
   private Long codUndMedida; 

   @NotBlank(message = "O nome da unidade é obrigatório")
   @Size(min = 1, max = 30,message = "o nome da medida deve ter entre 2 e 30 caracteres.")
   @Column(name = "nome_da_und_medida", length = 30, nullable = false, unique = true)
   private String nomeUnidadeDeMedida;

   @NotBlank(message = "A abreviação é obrigatória")
   @Size(min = 1, max = 5, message = "A abreviação deve ter entre 2 a 5 caracteres")
   @Column(name = "abreviacao" , length = 5, nullable = false, unique = true)
   private String formaAbreviadaUnd;
}
