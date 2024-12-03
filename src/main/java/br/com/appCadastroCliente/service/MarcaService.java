package br.com.appCadastroCliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appCadastroCliente.entity.Marca;
import br.com.appCadastroCliente.repository.MarcaRepository;

@Service
public class MarcaService {
	@Autowired
	private MarcaRepository marcaRepository;
	
	
	public  String save(Marca marca) {
		marcaRepository.save(marca);
		return marca.getNome() + " " + "A Marca foi salva com sucesso";
	}
	
	public String update(Marca marca, Long id) {
		marca.setId(id);
		marcaRepository.save(marca);
		return marca.getNome() + " " + "Marca Alterada Com sucesso ";
	}

	public List<Marca> findAll() {
		return this.marcaRepository.findAll();
	}

	public Marca fincById(Long id) {
		Marca marca = marcaRepository.findById(id).get();
		return marca;
	}

	public String delete(Long id) {
		this.marcaRepository.deleteById(id);
		return "Marca deletado com sucesso!";
	}

	
	

}
