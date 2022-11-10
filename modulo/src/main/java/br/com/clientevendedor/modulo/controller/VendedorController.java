package br.com.clientevendedor.modulo.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.clientevendedor.modulo.dto.ClienteDto;
import br.com.clientevendedor.modulo.dto.VendedorDto;
import br.com.clientevendedor.modulo.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService service;

	@GetMapping
	public Page<VendedorDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.obterTodos(paginacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VendedorDto> detalhar(@PathVariable @NotNull Long id) {
		VendedorDto vendedor = service.obterPorId(id);
		return ResponseEntity.ok(vendedor);
	}

	@PostMapping
	public ResponseEntity<VendedorDto> cadastrar(@RequestBody @Valid VendedorDto dto, UriComponentsBuilder uriBuilder) {
		VendedorDto vendedor = service.criarVendedor(dto);
		URI endereco = uriBuilder.path("/vendedores/{id}").buildAndExpand(vendedor.getId()).toUri();
		return ResponseEntity.created(endereco).body(vendedor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<VendedorDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid VendedorDto dto) {
		VendedorDto vendedor = service.atualizarVendedor(id, dto);
		return ResponseEntity.ok(vendedor);
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<VendedorDto> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto dto){
		VendedorDto vendedor = service.atualizarClienteVendedor(id, dto);
		return ResponseEntity.ok(vendedor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<VendedorDto> remover(@PathVariable @NotNull Long id) {
		service.excluirVendedor(id);
		return ResponseEntity.noContent().build();
	}

}
