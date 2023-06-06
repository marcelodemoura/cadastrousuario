package br.com.mv.cadastrousuario.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAbstrato {

    @JsonFormat(pattern = "dd/mm/yyyy")
    LocalDateTime dataCriacao;
    @JsonFormat(pattern = "dd/mm/yyyy")
    LocalDateTime dataAtualizacao;

}
