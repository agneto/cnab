package com.google.code.cnab.arquivoretorno.registro;

import org.junit.Assert;
import org.junit.Test;

public class FormaPagamentoTest {

    @Test
    public void dinheiroPeloCodigo() {
        Assert.assertEquals(FormaPagamento.DINHEIRO, FormaPagamento.valueOfCodigo(1));
    }

    @Test
    public void chequePeloCodigo() {
        Assert.assertEquals(FormaPagamento.CHEQUE, FormaPagamento.valueOfCodigo(2));
    }

    @Test
    public void codigoInvalidoRetornaNulo() {
        Assert.assertNull(FormaPagamento.valueOfCodigo(3));
    }
}