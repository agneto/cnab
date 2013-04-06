package com.devmonsters.cnab.arquivoretorno.header;

import java.util.Date;
import java.util.GregorianCalendar;

public class HeaderCaixa extends Header {

    public HeaderCaixa(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException("Header come\u00e7aa com 0");
        }
        this.linha = linha;
    }

    @Override
    public String getLiteralServico() {
        return this.linha.substring(11, 26).trim();
    }

    @Override
    public String getCodigoEmpresa() {
        return this.linha.substring(26, 42).trim();
    }

    @Override
    public String getNomeEmpresa() {
        return this.linha.substring(46, 76).trim();
    }

    @Override
    public String getCodigoBanco() {
        return this.linha.substring(76, 79).trim();
    }

    @Override
    public String getNomeBanco() {
        return this.linha.substring(79, 94).trim();
    }

    @Override
    public Date getDataGravacao() {
        final String dataGravacao = this.linha.substring(94, 100).trim();
        if (!dataGravacao.equals("000000")) {
            return new GregorianCalendar(2000 + Integer.parseInt(dataGravacao.substring(4)), Integer.parseInt(dataGravacao.substring(2, 4)) - 1, Integer.parseInt(dataGravacao.substring(0, 2))).getTime();
        } else {
            return null;
        }
    }

    public String getMensagem() {
        return this.linha.substring(100, 158);
    }

    public int getNumeroSequencialA() {
        return Integer.parseInt(this.linha.substring(389, 394).trim());
    }

    @Override
    public int getNumeroSequencial() {
        return Integer.parseInt(this.linha.substring(394, 400).trim());
    }
}