package com.google.code.cnab.arquivoretorno.header;

import java.util.Date;
import java.util.GregorianCalendar;

public class HeaderBradesco extends Header {
    public HeaderBradesco(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException("Header come\u00e7aa com 0");
        }
        this.linha = linha;
    }

    @Override
    public String getLiteralServico() {
        return this.linha.substring(11, 26);
    }

    @Override
    public String getCodigoEmpresa() {
        return this.linha.substring(26, 46);
    }

    @Override
    public String getNomeEmpresa() {
        return this.linha.substring(46, 76);
    }

    @Override
    public String getCodigoBanco() {
        return this.linha.substring(76, 79);
    }

    @Override
    public String getNomeBanco() {
        return this.linha.substring(79, 94);
    }

    @Override
    public Date getDataGravacao() {
        return "000000".equals(this.linha.substring(94, 100)) ? null : new GregorianCalendar(this.getDataOcorrenciaAno(), this.getDataOcorrenciaMes() - 1, this.getDataOcorrenciaDia()).getTime();
    }

    private int getDataOcorrenciaAno() {
        return 2000 + Integer.parseInt(this.linha.substring(98, 100));
    }

    private int getDataOcorrenciaMes() {
        return Integer.parseInt(this.linha.substring(96, 98));
    }

    private int getDataOcorrenciaDia() {
        return Integer.parseInt(this.linha.substring(94, 96));
    }

    public String getZeros() {
        return this.linha.substring(100, 108);
    }

    public String getNumeroAvisoBancario() {
        return this.linha.substring(108, 113);
    }

    public String getBrancos1() {
        return this.linha.substring(113, 379);
    }

    public Date getDataCredito() {
        return "000000".equals(this.linha.substring(379, 385)) ? null : new GregorianCalendar(this.getDataCreditoAno(), this.getDataCreditoMes() - 1, this.getDataCreditoDia()).getTime();
    }

    private int getDataCreditoAno() {
        return 2000 + Integer.parseInt(this.linha.substring(383, 385));
    }

    private int getDataCreditoMes() {
        return Integer.parseInt(this.linha.substring(381, 383));
    }

    private int getDataCreditoDia() {
        return Integer.parseInt(this.linha.substring(379, 381));
    }

    public String getBrancos2() {
        return this.linha.substring(385, 394);
    }

    @Override
    public int getNumeroSequencial() {
        return Integer.parseInt(this.linha.substring(394, 400));
    }
}