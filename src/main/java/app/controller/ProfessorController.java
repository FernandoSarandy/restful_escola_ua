package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Professor;
import app.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Professor professor){
			String mensagem = this.professorService.save(professor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
			String mensagem = this.professorService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id, @RequestBody Professor professor){
			String mensagem = this.professorService.update(id, professor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Professor> findById(@PathVariable long id){
			Professor professor = this.professorService.findById(id);
			return new ResponseEntity<>(professor, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Professor>> findAll(){
			List<Professor> lista = this.professorService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByNomeOrEspecialidade")
	public ResponseEntity<List<Professor>> findByNomeLikeOrEspecialidadeLike(@RequestParam String termo){
			List<Professor> lista = this.professorService.findByNomeLikeOrEspecialidadeLike(termo, termo);
			return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByEmailNaoGmail")
	public ResponseEntity<List<Professor>> findByEmailNaoGmail(){
			List<Professor> lista = this.professorService.findByEmailNaoGemail();
			return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<Professor> findByEmail(@RequestParam String email){
			Professor professor = this.professorService.findByEmail(email);
			return new ResponseEntity<>(professor, HttpStatus.OK);
	}
}
