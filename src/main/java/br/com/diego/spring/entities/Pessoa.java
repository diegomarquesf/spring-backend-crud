package br.com.diego.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_pessoa") //NOME DA TABELA NO BANCO
@Data //LOMBOOK - GETS/SETS
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //GERAR ID AUTOMATICO
	private Long id;
	
	private String name;
	private String password;
	private String cpf;
	private String rg;
	private LocalDate birthday;
	private String email;
	private String cellphone;
	private String cellphone2;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL) //RELACIONAMENTO MUITOS ENDEREÇO PARA UMA PESSOA - MAPEANDO ATRIBUTO DA CLASSE ENDERECO.
	private List<Endereco> listEndereco = new ArrayList<>();
	
	public Pessoa() {
		
	}

	public Pessoa(Long id, String name, String password, String cpf, String rg, LocalDate birthday, String email,
			String cellphone, String cellphone2) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.cpf = cpf;
		this.rg = rg;
		this.birthday = birthday;
		this.email = email;
		this.cellphone = cellphone;
		this.cellphone2 = cellphone2;
	}

	

	
	
	

}
