package br.com.estoque.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produto {
	
	@JsonProperty
	private long id;
	
	@JsonProperty
	private int codigoBarra;
	
	@JsonProperty
	private String nome;
	
	@JsonProperty
	private String descricao;
	
	@JsonProperty
	private Long quantidade;
	
	@JsonProperty
	private String categoria;


	public int getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(int codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
