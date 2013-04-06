package com.devmonsters.cnab.arquivoretorno.trailer;

public class TrailerCaixa extends Trailer {

    public TrailerCaixa(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException("Trailer come\u00e7a com 9");
        }
        this.linha = linha;
    }
}