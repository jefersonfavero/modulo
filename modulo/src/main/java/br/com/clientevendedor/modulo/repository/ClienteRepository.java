package br.com.clientevendedor.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clientevendedor.modulo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
