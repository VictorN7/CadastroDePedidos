package br.senai.sp.model;

public class DetalheDaNota {

	private int id;
	private String cod_pedidos;
	private int id_item;
	private int quantidade;
	
	
	public DetalheDaNota() {
	}
	
	public DetalheDaNota(String cod_pedidos, int id_item, int quantidade) {
		
		this.cod_pedidos = cod_pedidos;
		this.id_item = id_item;
		this.quantidade = quantidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCod_pedidos() {
		return cod_pedidos;
	}
	public void setCod_pedidos(String cod_pedidos) {
		this.cod_pedidos = cod_pedidos;
	}
	public int getId_item() {
		return id_item;
	}
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
