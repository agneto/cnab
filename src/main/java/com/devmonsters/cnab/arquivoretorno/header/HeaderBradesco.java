package com.devmonsters.cnab.arquivoretorno.header;

import java.util.Date;
import java.util.GregorianCalendar;

public class HeaderBradesco extends Header {
    
    public HeaderBradesco(final String linha) {
        super(linha);
    }
    
    @Override
    public String getLiteralServico() {
        return super.getLinha().substring(11, 26);
    }
    
    @Override
    public String getCodigoEmpresa() {
        return super.getLinha().substring(26, 46);
    }
    
    @Override
    public String getNomeEmpresa() {
        return super.getLinha().substring(46, 76);
    }
    
    @Override
    public String getCodigoBanco() {
        return super.getLinha().substring(76, 79);
    }
    
    @Override
    public String getNomeBanco() {
        return super.getLinha().substring(79, 94);
    }
    
    @Override
    public Date getDataGravacao() {
        final String dataGravacao = super.getLinha().substring(94, 100).trim();
        if (!"000000".equals(dataGravacao)) {
            final int ano = 2000 + Integer.parseInt(dataGravacao.substring(4));
            final int mes = Integer.parseInt(dataGravacao.substring(2, 4)) - 1;
            final int dia = Integer.parseInt(dataGravacao.substring(0, 2));
            return new GregorianCalendar(ano, mes, dia).getTime();
        }
        return null;
    }
    
    public String getZeros() {
        return super.getLinha().substring(100, 108);
    }
    
    public String getNumeroAvisoBancario() {
        return super.getLinha().substring(108, 113);
    }
    
    public String getBrancos1() {
        return super.getLinha().substring(113, 379);
    }
    
    public Date getDataCredito() {
        final String dataCredito = super.getLinha().substring(379, 385).trim();
        if (!"000000".equals(dataCredito)) {
            final int ano = 2000 + Integer.parseInt(dataCredito.substring(4));
            final int mes = Integer.parseInt(dataCredito.substring(2, 4)) - 1;
            final int dia = Integer.parseInt(dataCredito.substring(0, 2));
            return new GregorianCalendar(ano, mes, dia).getTime();
        }
        return null;
    }
    
    public String getBrancos2() {
        return super.getLinha().substring(385, 394);
    }
    
    @Override
    public int getNumeroSequencial() {
        return Integer.parseInt(super.getLinha().substring(394, 400));
    }
}