package br.com.mv.cadastrousuario.service.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String description){
        super(description);
    }
}
