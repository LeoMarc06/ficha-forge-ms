
package br.com.fichaforge.apresentacao.dto;

import br.com.fichaforge.dominio.personagem.Personagem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record CriarPersonagemRequest(

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 10, max = 100, message = "O nome deve ter no entre 10 e 100 caracteres")
        String nome,

        @NotBlank(message = "A escolha de uma raça é obrigatória")
        String raca,

        Integer nivel,

        @NotNull
        @NotBlank
        @Size(min = 10, max = 500, message = "A descrição deve ter entre 500 caracteres")
        String historia
) {

    public Personagem toModel() {
        return new Personagem(
                nome,
                raca,
                nivel,
                historia
        );
    }
}
