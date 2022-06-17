package br.com.diego.spring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.diego.spring.entities.Pessoa;
import br.com.diego.spring.entities.dto.PessoaDTO;
import br.com.diego.spring.entities.dto.PessoaInsertDTO;
import br.com.diego.spring.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
		
	//BUSCAR TODOS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findAll(){
		List<PessoaDTO> listAll = pessoaService.findAll();
		return ResponseEntity.ok(listAll);
	}
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pessoa> findById(@PathVariable Long id){
		Pessoa pessoa = pessoaService.findById(id);
		
		return ResponseEntity.ok().body(pessoa);
	}
	
	//INSERIR 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Pessoa> insert(@RequestBody PessoaInsertDTO insertDTO){
		Pessoa pessoa = pessoaService.fromDTO(insertDTO);
		pessoa = pessoaService.insert(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath() 
				.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//ATUALIZAR 
	
	
	//DELETAR 

}
