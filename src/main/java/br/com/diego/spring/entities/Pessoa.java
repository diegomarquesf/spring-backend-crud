package br.com.diego.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
	private String birthday;
	private String email;
	private String cellphone;
	private String cellphone2;
	
	@OneToMany(mappedBy = "pessoa") //RELACIONAMENTO MUITOS ENDEREÇO PARA UMA PESSOA - MAPEANDO ATRIBUTO DA CLASSE ENDERECO.
	private List<Endereco> listEndereco = new ArrayList<>();
	

}
