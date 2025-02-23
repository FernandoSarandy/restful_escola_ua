package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		
		Professor cadastro = professorRepository.findByEmail(professor.getEmail());
		
		if(cadastro != null) {
			throw new RuntimeException("Email já cadastrado");
		}
		
		if(professor.getEmail().contains("@outlook.com") || professor.getEmail().contains("@outlook.com.br")) {
			throw new RuntimeException("Domínio de email não permitido");
		}
		
		this.professorRepository.save(professor);
		return professor.getNome() + " salvo com sucesso!";
	}
	
	public String update(long id, Professor professor) {
		professor.setId(id);
		this.professorRepository.save(professor);
		return professor.getNome() + " atualizado com sucesso!";
	}
	
	public String delete(long id) {
		String nome = findById(id).getNome();
		this.professorRepository.deleteById(id);
		return nome + " deletado com sucesso!";
	}
	
	public Professor findById(long id) {
		return this.professorRepository.findById(id).get();
	}
	
	public List<Professor> findAll(){
		return this.professorRepository.findAll();
	}
	
	public List<Professor> findByNomeLikeOrEspecialidadeLike(String nome, String especialidade){
		return this.professorRepository.findByNomeLikeOrEspecialidadeLike(nome, especialidade);
	}
	
	public List<Professor> findByEmailNaoGemail(){
		return this.professorRepository.findByEmailNaoGmail();
	}
	
	public Professor findByEmail(String email){
		return this.professorRepository.findByEmail(email);
	}
}
