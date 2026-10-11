
package br.com.fichaforge.apresentacao.dto;

import br.com.fichaforge.dominio.personagem.Personagem;

public record PersonagemResponse(
        Long id,
        String nome,
        String raca,
        Integer nivel,
        Integer experiencia,
        String historia,
        Integer pontosDeVidaMaximo,
        Integer pontosDeVidaAtual
) {

    public static PersonagemResponse from(Personagem personagem) {
        return new PersonagemResponse(
                personagem.getId(),
                personagem.getNome(),
                personagem.getRaca(),
                personagem.getNivel(),
                personagem.getExperiencia(),
                personagem.getHistoria(),
                personagem.getPontosDeVidaMaximo(),
                personagem.getPontosDeVidaAtual()
        );
    }
}
