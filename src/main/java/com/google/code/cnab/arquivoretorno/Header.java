package com.google.code.cnab.arquivoretorno;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public Integer getCodigoRetorno() {
        return Integer.valueOf(this.linha.substring(0, 1));
    }

    public String getLiteralRetorno() {
        return this.linha.substring(2, 9).trim();
    }

    public String getCodigoServico() {
        return this.linha.substring(9, 11).trim();
    }

    public String LiteralServico() {
        return this.linha.substring(11, 26).trim();
    }

    public String getCodigoEmpresa() {
        return this.linha.substring(26, 42).trim();
    }

    public String getNomeEmpresa() {
        return this.linha.substring(46, 76).trim();
    }

    public String getCodigoBanco() {
        return this.linha.substring(76, 79);
    }

    public String getNomeBanco() {
        return this.linha.substring(79, 94);
    }

    public Calendar getDataGravacao() {
        final Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("ddMMyy").parse(this.linha.substring(94, 100)));
            return calendar;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return Calendar.getInstance();
    }

    public String getMensagem() {
        return this.linha.substring(100, 158).trim();
    }

    public Integer getNumeroSequencialA() {
        return Integer.parseInt(this.linha.substring(389, 394));
    }

    public Integer getNumeroSequencialB() {
        return Integer.parseInt(this.linha.substring(389, 394));
    }
}
