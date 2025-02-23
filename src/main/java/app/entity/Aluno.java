package app.entity;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "O campo nome é obrigatório")
	@Pattern(regexp = "^\\S+\\s+\\S+.*$\r\n", message = "O nome deve conter nome e sobrenome.")
	private String nome;
	@CPF
	private String cpf;
	@Pattern(regexp = "^\\d{10,11}$")
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	private boolean cadastroCompleto;
}

