package br.com.mv.cadastrousuario.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private String nome;
    @CPF
    private String cpf;
    @Email
    private String email;
    private String telefone;
    private String endereco;

}
