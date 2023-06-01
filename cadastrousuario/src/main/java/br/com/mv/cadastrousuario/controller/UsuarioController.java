package br.com.mv.cadastrousuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.cadastrousuario.dto.UsuarioDto;
import br.com.mv.cadastrousuario.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    
    private UsuarioServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto salvar(@RequestBody UsuarioDto dto){
        return service.save(dto);
    }
}
