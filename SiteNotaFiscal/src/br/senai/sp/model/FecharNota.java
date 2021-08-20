package br.senai.sp.model;

import java.util.Date;

public class FecharNota {

	private int id_nota_fiscal;
	private int id_cliente;
	private Date data_emissao;
	private String cod_pedidos;
	
	public FecharNota() {
	}
	public FecharNota(int id_cliente, String cod_pedidos) {
		this.id_cliente = id_cliente;
		this.cod_pedidos = cod_pedidos;
	}
	public int getId_nota_fiscal() {
		return id_nota_fiscal;
	}
	public void setId_nota_fiscal(int id_nota_fiscal) {
		this.id_nota_fiscal = id_nota_fiscal;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Date getData_emissao() {
		return data_emissao;
	}
	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}
	public String getCod_pedidos() {
		return cod_pedidos;
	}
	public void setCod_pedidos(String cod_pedidos) {
		this.cod_pedidos = cod_pedidos;
	}
	
}
