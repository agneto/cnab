package com.google.code.cnab;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import com.google.code.cnab.arquivoretorno.Registro;

public class RegistroTest {

    private static final String LINHA = "102039186090001234567870000000318                             82105708253      000                        1421010113                              010113000000000975000113776000000000000100663101210113              0000000000000000000000000000000000000000000000009750000000000000000000000000001210113                         0000000000000000000000000                                             000002";
    private final Registro registro = new Registro(LINHA);

    @Test
    public void codigoRegistro() {
        Assert.assertEquals("1", this.registro.getCodigoRegistro());
    }

    @Test
    public void inscricaoDaEmpresa() {
        Assert.assertEquals("02", this.registro.getInscricaoDaEmpresa().getValue());
    }

    @Test
    public void numeroInscricao() {
        Assert.assertEquals("03918609000123", this.registro.getNumeroInscricao());
    }

    @Test
    public void codigoEmpresa() {
        Assert.assertEquals("4567870000000318", this.registro.getCodigoEmpresa());
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
        Assert.assertEquals("010113", new SimpleDateFormat("ddMMyy").format(this.registro.getDataOcorrencia().getTime()));
    }

    @Test
    public void seuNumero() {
        Assert.assertEquals("          ", this.registro.getSeuNumero());
    }

    @Test
    public void vencimento() {
        Assert.assertEquals("010113", new SimpleDateFormat("ddMMyy").format(this.registro.getVencimento().getTime()));
    }

    @Test
    public void valorTitulo() {
        Assert.assertEquals(new BigDecimal("0000000009750"), this.registro.getValorTitulo());
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
        Assert.assertEquals(new BigDecimal("0000000000100"), this.registro.getTarifaDeCobranca());
    }

    @Test
    public void tipoLiquidacao() {
        Assert.assertEquals(new Integer("663"), this.registro.getTipoLiquidacao());
    }

    @Test
    public void formaPagamento() {
        Assert.assertEquals(new Integer("1"), new Integer(this.registro.getFormaPagamento().getValue()));
    }

    @Test
    public void floatNegociado() {
        Assert.assertEquals(new Integer("01"), this.registro.getFloatNegociado());
    }

    @Test
    public void dataDebitoTarifa() {
        Assert.assertEquals("210113", new SimpleDateFormat("ddMMyy").format(this.registro.getDataDebitoTarifa().getTime()));
    }

    @Test
    public void valorIof() {
        Assert.assertEquals(new BigDecimal("0000000000000"), this.registro.getIof());
    }

    @Test
    public void valorAbatimento() {
        Assert.assertEquals(new BigDecimal("0000000000000"), this.registro.getValorAbatimento());
    }

    @Test
    public void descontos() {
        Assert.assertEquals(new BigDecimal("0000000000000"), this.registro.getDescontos());
    }

    @Test
    public void valorPrincipal() {
        Assert.assertEquals(new BigDecimal("0000000009750"), this.registro.getValorPrincipal());
    }

    @Test
    public void valorJuros() {
        Assert.assertEquals(new BigDecimal("0000000000000"), this.registro.getValorJuros());
    }

    @Test
    public void valorMulta() {
        Assert.assertEquals(new BigDecimal("0000000000000"), this.registro.getValorMulta());
    }

    @Test
    public void codigoMoeda() {
        Assert.assertEquals(new Integer("1"), this.registro.getCodigoMoeda());
    }

    @Test
    public void dataCredito() {
        Assert.assertEquals("210113", new SimpleDateFormat("ddMMyy").format(this.registro.getDataCredito().getTime()));
    }

    @Test
    public void sequencial() {
        Assert.assertEquals(new Integer("000002"), this.registro.getSequencial());
    }

}