package com.google.code.cnab.arquivoretorno.trailer;

import org.junit.Assert;
import org.junit.Test;

import com.google.code.cnab.arquivoretorno.trailer.Trailer;

public class TrailerTest {

    private static final String LINHA = "9201104                                                                                                                                                                                                                                                                                                                                                                                                   000928";
    private final Trailer trailer = new Trailer(LINHA);

    @Test
    public void codigoRegistro() {
        Assert.assertEquals("9", this.trailer.getCodigoRegistro());
    }

    @Test
    public void codigoRetorno() {
        Assert.assertEquals("2", this.trailer.getCodigoRetorno());
    }

    @Test
    public void codigoDoServico() {
        Assert.assertEquals("01", this.trailer.getCodigoDoServico());
    }

    @Test
    public void codigoDoBanco() {
        Assert.assertEquals("104", this.trailer.getCodigoDoBanco());
    }

    @Test
    public void sequencial() {
        Assert.assertEquals(928, this.trailer.getSequencial());
    }
}