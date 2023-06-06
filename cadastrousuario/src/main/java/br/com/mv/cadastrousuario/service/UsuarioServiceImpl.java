package br.com.mv.cadastrousuario.service;

import br.com.mv.cadastrousuario.dto.UsuarioDto;
import br.com.mv.cadastrousuario.entity.Usuario;
import br.com.mv.cadastrousuario.repository.UsuarioRepository;
import br.com.mv.cadastrousuario.service.exception.BadRequestException;
import br.com.mv.cadastrousuario.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;

    @Override
    public UsuarioDto save(UsuarioDto dto) {
        Usuario entity = new Usuario();
        BeanUtils.copyProperties(dto, entity);
        this.validationCpf(entity);
        entity.setDataCriacao(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    @Override
    public Page<UsuarioDto> findAll(Pageable pageable) {
        Page<Usuario>list =repository.findAll(pageable);
        return list.map(x -> new UsuarioDto(x));
    }

    @Override
    public Optional<UsuarioDto> findById(Long id){
        Optional<Usuario>usuarioOptional = repository.findById(id);
        Usuario entity = usuarioOptional.orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
        return Optional.of(new UsuarioDto(entity));
    }

    @Override
    public UsuarioDto update(Long id, UsuarioDto dto) {
        Usuario entity = repository.findById(id).orElseThrow(()-> new NotFoundException("Usuario não encontrado"));
        if (dto.getCpf()!=null){
            entity.setCpf(dto.getCpf());
        }
        if (dto.getNome() != null){
            entity.setNome(dto.getNome());
        }
        if (dto.getEmail() != null){
            entity.setEmail(dto.getEmail());
        }
        if (dto.getTelefone() != null){
            entity.setTelefone(dto.getTelefone());
        }
        entity.setDataAtualizacao(LocalDateTime.now());
        repository.save(entity);
        return new UsuarioDto(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(()-> new NotFoundException("Usuario de" +id + "não foi encontrado."));
        repository.deleteById(id);

    }
    private void validationCpf(Usuario entity){
        Optional<Usuario>usuarioOptional = repository.findByCpf(entity.getCpf());
        if (usuarioOptional.isPresent()){
            throw new BadRequestException("Cpf já cadastrado!");
        }

    }

}
