package com.devmonsters.cnab.arquivoretorno.registro;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class RegistroBradescoTest {
    
    private static final String LINHA_VALIDA = "10201111222200002000000888886000005045554444-1                000000000008064994150000000000000000000000000906150213002058663500000000000203188604060213000000007505023702069  000000000000000000000000000000000000000000000000000000000000000000000000000000000000007649000000000014400000000000000   180213074          00000000000000                                                                  000002";
    private static final String LINHA_INVALIDA = "80201111222200002000000888886000005045554444-1                000000000008064994150000000000000000000000000906150213002058663500000000000203188604060213000000007505023702069  000000000000000000000000000000000000000000000000000000000000000000000000000000000000007649000000000014400000000000000   180213074          00000000000000                                                                  000002";
    
    @Test(expected = IllegalArgumentException.class)
    public void linhaInvalidaFalhaNaConstrucao() {
        new RegistroBradesco(RegistroBradescoTest.LINHA_INVALIDA);
    }
    
    @Test
    public void objetoNaoPodeModificarLinha() {
        Assert.assertEquals(LINHA_VALIDA, new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getLinha());
    }
    
    @Test
    public void codigoRegistro() {
        Assert.assertEquals("1", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getCodigoRegistro());
    }
    
    @Test
    public void inscricaoDaEmpresa() {
        Assert.assertEquals("02", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getInscricaoDaEmpresa().getCodigo());
    }
    
    @Test
    public void numeroInscricao() {
        Assert.assertEquals("01111222200002", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getNumeroInscricao());
    }
    
    @Test
    public void zeros1() {
        Assert.assertEquals("000", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getZeros1());
    }
    
    @Test
    public void identificaoEmpresaCedente() {
        Assert.assertEquals("00088888600000504", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getIdentificacaoEmpresaCedente());
    }
    
    @Test
    public void usoEmpresa() {
        Assert.assertEquals("5554444-1                ", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getUsoEmpresa());
    }
    
    @Test
    public void zeros2() {
        Assert.assertEquals("00000000", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getZeros2());
    }
    
    @Test
    public void nossoNumero() {
        Assert.assertEquals("000806499415", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getNossoNumero());
    }
    
    @Test
    public void usoBanco1() {
        Assert.assertEquals("0000000000", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getUsoBanco1());
    }
    
    @Test
    public void usoBanco2() {
        Assert.assertEquals("000000000000", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getUsoBanco2());
    }
    
    @Test
    public void indicadorRateio() {
        Assert.assertEquals("0", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getIndicadorRateio());
    }
    
    @Test
    public void zeros3() {
        Assert.assertEquals("00", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getZeros3());
    }
    
    @Test
    public void carteira() {
        Assert.assertEquals("9", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getCarteira());
    }
    
    @Test
    public void codigoOcorrencia() {
        Assert.assertEquals("06", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getCodigoOcorrencia());
    }
    
    @Test
    public void dataOcorrencia() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 15).getTime(), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getDataOcorrencia());
    }
    
    @Test
    public void seuNumero() {
        Assert.assertEquals("0020586635", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getSeuNumero());
    }
    
    @Test
    public void identificacaoTituloNoBanco() {
        Assert.assertEquals("00000000000203188604", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getIdentificacaoTituloNoBanco());
    }
    
    @Test
    public void vencimento() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 6).getTime(), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getVencimento());
    }
    
    @Test
    public void valorTitulo() {
        Assert.assertEquals(new BigDecimal("750.5"), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getValorTitulo());
    }
    
    @Test
    public void bancoCobrador() {
        Assert.assertEquals("237", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getBancoCobrador());
    }
    
    @Test
    public void agenciaCobradora() {
        Assert.assertEquals("02069", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getAgenciaCobradora());
    }
    
    @Test
    public void especie() {
        Assert.assertEquals("  ", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getEspecie());
    }
    
    @Test
    public void tarifaDeCobranca() {
        Assert.assertEquals(new BigDecimal(0), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getTarifaDeCobranca());
    }
    
    @Test
    public void outrasDespesas() {
        Assert.assertEquals(new BigDecimal(0), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getOutrasDespesas());
    }
    
    @Test
    public void jurosOperacaoEmAtraso() {
        Assert.assertEquals(new BigDecimal(0), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getJurosOperacaoEmAtraso());
    }
    
    @Test
    public void iof() {
        Assert.assertEquals(new BigDecimal(0), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getIof());
    }
    
    @Test
    public void valorAbatimento() {
        Assert.assertEquals(new BigDecimal(0), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getValorAbatimento());
    }
    
    @Test
    public void descontos() {
        Assert.assertEquals(new BigDecimal(0), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getDescontos());
    }
    
    @Test
    public void valorPrincipal() {
        Assert.assertEquals(new BigDecimal("764.9"), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getValorPrincipal());
    }
    
    @Test
    public void valorJuros() {
        Assert.assertEquals(new BigDecimal("14.4"), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getValorJuros());
    }
    
    @Test
    public void outrosCreditos() {
        Assert.assertEquals(new BigDecimal(0), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getOutrosCreditos());
    }
    
    @Test
    public void brancos1() {
        Assert.assertEquals("  ", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getBrancos1());
    }
    
    @Test
    public void motivoOcorrencia() {
        Assert.assertEquals(" ", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getMotivoCodigoOcorrencia());
    }
    
    @Test
    public void dataCredito() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 18).getTime(), new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getDataCredito());
    }
    
    @Test
    public void brancos2() {
        Assert.assertEquals("074          0000", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getBrancos2());
    }
    
    @Test
    public void motivosRejeicao() {
        Assert.assertEquals("0000000000", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getMotivosRejeicao());
    }
    
    @Test
    public void brancos3() {
        Assert.assertEquals("                                                                  ", new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getBrancos3());
    }
    
    @Test
    public void sequencial() {
        Assert.assertEquals(2, new RegistroBradesco(RegistroBradescoTest.LINHA_VALIDA).getSequencial());
    }
    
}