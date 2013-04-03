package com.google.code.cnab.arquivoretorno.registro;

import org.junit.Assert;
import org.junit.Test;

public class InscricaoDaEmpresaTest {

    @Test
    public void cpfPeloCodigo() {
        Assert.assertEquals(InscricaoDaEmpresa.CPF, InscricaoDaEmpresa.valueOfCodigo("01"));
    }

    @Test
    public void cgcPeloCodigo() {
        Assert.assertEquals(InscricaoDaEmpresa.CGC, InscricaoDaEmpresa.valueOfCodigo("02"));
    }

    @Test
    public void codigoInvalidoRetornaNulo() {
        Assert.assertNull(InscricaoDaEmpresa.valueOfCodigo("04"));
    }
}
