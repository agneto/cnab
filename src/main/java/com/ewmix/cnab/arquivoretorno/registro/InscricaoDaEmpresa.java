package com.ewmix.cnab.arquivoretorno.registro;

public enum InscricaoDaEmpresa {
    
    CPF("01"),
    CGC("02"),
    PIS("03"),
    NAOTEM("98"),
    OUTROS("99");
    
    private final String codigo;
    
    private InscricaoDaEmpresa(final String value) {
        this.codigo = value;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public static InscricaoDaEmpresa valueOfCodigo(final String codigo) {
        for (final InscricaoDaEmpresa inscricaoDaEmpresa : InscricaoDaEmpresa.values()) {
            if (codigo.equals(inscricaoDaEmpresa.getCodigo())) {
                return inscricaoDaEmpresa;
            }
        }
        return null;
    }
}