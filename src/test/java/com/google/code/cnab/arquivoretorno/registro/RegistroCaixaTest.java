package com.google.code.cnab.arquivoretorno.registro;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistroCaixaTest {

    private static final String LINHA = "102123456780001231234560000000123                             82105708253      000                        1421010113                              010113000000000975000113776000000000000100663101210113              0000000000000000000000000000000000000000000000009750000000000000000000000000001210113                         0000000000000000000000000                                             000002";
    private final RegistroCaixa registro = new RegistroCaixa(RegistroCaixaTest.LINHA);

    @Test
    public void codigoRegistro() {
        Assert.assertEquals("1", this.registro.getCodigoRegistro());
    }

    @Test
    public void inscricaoDaEmpresa() {
        Assert.assertEquals("02", this.registro.getInscricaoDaEmpresa().getCodigo());
    }

    @Test
    public void numeroInscricao() {
        Assert.assertEquals("12345678000123", this.registro.getNumeroInscricao());
    }

    @Test
    public void codigoEmpresa() {
        Assert.assertEquals("1234560000000123", this.registro.getCodigoEmpresa());
    }

    @Test
    public void usoEmpresa() {
        Assert.assertEquals("                         ", this.registro.getUsoEmpresa());
    }

    @Test
    public void nossoNumero() {
        Assert.assertEquals("82105708253", this.registro.getNossoNumero());
    }

    @Test
    public void codigoRejeicao() {
        Assert.assertEquals("000", this.registro.getCodigoRejeicao());
    }

    @Test
    public void usoBanco() {
        Assert.assertEquals("                        ", this.registro.getUsoBanco());
    }

    @Test
    public void carteira() {
        Assert.assertEquals("14", this.registro.getCarteira());
    }

    @Test
    public void codigoOcorrencia() {
        Assert.assertEquals("21", this.registro.getCodigoOcorrencia());
    }

    @Test
    public void dataOcorrencia() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime(), this.registro.getDataOcorrencia());
    }

    @Test
    public void seuNumero() {
        Assert.assertEquals("          ", this.registro.getSeuNumero());
    }

    @Test
    public void vencimento() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime(), this.registro.getVencimento());
    }

    @Test
    public void valorTitulo() {
        Assert.assertEquals(new BigDecimal("97.5"), this.registro.getValorTitulo());
    }

    @Test
    public void codigoBanco() {
        Assert.assertEquals("001", this.registro.getCodigoBanco());
    }

    @Test
    public void agenciaCobradora() {
        Assert.assertEquals("13776", this.registro.getAgenciaCobradora());
    }

    @Test
    public void especie() {
        Assert.assertEquals("00", this.registro.getEspecie());
    }

    @Test
    public void tarifaCobranca() {
        Assert.assertEquals(BigDecimal.ONE, this.registro.getTarifaDeCobranca());
    }

    @Test
    public void tipoLiquidacao() {
        Assert.assertEquals(663, this.registro.getTipoLiquidacao());
    }

    @Test
    public void formaPagamento() {
        Assert.assertEquals(1, this.registro.getFormaPagamento().getCodigo());
    }

    @Test
    public void floatNegociado() {
        Assert.assertEquals(1, this.registro.getFloatNegociado());
    }

    @Test
    public void dataDebitoTarifa() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 21).getTime(), this.registro.getDataDebitoTarifa());
    }

    @Test
    public void valorIof() {
        Assert.assertEquals(BigDecimal.ZERO, this.registro.getIof());
    }

    @Test
    public void valorAbatimento() {
        Assert.assertEquals(BigDecimal.ZERO, this.registro.getValorAbatimento());
    }

    @Test
    public void descontos() {
        Assert.assertEquals(BigDecimal.ZERO, this.registro.getDescontos());
    }

    @Test
    public void valorPrincipal() {
        Assert.assertEquals(new BigDecimal("97.5"), this.registro.getValorPrincipal());
    }

    @Test
    public void valorJuros() {
        Assert.assertEquals(BigDecimal.ZERO, this.registro.getValorJuros());
    }

    @Test
    public void valorMulta() {
        Assert.assertEquals(BigDecimal.ZERO, this.registro.getValorMulta());
    }

    @Test
    public void codigoMoeda() {
        Assert.assertEquals(1, this.registro.getCodigoMoeda());
    }

    @Test
    public void dataCredito() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JANUARY, 21).getTime(), this.registro.getDataCredito());
    }

    @Test
    public void sequencial() {
        Assert.assertEquals(2, this.registro.getSequencial());
    }
}