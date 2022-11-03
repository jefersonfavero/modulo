package br.com.clientevendedor.modulo.dto;

import java.util.ArrayList;
import java.util.List;

public class VendedorDto {
	private Long id;
	private String nome;
	private List<ClienteDto> clientes = new ArrayList<>();
	
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
	public List<ClienteDto> getClientes() {
		return clientes;
	}
	public void setClientes(List<ClienteDto> clientes) {
		this.clientes = clientes;
	}
	
	
	

	
	
}
