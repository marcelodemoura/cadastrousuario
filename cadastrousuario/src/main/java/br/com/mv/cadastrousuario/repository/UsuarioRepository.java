package br.com.mv.cadastrousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mv.cadastrousuario.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  public Optional<Usuario> findByCpf(String cpf);
}
