package br.insper.banda;

public class Musica {
    private Integer id;
    private String nome;
    private Float duracao;
    private Integer reproducoes;
    private Integer anoLancamento;
    private Banda banda;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getDuracao() {
        return duracao;
    }

    public void setDuracao(Float duracao) {
        this.duracao = duracao;
    }

    public Integer getReproducoes() {
        return reproducoes;
    }

    public void setReproducoes(Integer reproducoes) {
        this.reproducoes = reproducoes;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
