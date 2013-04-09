package com.devmonsters.cnab.arquivoretorno.registro;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class RegistroCaixaTest {
    
    private static final String LINHA_VALIDA = "102123456780001231234560000000123                             82105708253      000                        1421010113                              010113000000000975000113776000000000000100663101210113              0000000000000000000000000000000000000000000000009750000000000000000000000000001210113                         0000000000000000000000000                                             000002";
    private static final String LINHA_INVALIDA = "902123456780001231234560000000123                             82105708253      000                        1421010113                              010113000000000975000113776000000000000100663101210113              0000000000000000000000000000000000000000000000009750000000000000000000000000001210113                         0000000000000000000000000                                             000002";
    
    @Test(expected = IllegalArgumentException.class)
    public void linhaInvalidaFalhaNaConstrucao() {
        new RegistroCaixa(RegistroCaixaTest.LINHA_INVALIDA);
    }
    
    @Test
    public void objetoNaoPodeModificarLinha() {
        Assert.assertEquals(LINHA_VALIDA, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getLinha());
    }
    
    @Test
    public void codigoRegistro() {
        Assert.assertEquals("1", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getCodigoRegistro());
    }
    
    @Test
    public void inscricaoDaEmpresa() {
        Assert.assertEquals("02", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getInscricaoDaEmpresa().getCodigo());
    }
    
    @Test
    public void numeroInscricao() {
        Assert.assertEquals("12345678000123", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getNumeroInscricao());
    }
    
    @Test
    public void codigoEmpresa() {
        Assert.assertEquals("1234560000000123", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getCodigoEmpresa());
    }
    
    @Test
    public void usoEmpresa() {
        Assert.assertEquals("                         ", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getUsoEmpresa());
    }
    
    @Test
    public void nossoNumero() {
        Assert.assertEquals("82105708253", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getNossoNumero());
    }
    
    @Test
    public void codigoRejeicao() {
        Assert.assertEquals("000", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getCodigoRejeicao());
    }
    
    @Test
    public void usoBanco() {
        Assert.assertEquals("                        ", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getUsoBanco());
    }
    
    @Test
    public void carteira() {
        Assert.assertEquals("14", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getCarteira());
    }
    
    @Test
    public void codigoOcorrencia() {
        Assert.assertEquals("21", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getCodigoOcorrencia());
    }
    
    @Test
    public void dataOcorrencia() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime(), new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getDataOcorrencia());
    }
    
    @Test
    public void seuNumero() {
        Assert.assertEquals("          ", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getSeuNumero());
    }
    
    @Test
    public void vencimento() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime(), new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getVencimento());
    }
    
    @Test
    public void valorTitulo() {
        Assert.assertEquals(new BigDecimal("97.5"), new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getValorTitulo());
    }
    
    @Test
    public void codigoBanco() {
        Assert.assertEquals("001", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getCodigoBanco());
    }
    
    @Test
    public void agenciaCobradora() {
        Assert.assertEquals("13776", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getAgenciaCobradora());
    }
    
    @Test
    public void especie() {
        Assert.assertEquals("00", new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getEspecie());
    }
    
    @Test
    public void tarifaCobranca() {
        Assert.assertEquals(BigDecimal.ONE, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getTarifaDeCobranca());
    }
    
    @Test
    public void tipoLiquidacao() {
        Assert.assertEquals(663, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getTipoLiquidacao());
    }
    
    @Test
    public void formaPagamento() {
        Assert.assertEquals(1, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getFormaPagamento().getCodigo());
    }
    
    @Test
    public void floatNegociado() {
        Assert.assertEquals(1, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getFloatNegociado());
    }
    
    @Test
    public void dataDebitoTarifa() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 21).getTime(), new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getDataDebitoTarifa());
    }
    
    @Test
    public void valorIof() {
        Assert.assertEquals(BigDecimal.ZERO, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getIof());
    }
    
    @Test
    public void valorAbatimento() {
        Assert.assertEquals(BigDecimal.ZERO, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getValorAbatimento());
    }
    
    @Test
    public void descontos() {
        Assert.assertEquals(BigDecimal.ZERO, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getDescontos());
    }
    
    @Test
    public void valorPrincipal() {
        Assert.assertEquals(new BigDecimal("97.5"), new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getValorPrincipal());
    }
    
    @Test
    public void valorJuros() {
        Assert.assertEquals(BigDecimal.ZERO, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getValorJuros());
    }
    
    @Test
    public void valorMulta() {
        Assert.assertEquals(BigDecimal.ZERO, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getValorMulta());
    }
    
    @Test
    public void codigoMoeda() {
        Assert.assertEquals(1, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getCodigoMoeda());
    }
    
    @Test
    public void dataCredito() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 21).getTime(), new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getDataCredito());
    }
    
    @Test
    public void sequencial() {
        Assert.assertEquals(2, new RegistroCaixa(RegistroCaixaTest.LINHA_VALIDA).getSequencial());
    }
}