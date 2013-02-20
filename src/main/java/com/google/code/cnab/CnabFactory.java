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
        Header header = null;
        if (banco.equals(Bancos.CEF)) {
            header = new HeaderCaixa(linha);
        } else if (banco.equals(Bancos.BRADESCO)) {
            header = new HeaderBradesco(linha);
        }
        return header;
    }

    public static Registro getInstanceRegistro(final Bancos banco, final String linha) {
        Registro registro = null;
        if (banco.equals(Bancos.CEF)) {
            registro = new RegistroCaixa(linha);
        } else if (banco.equals(Bancos.BRADESCO)) {
            registro = new RegistroBradesco(linha);
        }
        return registro;
    }

    public static Trailer getInstanceTrailer(final Bancos banco, final String linha) {
        Trailer trailer = null;
        if (banco.equals(Bancos.CEF)) {
            trailer = new TrailerCaixa(linha);
        } else if (banco.equals(Bancos.BRADESCO)) {
            trailer = new TrailerBradesco(linha);
        }
        return trailer;
    }
}