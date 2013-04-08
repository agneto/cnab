package com.devmonsters.cnab;

public enum Banco {

    CEF(104),
    BRADESCO(237);

    private final int codigo;

    private Banco(final int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static Banco valueOfCodigo(final int codigoBanco) {
        for (final Banco banco : Banco.values()) {
            if (codigoBanco == banco.getCodigo()) {
                return banco;
            }
        }
        return null;
    }
}