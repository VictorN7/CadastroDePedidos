package br.senai.sp.model;

public class Item {

	private int id_item;
	private String descricao;
	private float vlr_unitario;
	
	public Item() {
		
	}

	public Item(int id_item, String descricao, float vlr_unitario) {
		this.id_item = id_item;
		this.descricao = descricao;
		this.vlr_unitario = vlr_unitario;
	}
	
	public int getId_item() {
		return id_item;
	}
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getVlr_unitario() {
		return vlr_unitario;
	}
	public void setVlr_unitario(float vlr_unitario) {
		this.vlr_unitario = vlr_unitario;
	}
	
}
