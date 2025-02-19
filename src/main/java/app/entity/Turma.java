package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String nome;
	private String semestre;
	private int ano;
	private String turno;
	
	@ManyToMany
	@JoinTable(
			name = "turma_professor",
			joinColumns = @JoinColumn(name = "id_turma"),
			inverseJoinColumns = @JoinColumn(name = "id_professor")
			)
	@JsonIgnoreProperties("turmas")
	private List<Professor> professores;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name =  "id_curso")
	private Curso curso;
}
