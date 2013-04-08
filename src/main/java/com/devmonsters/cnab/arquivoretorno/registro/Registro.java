package com.devmonsters.cnab.arquivoretorno.registro;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Registro {
    
    private final String linha;
    
    public Registro(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException(String.format("Registro come\u00e7a com %s", this.getCodigoRegistro()));
        }
        this.linha = linha;
    }
    
    public String getLinha() {
        return this.linha;
    }
    
    public final String getCodigoRegistro() {
        return "1";
    }
    
    public abstract InscricaoDaEmpresa getInscricaoDaEmpresa();
    
    public abstract String getNumeroInscricao();
    
    public abstract String getUsoEmpresa();
    
    public abstract String getNossoNumero();
    
    public abstract String getCarteira();
    
    public abstract String getCodigoOcorrencia();
    
    public abstract Date getDataOcorrencia();
    
    public abstract String getSeuNumero();
    
    public abstract Date getVencimento();
    
    public abstract BigDecimal getValorTitulo();
    
    public abstract String getAgenciaCobradora();
    
    public abstract String getEspecie();
    
    public abstract BigDecimal getTarifaDeCobranca(); // para o Bradesco chama-se despesas de cobranca
    
    public abstract BigDecimal getValorJuros();
    
    public abstract BigDecimal getIof();
    
    public abstract BigDecimal getValorAbatimento();
    
    public abstract BigDecimal getDescontos();
    
    public abstract BigDecimal getValorPrincipal(); // valor pago pelo Sacado
    
    public abstract Date getDataCredito();
    
    public abstract int getSequencial();
}