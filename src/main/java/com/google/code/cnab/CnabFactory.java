package com.google.code.cnab;

import com.google.code.cnab.arquivoretorno.header.Header;
import com.google.code.cnab.arquivoretorno.header.HeaderBradesco;
import com.google.code.cnab.arquivoretorno.header.HeaderCaixa;
import com.google.code.cnab.arquivoretorno.registro.RegistroBradesco;
import com.google.code.cnab.arquivoretorno.registro.RegistroCaixa;
import com.google.code.cnab.arquivoretorno.trailer.Trailer;
import com.google.code.cnab.arquivoretorno.trailer.TrailerBradesco;
import com.google.code.cnab.arquivoretorno.trailer.TrailerCaixa;
import com.google.code.cnab.bancos.Bancos;

public abstract class CnabFactory {
    
    public static Header getInstanceHeader(final Bancos banco, final String linha) {
        switch (banco) {
            case CEF:
                return new HeaderCaixa(linha);
            case BRADESCO:
                return new HeaderBradesco(linha);
            default:
                return null;
        }
    }
    
    public static Registro getInstanceRegistro(final Bancos banco, final String linha) {
        switch (banco) {
            case CEF:
                return new RegistroCaixa(linha);
            case BRADESCO:
                return new RegistroBradesco(linha);
            default:
                return null;
        }
    }
    
    public static Trailer getInstanceTrailer(final Bancos banco, final String linha) {
        switch (banco) {
            case CEF:
                return new TrailerCaixa(linha);
            case BRADESCO:
                return new TrailerBradesco(linha);
            default:
                return null;
        }
    }
}