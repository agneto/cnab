package com.devmonsters.cnab.arquivoretorno.trailer;

public abstract class Trailer {
    
    private final String linha;
    
    public Trailer(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException(String.format("Trailer come\u00e7a com %s", this.getCodigoRegistro()));
        }
        this.linha = linha;
    }
    
    public String getLinha() {
        return this.linha;
    }
    
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