package br.com.mv.cadastrousuario.controller.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class StandardError extends RuntimeException {

    private Instant timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public StandardError(){

    }

}
