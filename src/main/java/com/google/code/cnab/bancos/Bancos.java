package com.google.code.cnab.bancos;

public enum Bancos {
    CEF(104),
    BRADESCO(237);

    private int codigoBanco;

    private Bancos(final int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public int getCodigoBanco() {
        return this.codigoBanco;
    }

    public static Bancos valueOfCodigoBanco(final int codigoBanco) {
        for (final Bancos bs : values()) {
            if (codigoBanco == bs.getCodigoBanco()) {
                return bs;
            }
        }
        return null;
    }
}