package br.com.appCadastroCliente.controller;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.appCadastroCliente.entity.Acessorio;
import br.com.appCadastroCliente.service.AcessorioService;



@RestController
@RequestMapping("/api/acessorio")
@CrossOrigin("*")
public class AcessorioController {

	@Autowired
	private AcessorioService acessorioService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Acessorio acessorio) {
		try {
			String mensagem = acessorioService.save(acessorio);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Aconteceu um erro ao salvar o acessório ", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Acessorio acessorio, @PathVariable Long id) {
		try {
			String mensagem = acessorioService.update(acessorio, id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Aconteceu um erro ao editar o acessório ", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Acessorio>> findAll() {
		try {
			List<Acessorio> listAcesorio = acessorioService.findAll();
			return new ResponseEntity<>(listAcesorio, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Acessorio> findById(@PathVariable Long id) {
		try {
			Acessorio acessorio = acessorioService.findById(id);
			return new ResponseEntity<>(acessorio, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id){
		try {
			String mensagem = acessorioService.delete(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Acessório deletado com sucesso", HttpStatus.BAD_REQUEST);
		}
	}

}
