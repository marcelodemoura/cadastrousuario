package br.com.mv.cadastrousuario.dto;

import javax.validation.constraints.Email;

import br.com.mv.cadastrousuario.entity.Usuario;
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

    public UsuarioDto(Usuario entity){
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
//        this.endereco = entity.getEndereco();
    }



}
