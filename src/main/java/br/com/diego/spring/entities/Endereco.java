package br.com.diego.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.diego.spring.entities.enums.Estado;

@Entity
@Table(name = "tb_endereco")//NOME DA TABELA NO BANCO
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //GERAR ID AUTOMATICO
	private Long id;
	
	private String address;
	private Integer number;
	private String complement;
	private String district;
	private String city;
	private String zipCode;
	
	private Integer estadoEnum; //ATRIBUTO TRANSFORMADO EM INTEIRO PARA PEGAR O ID DO ENUM
	
	@ManyToOne //RELACIONAMENTO UMA PESSOA PARA VARIOS ENDEREÇOS
	@JoinColumn(name = "pessoa_id") // NOME DA CHAVE ESTRANGEIRA
	private Pessoa pessoa;

	public Endereco() {
	}

	public Endereco(Long id, String address, Integer number, String complement, String district, String city,
			String zipCode, Estado estadoEnum, Pessoa pessoa) {
		this.id = id;
		this.address = address;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.zipCode = zipCode;
		setEstadoEnum(estadoEnum); //ENUM
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Estado getEstadoEnum() {
		return Estado.valueOf(estadoEnum); //ENUM
	}

	public void setEstadoEnum(Estado estadoEnum) {
		if (estadoEnum != null) { //ENUM
			this.estadoEnum = estadoEnum.getCod();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	
	
	
	
	
 
}
