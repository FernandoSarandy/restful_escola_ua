package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Turma;
import app.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
@CrossOrigin("*")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Turma turma){
			String mensagem = this.turmaService.save(turma);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
			String mensagem = this.turmaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable long id, @RequestBody Turma turma){
			String mensagem = this.turmaService.update(id, turma);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Turma> findById(@PathVariable long id){
			Turma turma = this.turmaService.findById(id);
			return new ResponseEntity<>(turma, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Turma>> findAll(){
			List<Turma> lista = this.turmaService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByAno")
	public ResponseEntity<List<Turma>> findByAno(@RequestParam int anoInicial, int anoFinal){
			List<Turma> lista = this.turmaService.findByAnoBetween(anoInicial, anoFinal);
			return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findBySemestreAndAno")
	public ResponseEntity<List<Turma>> findBySemestreAndAno(String semestre, int ano){
			List<Turma> lista = this.turmaService.findBySemestreAndAno(semestre, ano);
			return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByNomeAndTurno")
	public ResponseEntity<List<Turma>> findByNomeAndTurno(@RequestParam String nome, @RequestParam String turno){
			List<Turma> lista = this.turmaService.findByNomeAndAno(nome, turno);
			return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByCurso")
	public ResponseEntity<List<Turma>> findByCurso(@RequestParam String curso){
			List<Turma> lista = this.turmaService.findByCurso(curso);
			return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
