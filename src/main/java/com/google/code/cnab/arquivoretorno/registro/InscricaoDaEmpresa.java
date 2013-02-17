package com.google.code.cnab.arquivoretorno.registro;

public enum InscricaoDaEmpresa {
    CPF("01"),
    CGC("02");

    private String codigo;

    private InscricaoDaEmpresa(final String value) {
        this.codigo = value;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static InscricaoDaEmpresa valueOfCodigo(String codigo) {
        for (InscricaoDaEmpresa inscricaoDaEmpresa : values()) {
            if (codigo.equals(inscricaoDaEmpresa.getCodigo())) {
                return inscricaoDaEmpresa;
            }
        }
        return null;
    }
}