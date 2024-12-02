package br.com.appCadastroCliente.controller;

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

import br.com.appCadastroCliente.entity.Carro;
import br.com.appCadastroCliente.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro) {
		try {
			String mensagem = carroService.save(carro);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo de errado ao salvar o carro", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable Long id) {
		
		try {
			String mensagem = carroService.update(carro, id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo de errado ao atualizar o carro", HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete( @PathVariable Long id) {
		try {
			String mensagem = carroService.delete(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo de errado deletar o carro", HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll() {
		try {
			
			List<Carro> listCarros = carroService.findAll();
			return new ResponseEntity<>(listCarros, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		

	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome) {
		try {
			
			List<Carro> list = carroService.findByNome(nome);
			return new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		

	}
	
	@GetMapping("/findByid/{id}")
	public ResponseEntity<Carro> findByid(@PathVariable Long id) {
		try {
			
			Carro carro = carroService.findByid(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	
	
	 @GetMapping("/findByMarca") public ResponseEntity<List<Carro>>
	 findByMarca(@RequestParam long idMarca) { try {
	 
	 List<Carro> list = carroService.findByMarca(idMarca); return new
	 ResponseEntity<>(list, HttpStatus.OK);
	 
	 } catch (Exception e) { return new ResponseEntity<>(null,
	 HttpStatus.BAD_REQUEST); }
	 
	 
	 }
	 
	 @GetMapping("/findAcimaAno") public ResponseEntity<List<Carro>>
	 findAcimaAno(@RequestParam int ano) { try {
	 
	 List<Carro> list = carroService.findAcimaAno(ano); return new
	 ResponseEntity<>(list, HttpStatus.OK);
	 
	  } catch (Exception e) { return new ResponseEntity<>(null,
	HttpStatus.BAD_REQUEST); }
	 
	 
	  }


}
