package br.com.appCadastroCliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appCadastroCliente.entity.Acessorio;
import br.com.appCadastroCliente.repository.AcessorioRepository;

@Service
public class AcessorioService {
	@Autowired
	private AcessorioRepository acessorioRepository;
	
	
	public String save(Acessorio acessorio) {
		acessorioRepository.save(acessorio);
		return acessorio.getNome() + " " + "O Acessorio foi salva com sucesso";
	}


	public String update(Acessorio acessorio, Long id) {
		acessorio.setId(id);
		acessorioRepository.save(acessorio);
		return acessorio.getNome() + " " + "Acessório alterado com sucesso";
	}


	public List<Acessorio> findAll() {		
		return this.acessorioRepository.findAll();
	}


	public Acessorio findById(Long id) {
		Acessorio acessorio = acessorioRepository.findById(id).get();		
		return acessorio;
	}


	public String delete(Long id) {
		this.acessorioRepository.deleteById(id);
		return "Acessório deletado com sucesso";
	}
	

//
//	public Marca fincById(Long id) {
//		Marca marca = marcaRepository.findById(id).get();
//		return marca;
//	}
//
//	public String delete(Long id) {
//		this.marcaRepository.deleteById(id);
//		return "Marca deletado com sucesso!";
//	}

	
	

}
