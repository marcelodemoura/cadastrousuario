package br.com.mv.cadastrousuario.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuario")
public class Usuario extends UsuarioAbstrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, name = "Nome")
    private String nome;
    @Column(length = 11, nullable = false)
    @CPF
    private String cpf;
    @Column(name = "Email", length = 40)
    private String email;
    @Column(name = "Telefone", nullable = false, length = 20)
    private String telefone;


}
