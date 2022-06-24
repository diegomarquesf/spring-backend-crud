package br.com.diego.spring.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.diego.spring.entities.Pessoa;
import lombok.Data;

@Data //LOMBOOK - GETS/SETS
public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	private Long idPessoa;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 120, message = "O tamanho deve ser entre 3 e 120 caracteres")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@CPF(message = "Preencha um CPF Válido")
	private String cpf;
	
	private String rg;
	
	@NotNull(message = "Preenchimento obrigatório")
	@PastOrPresent(message = "Preencher uma data que não esteja no futuro")
	private LocalDate birthday;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cellphone;
	
	private String cellphone2;
	
	public PessoaDTO() {
		
	}
	
	public PessoaDTO(Pessoa pessoa) {
		idPessoa = pessoa.getId();
		name = pessoa.getName();
		cpf = pessoa.getCpf();
		rg = pessoa.getRg();
		email = pessoa.getEmail();
		birthday = pessoa.getBirthday();
		cellphone = pessoa.getCellphone();
		cellphone2 = pessoa.getCellphone2();		
	}



	
	
}
