package br.com.mv.cadastrousuario.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;
   

    @Column(length=11, nullable = false)
    @CPF
    private String cpf;

    private String endereco;

    @Column (name = "email", length = 40, nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String telefone;

    public void setDataCriacao(LocalDateTime now) {
    }

    

}
