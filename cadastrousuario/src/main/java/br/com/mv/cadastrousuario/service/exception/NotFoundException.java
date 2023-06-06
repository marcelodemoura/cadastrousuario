package br.com.mv.cadastrousuario.service.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String dscription){
        super(dscription);
    }
}
