    package br.com.diego.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.diego.spring.entities.Endereco;
import br.com.diego.spring.entities.Pessoa;
import br.com.diego.spring.entities.dto.PessoaDTO;
import br.com.diego.spring.entities.dto.PessoaInsertDTO;
import br.com.diego.spring.entities.enums.Estado;
import br.com.diego.spring.repositories.EnderecoRepository;
import br.com.diego.spring.repositories.PessoaRepository;
import br.com.diego.spring.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	//LISTAR TUDO
	public List<PessoaDTO> findAll(){
		List<Pessoa> list = pessoaRepository.findAll();
		List<PessoaDTO> listDTO = list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
		return listDTO;
	}
	
	//LISTAR PESSOA POR ID
	public Pessoa findById (Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.orElseThrow(() -> new ObjectNotFoundException("O id "+id+ " não foi encontrado!"));
	}
	
	//INSERÇÃO DOS DADOS
	@Transactional
	public Pessoa insert (Pessoa pessoa) {
		pessoa = pessoaRepository.save(pessoa);
		enderecoRepository.saveAll(pessoa.getListEndereco());
		return pessoa;
	}
	
	//ALTERAÇÃO DOS DADOS
	public Pessoa update(Pessoa pessoa) {
		Pessoa newPessoa = findById(pessoa.getId());
		updateData(newPessoa, pessoa);
		return pessoaRepository.save(newPessoa);
	}
	
	private void updateData(Pessoa newPessoa, Pessoa pessoa) {
		newPessoa.setName(pessoa.getName());
		newPessoa.setCpf(pessoa.getCpf());
		newPessoa.setRg(pessoa.getRg());
		newPessoa.setBirthday(pessoa.getBirthday()); 
		newPessoa.setEmail(pessoa.getEmail());
		newPessoa.setCellphone(pessoa.getCellphone());
		newPessoa.setCellphone2(pessoa.getCellphone2());
		newPessoa.setListEndereco(pessoa.getListEndereco());
	}
	
	
	//EXCLUIR DADOS
	
	
	public Pessoa fromDTO(PessoaDTO pessoaDTO) {
		return new Pessoa(pessoaDTO.getIdPessoa(), pessoaDTO.getName(), null, pessoaDTO.getCpf(), pessoaDTO.getRg(), pessoaDTO.getBirthday(), pessoaDTO.getEmail(), pessoaDTO.getCellphone(), pessoaDTO.getCellphone2());
	}
	
	//INSTANCIANDO CLIENTE E ENDEREÇO PARA O DTO DE CLIENTENEWDTO
	public Pessoa fromDTO(PessoaInsertDTO insertDTO) {
		Pessoa pessoa = new Pessoa(null, insertDTO.getName(), encoder.encode(insertDTO.getPassword()), insertDTO.getCpf(), insertDTO.getRg(), insertDTO.getBirthday(), insertDTO.getEmail(), insertDTO.getCellphone(), insertDTO.getCellphone2());
		Endereco endereco = new Endereco(null, insertDTO.getAddress(), insertDTO.getNumber(), insertDTO.getComplement(), insertDTO.getDistrict(), insertDTO.getCity(), insertDTO.getZipCode(), Estado.valueOf(insertDTO.getEstadoEnum()),pessoa);
		pessoa.getListEndereco().add(endereco);
		
		return pessoa; 
		
	}

	/*//LISTAR POR ID
		/*public Pessoa findById (Long id) {
		Pessoa pessoa = pessoaRepository.findById(id).get(); 
		return pessoa;
	}*/
	
	
}

