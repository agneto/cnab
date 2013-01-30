package com.google.code.cnab.arquivoretorno;

public class Trailer {

    private final String linha;

    public Trailer(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException("Trailer começa com 9");
        }
        this.linha = linha;
    }

    public String getCodigoRegistro() {
        return "9";
    }

    public String getCodigoRetorno() {
        return this.linha.substring(1, 2).trim();
    }

    public String getCodigoDoServico() {
        return this.linha.substring(2, 4).trim();
    }

    public String getCodigoDoBanco() {
        return this.linha.substring(4, 7).trim();
    }

    public Integer getSequencial() {
        return Integer.parseInt(this.linha.substring(394, 400).trim());
    }
}