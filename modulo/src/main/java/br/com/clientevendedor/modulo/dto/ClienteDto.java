package br.com.clientevendedor.modulo.dto;

import java.util.ArrayList;
import java.util.List;

public class ClienteDto {
	private Long id;
	private String nome;
	private List<VendedorDto> vendedores = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<VendedorDto> getVendedores() {
		return vendedores;
	}
	public void setVendedores(List<VendedorDto> vendedores) {
		this.vendedores = vendedores;
	}
	
	
}
