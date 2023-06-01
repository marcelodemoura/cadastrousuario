package br.com.mv.cadastrousuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mv.cadastrousuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
