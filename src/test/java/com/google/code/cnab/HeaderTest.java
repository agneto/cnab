package com.google.code.cnab;

import org.junit.Assert;
import org.junit.Test;

import com.google.code.cnab.arquivoretorno.Header;

public class HeaderTest {

    private static final String LINHA = "02RETORNO01COBRANCA       1348870000000318    WMIX DISTRIBUIDORA LTDA       104C ECON FEDERAL 180113                                                                                                                                                                                                                                                                                                 01457000001";

    @Test
    public void codigoRegistro() {
        final Header header = new Header(LINHA);
        Assert.assertEquals("0", header.getCodigoRegistro());
        Assert.assertEquals("WMIX DISTRIBUIDORA LTDA", header.getNomeEmpresa());
        Assert.assertEquals("104", header.getCodigoBanco());
    }
}