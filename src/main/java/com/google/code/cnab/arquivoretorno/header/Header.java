package com.google.code.cnab.arquivoretorno.header;

import java.util.Date;
import java.util.GregorianCalendar;

public class Header {
    private final String linha;

    public Header(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException("Header começa com 0");
        }
        this.linha = linha;
    }

    public String getCodigoRegistro() {
        return "0";
    }

    public int getCodigoRetorno() {
        return Integer.valueOf(this.linha.substring(1, 2));
    }

    public String getLiteralRetorno() {
        return this.linha.substring(2, 9).trim();
    }

    public String getCodigoServico() {
        return this.linha.substring(9, 11).trim();
    }

    public String getLiteralServico() {
        return this.linha.substring(11, 26).trim();
    }

    public String getCodigoEmpresa() {
        return this.linha.substring(26, 42).trim();
    }

    public String getNomeEmpresa() {
        return this.linha.substring(46, 76).trim();
    }

    public String getCodigoBanco() {
        return this.linha.substring(76, 79).trim();
    }

    public String getNomeBanco() {
        return this.linha.substring(79, 94).trim();
    }

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

    public int getNumeroSequencialB() {
        return Integer.parseInt(this.linha.substring(394, 400).trim());
    }
}
