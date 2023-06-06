package br.com.mv.cadastrousuario.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.mv.cadastrousuario.dto.UsuarioDto;
import br.com.mv.cadastrousuario.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    
    private final UsuarioServiceImpl service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto salvar(@RequestBody UsuarioDto dto){
        return service.save(dto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<UsuarioDto> listarTodos(@PageableDefault(page = 0, size = 10, sort = "id")Pageable pageable){
        return service.findAll(pageable);
    }
    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UsuarioDto> buscarId(@PathVariable Long id){
        Optional <UsuarioDto>dto = service.findById(id);
        return dto;
    }
    @PatchMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto atualizar(@PathVariable Long id,@RequestBody UsuarioDto dto){
        dto = service.update(id, dto);
        return dto;
    }

    @DeleteMapping("id")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto apagar(@PathVariable Long id){
        service.delete(id);
        return null;

    }
}
