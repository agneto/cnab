package com.google.code.cnab.arquivoretorno.trailer;

public abstract class Trailer {
    
    String linha;
    
    public String getCodigoRegistro() {
        return "9";
    }
    
    public String getCodigoRetorno() {
        return this.linha.substring(1, 2);
    }
    
    public String getCodigoDoServico() {
        return this.linha.substring(2, 4);
    }
    
    public String getCodigoDoBanco() {
        return this.linha.substring(4, 7);
    }
    
    public int getSequencial() {
        return Integer.parseInt(this.linha.substring(394, 400));
    }
}