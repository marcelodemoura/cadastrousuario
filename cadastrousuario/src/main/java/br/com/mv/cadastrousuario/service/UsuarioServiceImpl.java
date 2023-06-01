package br.com.mv.cadastrousuario.service;
import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.mv.cadastrousuario.dto.UsuarioDto;
import br.com.mv.cadastrousuario.entity.Usuario;
import br.com.mv.cadastrousuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository repository;

    @Override
    public UsuarioDto save(UsuarioDto dto) {
        Usuario entity = new Usuario();
        BeanUtils.copyProperties(dto, entity);
        entity.setDataCriacao(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }
    
}
