package com.ewmix.cnab.arquivoretorno.header;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import com.ewmix.cnab.arquivoretorno.header.HeaderBradesco;

public class HeaderBradescoTest {
    private static final String LINHA = "02RETORNO01COBRANCA       00000000000001111333ABCD DISTRIBUIDORA LTDA       237BRADESCO       1502130160000000805                                                                                                                                                                                                                                                                          180213         000001";
    private final HeaderBradesco header = new HeaderBradesco(LINHA);

    @Test
    public void codigoRegistro() {
        Assert.assertEquals("0", this.header.getCodigoRegistro());
    }

    @Test
    public void codigoRetorno() {
        Assert.assertEquals(2, this.header.getCodigoRetorno());
    }

    @Test
    public void literalRetorno() {
        Assert.assertEquals("RETORNO", this.header.getLiteralRetorno());
    }

    @Test
    public void codigoServico() {
        Assert.assertEquals("01", this.header.getCodigoServico());
    }

    @Test
    public void literalServico() {
        Assert.assertEquals("COBRANCA       ", this.header.getLiteralServico());
    }

    @Test
    public void codigoEmpresa() {
        Assert.assertEquals("00000000000001111333", this.header.getCodigoEmpresa());
    }

    @Test
    public void nomeEmpresa() {
        Assert.assertEquals("ABCD DISTRIBUIDORA LTDA       ", this.header.getNomeEmpresa());
    }

    @Test
    public void codigoBanco() {
        Assert.assertEquals("237", this.header.getCodigoBanco());
    }

    @Test
    public void nomeBanco() {
        Assert.assertEquals("BRADESCO       ", this.header.getNomeBanco());
    }

    @Test
    public void dataGravacao() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 15).getTime(), this.header.getDataGravacao());
    }

    @Test
    public void zeros() {
        Assert.assertEquals("01600000", this.header.getZeros());
    }

    @Test
    public void numeroAvisoBancario() {
        Assert.assertEquals("00805", this.header.getNumeroAvisoBancario());
    }

    @Test
    public void brancos1() {
        Assert.assertEquals("                                                                                                                                                                                                                                                                          ", this.header.getBrancos1());
    }

    @Test
    public void dataCredito() {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.FEBRUARY, 18).getTime(), this.header.getDataCredito());
    }

    @Test
    public void brancos2() {
        Assert.assertEquals("         ", this.header.getBrancos2());
    }

    @Test
    public void sequencial() {
        Assert.assertEquals(1, this.header.getNumeroSequencial());
    }
}