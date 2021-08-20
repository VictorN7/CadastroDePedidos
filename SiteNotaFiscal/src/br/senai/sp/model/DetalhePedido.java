package br.senai.sp.model;

public class DetalhePedido {

	private String cod_pedidos;
	private String descricao;
	private int quantidade;
	private float valor_unitario;
	private float valor_total;
	
	public DetalhePedido(String cod_pedidos, String descricao, int quantidade, float valor_unitario,
			float valor_total) {
		this.cod_pedidos = cod_pedidos;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
		this.valor_total = valor_total;
	}
	public String getCod_pedidos() {
		return cod_pedidos;
	}
	public void setCod_pedidos(String cod_pedidos) {
		this.cod_pedidos = cod_pedidos;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public float getValor_total() {
		return valor_total;
	}
	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}
	
	
	
}
