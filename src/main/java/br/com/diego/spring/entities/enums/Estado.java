package br.com.diego.spring.entities.enums;

public enum Estado {

	
	AC(1, "Acre"),
	AL(2, "Alagoas"),
	AP(3, "Amapá"),
	AM(4, "Amazonas"),
	BA(5,"Bahia"),
	CE(6, "Ceará"),
	DF(7, "Distrito Federal"),
	ES(8, "Espírito Santo"),
	GO(9, "Goiás"),
	MA(10, "Maranhão"),
	MT(11, "Mato Grosso"),
	MS(12, "Mato Grosso do Sul"),
	MG(13, "Minas Gerais"),
	PA(14, "Pará"),
	PB(15, "Paraíba"),
	PR(16, "Paraná"),
	PE(17, "Pernambuco"),
	PI(18, "Piauí"),
	RJ(19, "Rio de Janeiro"),
	RN(20, "Rio Grande do Norte"),
	RS(21, "Rio Grande do Sul"),
	RO(22, "Rondônia"),
	RR(23, "Roraima"),
	SC(24, "Santa Catarina"),
	SP(25, "São Paulo"),
	SE(26, "Sergipe"),
	TO(27, "Tocantins");

	private int cod;
	private String descricao;
	
	private Estado(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public static Estado valueOf(int cod) { // METODO PARA PERCORRER O ID E RETORNAR O VALOR
		for (Estado value : Estado.values()) {
			if (cod == value.getCod()) {
				return value;
			}
		} throw new IllegalArgumentException("ID do Estado é Inválido");
	}
	
	
	
	
	
}
