package br.com.diego.spring.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.diego.spring.entities.Pessoa;
import lombok.Data;

@Data //LOMBOOK - GETS/SETS
public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	private Long id;
	private String name;
	private String cpf;
	private String rg;
	private String email;
	private LocalDate birthday;
	private String cellphone;
	private String cellphone2;
	
	public PessoaDTO () {
		
	}

	
	public PessoaDTO(Pessoa pessoa) {
		id = pessoa.getId();
		name = pessoa.getName();
		cpf = pessoa.getCpf();
		rg = pessoa.getRg();
		email = pessoa.getEmail();
		birthday = pessoa.getBirthday();
		cellphone = pessoa.getCellphone();
		cellphone2 = pessoa.getCellphone2();		
	}


	
	
}
