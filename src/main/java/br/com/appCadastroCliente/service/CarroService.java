package br.com.appCadastroCliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appCadastroCliente.entity.Carro;
import br.com.appCadastroCliente.entity.Marca;
import br.com.appCadastroCliente.repository.CarroRepository;

@Service
public class CarroService {
	@Autowired
	private CarroRepository carroRepository;
	
	
	public  String save(Carro carro) {
		carroRepository.save(carro);
		return carro.getNome() + "Carro salvo com sucesso";
	}
	
	public String update(Carro carro, Long id) {
		carro.setId(id);
		carroRepository.save(carro);
		return carro.getNome() + "Alterado Com sucesso";
	}	
	
	public List<Carro> findAll(){
		return this.carroRepository.findAll();
	}
	
	public Carro findByid(long id) {
		Carro carro = carroRepository.findById(id).get();
		return carro;
	}
	
	public String delete(long id) {
		this.carroRepository.deleteById(id);
		return "Carro deletado com sucesso!";
	}
	
	//buscas costumizadas
	public List<Carro> findByNome(String nome){
		return carroRepository.findByNome(nome);
	}
	
	public List<Carro> findByMarca( long idMarca ){
		Marca marca = new Marca();
		marca.setId(idMarca);
		return carroRepository.findByMarca(marca);
	}
	
	public List<Carro> findAcimaAno( int ano ){
		return carroRepository.findAcimaAno(ano);
	}

}
