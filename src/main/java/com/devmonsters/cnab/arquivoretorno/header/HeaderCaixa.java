package com.devmonsters.cnab.arquivoretorno.header;

import java.util.Date;
import java.util.GregorianCalendar;

public class HeaderCaixa extends Header {
    
    public HeaderCaixa(final String linha) {
        super(linha);
    }
    
    @Override
    public String getLiteralServico() {
        return super.getLinha().substring(11, 26).trim();
    }
    
    @Override
    public String getCodigoEmpresa() {
        return super.getLinha().substring(26, 42).trim();
    }
    
    @Override
    public String getNomeEmpresa() {
        return super.getLinha().substring(46, 76).trim();
    }
    
    @Override
    public String getCodigoBanco() {
        return super.getLinha().substring(76, 79).trim();
    }
    
    @Override
    public String getNomeBanco() {
        return super.getLinha().substring(79, 94).trim();
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
    
    public String getMensagem() {
        return super.getLinha().substring(100, 158);
    }
    
    public int getNumeroSequencialA() {
        return Integer.parseInt(super.getLinha().substring(389, 394).trim());
    }
    
    @Override
    public int getNumeroSequencial() {
        return Integer.parseInt(super.getLinha().substring(394, 400).trim());
    }
}