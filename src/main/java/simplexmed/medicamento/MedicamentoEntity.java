package simplexmed.medicamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_medicamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "med_seq")
    @SequenceGenerator(name = "med_seq", sequenceName = "sq_tb_medicamentos", allocationSize = 1)
    @Column(name = "cod_medicamento", nullable = false)
    private Long codMedicamento;

    @NotBlank(message = "O nome comercial é obrigatório")
    @Size(min = 2, max = 150)
    @Column(name = "nome_comercial", length = 100, nullable = false)
    private String nomeComercial;

    @NotBlank(message = "O registro ANVISA é obrigatório")
    @Column(name = "registro_anvisa", length = 13, nullable = false)
    private String registroAnvisa;

    @NotBlank(message = "O princípio ativo é obrigatório")
    @Column(name = "principioAtivo", length = 100, nullable = false)
    private String principioAtivo;

    @Column(name = "dosagem_referencia", length = 50)
    private String dosagem;

    // regulação da tarja

    @NotNull(message = "A classificação da tarja é obrigratória")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tarja",unique = true, nullable = false)
    private TipoTarja tipoTarja;

    // PARTE FÍSICA medicação

    @NotNull(message = "A categoria física (Macro) é obrigatória")
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_fisica",nullable = false)
    private TipoMedicamento categoriaFisica;

    @Column(name = "forma_farm_especifica", length = 100)
    private String formaFarmaceuticaEspecifica;

    // VIA DE ACESSO da medicação

    @NotNull(message = "A categoria da via(Macro) é obrigatória")
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_via", nullable = false)
    private CategoriaVia categoriaVia;

    @Column(name = "via_adminst_especifica",  length = 100)
    private String viaAdministracaoEspecifica;
    
}