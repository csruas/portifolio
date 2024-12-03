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

import br.com.appCadastroCliente.entity.Marca;
import br.com.appCadastroCliente.service.MarcaService;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Marca marca) {
		try {
			String mensagem = marcaService.save(marca);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo de errado ao salvar o carro", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Marca marca, @PathVariable Long id) {
		try {
			String mensagem = marcaService.update(marca, id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo de errado ao atualizar a marca", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Marca>> findAll() {
		try {
			List<Marca> listMarca = marcaService.findAll();
			return new ResponseEntity<>(listMarca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Marca> fincById(@PathVariable Long id)	{
		
		try {
			Marca marca = marcaService.fincById(id);
			return new ResponseEntity<>(marca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete( @PathVariable Long id) {
		try {
			String mensagem = marcaService.delete(id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu algo de errado deletar a marca", HttpStatus.BAD_REQUEST);
		}
		
	}
	


}
