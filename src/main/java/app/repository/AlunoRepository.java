package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	public List<Aluno> findByNome(String nome);
	
	public List<Aluno> findByTelefone(String telefone);
	
	public List<Aluno> findByTurmaNome(String nome);
	
	public Aluno findByCpf(String cpf);
}
