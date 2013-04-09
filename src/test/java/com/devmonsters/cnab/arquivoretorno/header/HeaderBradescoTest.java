package com.devmonsters.cnab.arquivoretorno.header;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class HeaderBradescoTest {
    
    private static final String LINHA_VALIDA = "02RETORNO01COBRANCA       00000000000001111333ABCD DISTRIBUIDORA LTDA       237BRADESCO       1502130160000000805                                                                                                                                                                                                                                                                          180213         000001";
    private static final String LINHA_INVALIDA = "12RETORNO01COBRANCA       00000000000001111333ABCD DISTRIBUIDORA LTDA       237BRADESCO       1502130160000000805                                                                                                                                                                                                                                                                          180213         000001";
    
    @Test(expected = IllegalArgumentException.class)
    public void linhaInvalidaFalhaNaConstrucao() {
        new HeaderBradesco(HeaderBradescoTest.LINHA_INVALIDA);
    }
    
    @Test
    public void objetoNaoPodeModificarLinha() {
        Assert.assertEquals(LINHA_VALIDA, new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getLinha());
    }
    
    @Test
    public void codigoRegistro() {
        Assert.assertEquals("0", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getCodigoRegistro());
    }
    
    @Test
    public void codigoRetorno() {
        Assert.assertEquals(2, new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getCodigoRetorno());
    }
    
    @Test
    public void literalRetorno() {
        Assert.assertEquals("RETORNO", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getLiteralRetorno());
    }
    
    @Test
    public void codigoServico() {
        Assert.assertEquals("01", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getCodigoServico());
    }
    
    @Test
    public void literalServico() {
        Assert.assertEquals("COBRANCA       ", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getLiteralServico());
    }
    
    @Test
    public void codigoEmpresa() {
        Assert.assertEquals("00000000000001111333", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getCodigoEmpresa());
    }
    
    @Test
    public void nomeEmpresa() {
        Assert.assertEquals("ABCD DISTRIBUIDORA LTDA       ", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getNomeEmpresa());
    }
    
    @Test
    public void codigoBanco() {
        Assert.assertEquals("237", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getCodigoBanco());
    }
    
    @Test
    public void nomeBanco() {
        Assert.assertEquals("BRADESCO       ", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getNomeBanco());
    }
    
    @Test
    public void dataGravacao() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 15).getTime(), new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getDataGravacao());
    }
    
    @Test
    public void zeros() {
        Assert.assertEquals("01600000", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getZeros());
    }
    
    @Test
    public void numeroAvisoBancario() {
        Assert.assertEquals("00805", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getNumeroAvisoBancario());
    }
    
    @Test
    public void brancos1() {
        Assert.assertEquals("                                                                                                                                                                                                                                                                          ", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getBrancos1());
    }
    
    @Test
    public void dataCredito() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 18).getTime(), new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getDataCredito());
    }
    
    @Test
    public void brancos2() {
        Assert.assertEquals("         ", new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getBrancos2());
    }
    
    @Test
    public void sequencial() {
        Assert.assertEquals(1, new HeaderBradesco(HeaderBradescoTest.LINHA_VALIDA).getNumeroSequencial());
    }
}