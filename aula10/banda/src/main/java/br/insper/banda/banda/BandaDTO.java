package br.insper.banda.banda;

record CadastrarBandaDTO
        (String nome, String pais, Integer anoFormacao) {
}

record RetornarBandaDTO(String id, String nome, String pais) {}

record EditarBandaDTO(String nome, String pais) {}
