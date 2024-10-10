package br.insper.banda.musica;

import br.insper.banda.banda.Banda;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Musica {
    @Id
    private String id;

    @NotEmpty
    private String nome;
    @Min(3)
    @Max(10)
    private Float duracao;
    private Integer reproducoes;
    private Integer anoLancamento;
    private Banda banda;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
