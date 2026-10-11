package br.com.fichaforge.dominio.personagem;

public class Personagem {

    public Personagem(String nome, String raca, Integer nivel, String historia) {
        this.nome = nome;
        this.raca = raca;
        this.nivel = nivel;
        this.historia = historia;
    }

    private Long id;

    private String nome;

    private String raca;

    private Integer nivel;

    private Integer experiencia = 0;

    private String historia;

    private Integer pontosDeVidaMaximo;

    private Integer pontosDeVidaAtual;

    public void renomeia(String novoNome) {
        this.nome = novoNome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPontosDeVidaMaximo() {
        if(raca.equalsIgnoreCase("humano")) {
            this.pontosDeVidaMaximo = 10;
            this.pontosDeVidaAtual = 10;
        } else {
            this.pontosDeVidaMaximo = 20;
            this.pontosDeVidaAtual = 10;
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public Integer getNivel() {
        return nivel;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public String getHistoria() {
        return historia;
    }

    public Integer getPontosDeVidaMaximo() {
        return pontosDeVidaMaximo;
    }

    public Integer getPontosDeVidaAtual() {
        return pontosDeVidaAtual;
    }
}
