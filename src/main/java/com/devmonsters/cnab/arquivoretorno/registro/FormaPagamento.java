package com.devmonsters.cnab.arquivoretorno.registro;

public enum FormaPagamento {

    DINHEIRO(1),
    CHEQUE(2);

    private final int codigo;

    private FormaPagamento(final int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static FormaPagamento valueOfCodigo(final int codigo) {
        for (final FormaPagamento formaPagamento : FormaPagamento.values()) {
            if (codigo == formaPagamento.getCodigo()) {
                return formaPagamento;
            }
        }
        return null;
    }
}