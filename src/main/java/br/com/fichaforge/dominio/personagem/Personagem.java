package br.com.fichaforge.dominio.personagem;

public class Personagem {

    public Personagem(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
