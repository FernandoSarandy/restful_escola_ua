package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public String save(Aluno aluno) {
		
		Aluno cadastro = this.alunoRepository.findByCpf(aluno.getCpf());
		
		
		if(cadastro != null) {
			throw new RuntimeException(cadastro.getNome() + " já está cadastrado");
		}
		
		if(aluno.getTelefone() == null) {
			aluno.setCadastroCompleto(false);
		} else {
			aluno.setCadastroCompleto(true);
		}
		
		this.alunoRepository.save(aluno);
		return aluno.getNome() + " salvo com sucesso!";
	}
	
	public String update(long id, Aluno aluno) {
		aluno.setId(id);
		
		if(aluno.getTelefone() == null) {
			aluno.setCadastroCompleto(false);
		} else {
			aluno.setCadastroCompleto(true);
		}
		
		this.alunoRepository.save(aluno);
		return aluno.getNome() + " atualizado com sucesso!";
	}
	
	public String delete(long id) {
		String nome = findById(id).getNome();
		this.alunoRepository.deleteById(id);
		return nome + " deletado com sucesso!";
	}
	
	public Aluno findById(long id) {
		return this.alunoRepository.findById(id).get();
	}
	
	public List<Aluno> findAll(){
		return this.alunoRepository.findAll();
	}
	
	public List<Aluno> findByNome(String nome){
		return this.alunoRepository.findByNome(nome);
	}
	
	public List<Aluno> findByTelefoneContaining(String telefone){
		return this.alunoRepository.findByTelefone(telefone);
	}
	
	public List<Aluno> findByTurmaNomeLike(String nome){
		return this.alunoRepository.findByTurmaNome("%" + nome + "%");
	}
}
