package com.devmonsters.cnab.arquivoretorno.header;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class HeaderCaixaTest {
    
    private static final String LINHA_VALIDA = "02RETORNO01COBRANCA       1234560000000788    ABCD DISTRIBUIDORA LTDA       104C ECON FEDERAL 010113                                                                                                                                                                                                                                                                                                 01457000001";
    private static final String LINHA_INVALIDA = "12RETORNO01COBRANCA       1234560000000788    ABCD DISTRIBUIDORA LTDA       104C ECON FEDERAL 010113                                                                                                                                                                                                                                                                                                 01457000001";
    
    @Test(expected = IllegalArgumentException.class)
    public void linhaInvalidaFalhaNaConstrucao() {
        new HeaderCaixa(HeaderCaixaTest.LINHA_INVALIDA);
    }
    
    @Test
    public void objetoNaoPodeModificarLinha() {
        Assert.assertEquals(LINHA_VALIDA, new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getLinha());
    }
    
    @Test
    public void codigoRegistro() {
        Assert.assertEquals("0", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getCodigoRegistro());
    }
    
    @Test
    public void codigoRetorno() {
        Assert.assertEquals(2, new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getCodigoRetorno());
    }
    
    @Test
    public void literalRetorno() {
        Assert.assertEquals("RETORNO", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getLiteralRetorno());
    }
    
    @Test
    public void codigoServico() {
        Assert.assertEquals("01", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getCodigoServico());
    }
    
    @Test
    public void literalServico() {
        Assert.assertEquals("COBRANCA", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getLiteralServico());
    }
    
    @Test
    public void codigoEmpresa() {
        Assert.assertEquals("1234560000000788", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getCodigoEmpresa());
    }
    
    @Test
    public void nomeEmpresa() {
        Assert.assertEquals("ABCD DISTRIBUIDORA LTDA", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getNomeEmpresa());
    }
    
    @Test
    public void codigoBanco() {
        Assert.assertEquals("104", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getCodigoBanco());
    }
    
    @Test
    public void nomeBanco() {
        Assert.assertEquals("C ECON FEDERAL", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getNomeBanco());
    }
    
    @Test
    public void dataGravacao() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime(), new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getDataGravacao());
    }
    
    @Test
    public void mensagem() {
        Assert.assertEquals("                                                          ", new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getMensagem());
    }
    
    @Test
    public void sequencialA() {
        Assert.assertEquals(1457, new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getNumeroSequencialA());
    }
    
    @Test
    public void sequencial() {
        Assert.assertEquals(1, new HeaderCaixa(HeaderCaixaTest.LINHA_VALIDA).getNumeroSequencial());
    }
}