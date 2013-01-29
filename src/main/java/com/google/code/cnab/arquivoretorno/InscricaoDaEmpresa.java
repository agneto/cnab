package com.google.code.cnab.arquivoretorno;

public enum InscricaoDaEmpresa {

    CPF("01"),
    CGC("02");

    private String value;

    private InscricaoDaEmpresa(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
