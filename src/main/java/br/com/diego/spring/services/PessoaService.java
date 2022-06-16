package br.com.diego.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.spring.entities.Endereco;
import br.com.diego.spring.entities.Pessoa;
import br.com.diego.spring.entities.dto.PessoaDTO;
import br.com.diego.spring.entities.dto.PessoaInsertDTO;
import br.com.diego.spring.entities.enums.Estado;
import br.com.diego.spring.repositories.EnderecoRepository;
import br.com.diego.spring.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	
	//LISTAR TUDO
	public List<PessoaDTO> findAll(){
		List<Pessoa> list = pessoaRepository.findAll();
		List<PessoaDTO> listDTO = list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
		return listDTO;
	}
	
	/*
	public Pessoa findById (Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, ID:" + id , null));
	}*/
	
	//LISTAR POR ID
	public PessoaDTO findById(Long id){
			Pessoa pessoa = pessoaRepository.findById(id).get();
			PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
			return pessoaDTO;
	}
	
	
	@Transactional
	public Pessoa insert (Pessoa pessoa) {
		pessoa = pessoaRepository.save(pessoa);
		enderecoRepository.saveAll(pessoa.getListEndereco());
		return pessoa;
	}
	
	public Pessoa fromDTO(PessoaInsertDTO insertDTO) {
		Pessoa pessoa = new Pessoa(null, insertDTO.getName(), insertDTO.getPassword(), insertDTO.getCpf(), insertDTO.getRg(), insertDTO.getBirthday(), insertDTO.getEmail(), insertDTO.getCellphone(), insertDTO.getCellphone2());
		Endereco endereco = new Endereco(null, insertDTO.getAddress(), insertDTO.getNumber(), insertDTO.getComplement(), insertDTO.getDistrict(), insertDTO.getCity(), insertDTO.getZipCode(), Estado.valueOf(insertDTO.getEstadoEnum()),pessoa);
		pessoa.getListEndereco().add(endereco);
		
		return pessoa;
		
	}
}
