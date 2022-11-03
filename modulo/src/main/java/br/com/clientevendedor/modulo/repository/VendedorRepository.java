package br.com.clientevendedor.modulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clientevendedor.modulo.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}
