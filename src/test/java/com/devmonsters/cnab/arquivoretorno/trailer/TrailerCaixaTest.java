package com.devmonsters.cnab.arquivoretorno.trailer;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.cnab.arquivoretorno.registro.RegistroCaixa;

public class TrailerCaixaTest {
    
    private static final String LINHA_VALIDA = "9201104                                                                                                                                                                                                                                                                                                                                                                                                   000928";
    private static final String LINHA_INVALIDA = "6201104                                                                                                                                                                                                                                                                                                                                                                                                   000928";
    
    @Test(expected = IllegalArgumentException.class)
    public void linhaInvalidaFalhaNaConstrucao() {
        new RegistroCaixa(TrailerCaixaTest.LINHA_INVALIDA);
    }
    
    @Test
    public void codigoRegistro() {
        Assert.assertEquals("9", new TrailerCaixa(TrailerCaixaTest.LINHA_VALIDA).getCodigoRegistro());
    }
    
    @Test
    public void codigoRetorno() {
        Assert.assertEquals("2", new TrailerCaixa(TrailerCaixaTest.LINHA_VALIDA).getCodigoRetorno());
    }
    
    @Test
    public void codigoDoServico() {
        Assert.assertEquals("01", new TrailerCaixa(TrailerCaixaTest.LINHA_VALIDA).getCodigoDoServico());
    }
    
    @Test
    public void codigoDoBanco() {
        Assert.assertEquals("104", new TrailerCaixa(TrailerCaixaTest.LINHA_VALIDA).getCodigoDoBanco());
    }
    
    @Test
    public void sequencial() {
        Assert.assertEquals(928, new TrailerCaixa(TrailerCaixaTest.LINHA_VALIDA).getSequencial());
    }
}