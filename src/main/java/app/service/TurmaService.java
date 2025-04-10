package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	public String save(Turma turma) {
		this.turmaRepository.save(turma);
		return turma.getNome() + " salvo com sucesso!";
	}
	
	public String update(long id, Turma turma) {
		turma.setId(id);
		this.turmaRepository.save(turma);
		return turma.getNome() + " atualizado com sucesso!";
	}
	
	public String delete(long id) {
		String nome = findById(id).getNome();
		this.turmaRepository.deleteById(id);
		return nome + " deletado com sucesso!";
	}
	
	public Turma findById(long id) {
		return this.turmaRepository.findById(id).get();
	}
	
	public List<Turma> findAll(){
		return this.turmaRepository.findAll();
	}
	
	public List<Turma> findByAnoBetween(int anoInicial, int anoFinal){
		return this.turmaRepository.findByAnoBetween(anoInicial, anoFinal);
	}
	
	public List<Turma> findBySemestreAndAno(String semestre, int ano){
		return this.turmaRepository.findBySemestreAndAno(semestre, ano);
	}
	
	public List<Turma> findByNomeAndAno(String nome, String turno){
		return this.turmaRepository.findByNomeAndTurno(nome, turno);
	}
	
	public List<Turma> findByCurso(String curso){
		return this.turmaRepository.findByCursoNome(curso);
	}
}
