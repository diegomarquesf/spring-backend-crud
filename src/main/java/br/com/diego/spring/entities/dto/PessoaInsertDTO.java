package br.com.diego.spring.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data //LOMBOOK - GETS/SETS
public class PessoaInsertDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	//ATRIBUTOS DE PESSOA
	private String name;
	private String password;
	private String cpf;
	private String rg;
	private LocalDate birthday;
	private String email;
	private String cellphone;
	private String cellphone2;
	
	//ATRIBUTOS DE ENDEREÇO
	private String address;
	private Integer number;
	private String complement;
	private String district;
	private String city;
	private String zipCode;
	private Integer estadoEnum;
	
	

	
	
	
	
	
	
}
