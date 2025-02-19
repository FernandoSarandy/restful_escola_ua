package app.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O campo nome é obrigatório")
	@Pattern(regexp = "^\\S+\\s+\\S+.*$\r\n", message = "O nome deve conter nome e sobrenome")
	private String nome;
	
	@CPF
	private String cpf;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$  \r\n")
	private String email;
	
	@Pattern(regexp = "^(|\\S+\\s+\\S+.*)$\r\n")
	private String especialidade;
	
	@ManyToMany(mappedBy = "professores")
	@JsonIgnoreProperties("professores")
	private List<Turma> turmas;
	
}
