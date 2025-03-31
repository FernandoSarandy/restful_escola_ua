package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	public List<Turma> findByAnoBetween(int anoInicial, int anoFinal);
	
	public List<Turma> findBySemestreAndAno(String semestre, int ano);
	
	public List<Turma> findByNomeAndTurno(String nome, String turno);
	
	public List<Turma> findByCursoNome(String curso);

}
