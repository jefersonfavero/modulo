package br.com.clientevendedor.modulo.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.clientevendedor.modulo.dto.ClienteDto;
import br.com.clientevendedor.modulo.model.Cliente;
import br.com.clientevendedor.modulo.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	public Page<ClienteDto> obterTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(p -> modelMapper.map(p, ClienteDto.class));
	}

	public ClienteDto obterPorId(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(cliente, ClienteDto.class);
	}

	public ClienteDto criarCliente(ClienteDto dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		repository.save(cliente);
		return modelMapper.map(cliente, ClienteDto.class);
	}

	public ClienteDto atualizarCliente(Long id, ClienteDto dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.setId(id);
		cliente = repository.save(cliente);
		return modelMapper.map(cliente, ClienteDto.class);
	}

	public void excluirCliente(Long id) {
		repository.deleteById(id);
	}
 
}
