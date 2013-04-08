package com.devmonsters.cnab.arquivoretorno.trailer;

import java.math.BigDecimal;

public class TrailerBradesco extends Trailer {
    
    public TrailerBradesco(final String linha) {
        super(linha);
    }
    
    public String getBrancos1() {
        return super.getLinha().substring(7, 17);
    }
    
    public String getQtdTitulosCobranca() {
        return super.getLinha().substring(17, 25);
    }
    
    public BigDecimal getValorTotalCobranca() {
        return new BigDecimal(super.getLinha().substring(25, 39)).divide(new BigDecimal(100));
    }
    
    public String getNumeroAvisoBancario() {
        return super.getLinha().substring(39, 47);
    }
    
    public String getBrancos2() {
        return super.getLinha().substring(47, 57);
    }
    
    public int getQtdRegistrosOcorrencia02ConfirmacaoEntradas() {
        return Integer.parseInt(super.getLinha().substring(57, 62));
    }
    
    public BigDecimal getValorRegistros02ConfirmacaoEntradas() {
        return new BigDecimal(super.getLinha().substring(62, 74)).divide(new BigDecimal(100));
    }
    
    public BigDecimal getValorRegistros06Liquidacao() {
        return new BigDecimal(super.getLinha().substring(74, 86)).divide(new BigDecimal(100));
    }
    
    public int getQtdRegistrosOcorrencia06() {
        return Integer.parseInt(super.getLinha().substring(86, 91));
    }
    
    public BigDecimal getValorRegistrosOcorrencia0609Baixados() {
        return new BigDecimal(super.getLinha().substring(91, 103)).divide(new BigDecimal(100));
    }
    
    public int getQtdRegistrosOcorrencia0910TitulosBaixados() {
        return Integer.parseInt(super.getLinha().substring(103, 108));
    }
    
    public BigDecimal getValorRegistrosOcorrencia0910TitulosBaixados() {
        return new BigDecimal(super.getLinha().substring(108, 120)).divide(new BigDecimal(100));
    }
    
    public int getQtdRegistrosOcorrencia13AbatimentoCancelado() {
        return Integer.parseInt(super.getLinha().substring(120, 125));
    }
    
    public BigDecimal getValorRegistrosOcorrencia13AbatimentoCancelado() {
        return new BigDecimal(super.getLinha().substring(125, 137)).divide(new BigDecimal(100));
    }
    
    public int getQtdRegistrosOcorrencia14VencimentoAlterado() {
        return Integer.parseInt(super.getLinha().substring(137, 142));
    }
    
    public BigDecimal getValorRegistrosOcorrencia14VencimentoAlterado() {
        return new BigDecimal(super.getLinha().substring(142, 154)).divide(new BigDecimal(100));
    }
    
    public int getQtdRegistrosOcorrencia12AbatimentoConcedido() {
        return Integer.parseInt(super.getLinha().substring(154, 159));
    }
    
    public BigDecimal getValorRegistrosOcorrencia12AbatimentoConcedido() {
        return new BigDecimal(super.getLinha().substring(159, 171)).divide(new BigDecimal(100));
    }
    
    public int getQtdRegistrosOcorrencia19ConfirmacaoInstrucaoProtesto() {
        return Integer.parseInt(super.getLinha().substring(171, 176));
    }
    
    public BigDecimal getValorOcorrencia19ConfirmacaoInstrucaoProtesto() {
        return new BigDecimal(super.getLinha().substring(176, 188)).divide(new BigDecimal(100));
    }
    
    public String getBrancos3() {
        return super.getLinha().substring(188, 362);
    }
    
    public BigDecimal getValorRateiosEfetuados() {
        return new BigDecimal(super.getLinha().substring(362, 377)).divide(new BigDecimal(100));
    }
    
    public int getQtdRateiosEfetuados() {
        return Integer.parseInt(super.getLinha().substring(377, 385));
    }
}