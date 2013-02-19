package com.google.code.cnab.bancos;

public enum BancosSuportados {
    CEF(104),
    BRADESCO(237);

    private int codigoBanco;

    private BancosSuportados(final int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public int getCodigoBanco() {
        return this.codigoBanco;
    }

    public static BancosSuportados valueOfCodigoBanco(final int codigoBanco) {
        for (final BancosSuportados bs : values()) {
            if (codigoBanco == bs.getCodigoBanco()) {
                return bs;
            }
        }
        return null;
    }
}