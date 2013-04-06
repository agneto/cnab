package com.devmonsters.cnab.arquivoretorno.registro;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistroBradescoTest {
    private static final String LINHA = "10201111222200002000000888886000005045554444-1                000000000008064994150000000000000000000000000906150213002058663500000000000203188604060213000000007505023702069  000000000000000000000000000000000000000000000000000000000000000000000000000000000000007649000000000014400000000000000   180213074          00000000000000                                                                  000002";
    private final RegistroBradesco registro = new RegistroBradesco(LINHA);

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
        Assert.assertEquals("01111222200002", this.registro.getNumeroInscricao());
    }

    @Test
    public void zeros1() {
        Assert.assertEquals("000", this.registro.getZeros1());
    }

    @Test
    public void identificaoEmpresaCedente() {
        Assert.assertEquals("00088888600000504", this.registro.getIdentificacaoEmpresaCedente());
    }

    @Test
    public void usoEmpresa() {
        Assert.assertEquals("5554444-1                ", this.registro.getUsoEmpresa());
    }

    @Test
    public void zeros2() {
        Assert.assertEquals("00000000", this.registro.getZeros2());
    }

    @Test
    public void nossoNumero() {
        Assert.assertEquals("000806499415", this.registro.getNossoNumero());
    }

    @Test
    public void usoBanco1() {
        Assert.assertEquals("0000000000", this.registro.getUsoBanco1());
    }

    @Test
    public void usoBanco2() {
        Assert.assertEquals("000000000000", this.registro.getUsoBanco2());
    }

    @Test
    public void indicadorRateio() {
        Assert.assertEquals("0", this.registro.getIndicadorRateio());
    }

    @Test
    public void zeros3() {
        Assert.assertEquals("00", this.registro.getZeros3());
    }

    @Test
    public void carteira() {
        Assert.assertEquals("9", this.registro.getCarteira());
    }

    @Test
    public void codigoOcorrencia() {
        Assert.assertEquals("06", this.registro.getCodigoOcorrencia());
    }

    @Test
    public void dataOcorrencia() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 15).getTime(), this.registro.getDataOcorrencia());
    }

    @Test
    public void seuNumero() {
        Assert.assertEquals("0020586635", this.registro.getSeuNumero());
    }

    @Test
    public void identificacaoTituloNoBanco() {
        Assert.assertEquals("00000000000203188604", this.registro.getIdentificacaoTituloNoBanco());
    }

    @Test
    public void vencimento() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 6).getTime(), this.registro.getVencimento());
    }

    @Test
    public void valorTitulo() {
        Assert.assertEquals(new BigDecimal("750.5"), this.registro.getValorTitulo());
    }

    @Test
    public void bancoCobrador() {
        Assert.assertEquals("237", this.registro.getBancoCobrador());
    }

    @Test
    public void agenciaCobradora() {
        Assert.assertEquals("02069", this.registro.getAgenciaCobradora());
    }

    @Test
    public void especie() {
        Assert.assertEquals("  ", this.registro.getEspecie());
    }

    @Test
    public void tarifaDeCobranca() {
        Assert.assertEquals(new BigDecimal(0), this.registro.getTarifaDeCobranca());
    }

    @Test
    public void outrasDespesas() {
        Assert.assertEquals(new BigDecimal(0), this.registro.getOutrasDespesas());
    }

    @Test
    public void jurosOperacaoEmAtraso() {
        Assert.assertEquals(new BigDecimal(0), this.registro.getJurosOperacaoEmAtraso());
    }

    @Test
    public void iof() {
        Assert.assertEquals(new BigDecimal(0), this.registro.getIof());
    }

    @Test
    public void valorAbatimento() {
        Assert.assertEquals(new BigDecimal(0), this.registro.getValorAbatimento());
    }

    @Test
    public void descontos() {
        Assert.assertEquals(new BigDecimal(0), this.registro.getDescontos());
    }

    @Test
    public void valorPrincipal() {
        Assert.assertEquals(new BigDecimal("764.9"), this.registro.getValorPrincipal());
    }

    @Test
    public void valorJuros() {
        Assert.assertEquals(new BigDecimal("14.4"), this.registro.getValorJuros());
    }

    @Test
    public void outrosCreditos() {
        Assert.assertEquals(new BigDecimal(0), this.registro.getOutrosCreditos());
    }

    @Test
    public void brancos1() {
        Assert.assertEquals("  ", this.registro.getBrancos1());
    }

    @Test
    public void motivoOcorrencia() {
        Assert.assertEquals(" ", this.registro.getMotivoCodigoOcorrencia());
    }

    @Test
    public void dataCredito() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 18).getTime(), this.registro.getDataCredito());
    }

    @Test
    public void brancos2() {
        Assert.assertEquals("074          0000", this.registro.getBrancos2());
    }

    @Test
    public void motivosRejeicao() {
        Assert.assertEquals("0000000000", this.registro.getMotivosRejeicao());
    }

    @Test
    public void brancos3() {
        Assert.assertEquals("                                                                  ", this.registro.getBrancos3());
    }

    @Test
    public void sequencial() {
        Assert.assertEquals(2, this.registro.getSequencial());
    }

}