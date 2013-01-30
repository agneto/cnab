package com.google.code.cnab.arquivoretorno.registro;

public enum FormaPagamento {
    DINHEIRO(1),
    CHEQUE(2);

    private int value;

    private FormaPagamento(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}