package br.com.fichaforge.servico;


import br.com.fichaforge.apresentacao.exception.RecursoNaoEncontradoException;
import br.com.fichaforge.dominio.personagem.Personagem;

public class PersonagemServico {

    public Personagem cria(Personagem personagem) {

        var ultimoIdValido =  1L; //TODO quando estiver salvando o personagem em banco ou lista,
        //pegar o ultimo ID cadastrado e incrementar 1; @Marcelo
        personagem.setId(ultimoIdValido);
        personagem.setPontosDeVidaMaximo();

        //TODO SALVAR O USUARIO NA LISTA DE PERSONAGENS.

        return personagem;
    }

    public Personagem busca(Long id) {
        //todo vou no banco e busco o personagem com o ID informado

        if(id == 100)
            throw new RecursoNaoEncontradoException("Esse personagem com o ID:" + id + " não foi encontrado");

        return new Personagem("Jonas", "Anao", 1, "alksdjfakljdfalkdjf");
    }

}
