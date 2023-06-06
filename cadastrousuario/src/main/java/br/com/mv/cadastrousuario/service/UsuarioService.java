package br.com.mv.cadastrousuario.service;

import br.com.mv.cadastrousuario.dto.UsuarioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioService {
    UsuarioDto save(UsuarioDto dto);
    Page<UsuarioDto>findAll(Pageable pageable);
    Optional<UsuarioDto> findById(Long id );
    UsuarioDto update(Long id, UsuarioDto dto);
    void delete(Long id);


}
