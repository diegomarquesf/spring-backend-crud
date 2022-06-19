package br.com.diego.spring.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data //LOMBOOK - GETS/SETS
public class PessoaInsertDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	//ATRIBUTOS DE PESSOA
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 120, message = "O tamanho deve ser entre 3 e 120 caracteres")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String password;
	
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
	
	//ATRIBUTOS DE ENDEREÇO
	@NotEmpty(message = "Preenchimento obrigatório")
	private String address;
	
	@NotNull(message = "Preenchimento obrigatório")
	@PositiveOrZero(message = "Preencher um número positivo")
	private Integer number;
	
	private String complement; 
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String district;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String city;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String zipCode;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer estadoEnum;
	
	

	
	
	
	
	
	
}
