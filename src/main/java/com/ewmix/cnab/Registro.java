package com.ewmix.cnab;

import java.math.BigDecimal;
import java.util.Date;

import com.ewmix.cnab.arquivoretorno.registro.InscricaoDaEmpresa;

public abstract class Registro {

    public abstract String getCodigoRegistro();

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