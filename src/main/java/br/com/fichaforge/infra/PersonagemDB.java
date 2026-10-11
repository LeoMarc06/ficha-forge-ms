package br.com.fichaforge.infra;

import br.com.fichaforge.dominio.personagem.Personagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonagemDB {

    //todo ver se é melhor usar um list ou um set
    private List<Personagem> personagemDB = new ArrayList<>();


    public Personagem cria(Personagem personagem) {

        return null;
    }

    public List<Personagem> busca() {

        return Collections.emptyList();
    }


    public void delete(Long id) {
        //todo BUSCA O PERSONAGEM NA LISTA, PELO ID INFORMADO E REMOVE ELE DA LISTA


    }


}
