package br.com.diego.spring.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.diego.spring.entities.Endereco;
import lombok.Data;

@Data //LOMBOOK - GETS/SETS
public class EnderecoDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	//ATRIBUTOS DE ENDEREÇO
		private Long idEndereco;
		
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
	
	public EnderecoDTO() {
		
	}
	
	public EnderecoDTO(Endereco endereco) {
		idEndereco = endereco.getId();
		address = endereco.getAddress();
		number = endereco.getNumber();
		complement = endereco.getComplement();
		district = endereco.getDistrict();
		city = endereco.getCity();
		zipCode = endereco.getZipCode(); 
	}


	
}
