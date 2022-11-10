package br.com.clientevendedor.modulo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.clientevendedor.modulo.dto.ClienteDto;
import br.com.clientevendedor.modulo.dto.VendedorDto;
import br.com.clientevendedor.modulo.model.Cliente;
import br.com.clientevendedor.modulo.model.Vendedor;
import br.com.clientevendedor.modulo.repository.VendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private VendedorRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public Page<VendedorDto> obterTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(p -> modelMapper.map(p, VendedorDto.class));
	}

	public VendedorDto obterPorId(Long id) {
		Vendedor vendedor = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(vendedor, VendedorDto.class);
	}

	public VendedorDto criarVendedor(VendedorDto dto) {
		Vendedor vendedor = modelMapper.map(dto, Vendedor.class);
		repository.save(vendedor);
		return modelMapper.map(vendedor, VendedorDto.class);
	}

	public VendedorDto atualizarVendedor(Long id, VendedorDto dto) {
		Vendedor vendedor = modelMapper.map(dto, Vendedor.class);
		vendedor.setId(id);
		vendedor = repository.save(vendedor);
		return modelMapper.map(vendedor, VendedorDto.class);
	}
	
	public VendedorDto atualizarClienteVendedor(Long id, ClienteDto dto) {
		Vendedor vendedor = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		vendedor.setCliente(cliente);
		vendedor = repository.save(vendedor);
		return modelMapper.map(vendedor, VendedorDto.class);
	}

	public void excluirVendedor(Long id) {
		repository.deleteById(id);
	}
}

