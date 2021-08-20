package br.senai.sp.model;

public class Cliente {
	private int id_cliente;
	private String cpf;
	private String nome;
	private String sobrenome;
	
	
	
	public Cliente() {
	}

	public Cliente(int id_cliente, String cpf, String nome, String sobrenome) {
		
		this.id_cliente = id_cliente;
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
}
