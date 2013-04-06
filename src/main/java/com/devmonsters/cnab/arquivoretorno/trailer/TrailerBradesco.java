package com.devmonsters.cnab.arquivoretorno.trailer;

import java.math.BigDecimal;

public class TrailerBradesco extends Trailer {

    public TrailerBradesco(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException("Trailer come\u00e7a com 9");
        }
        this.linha = linha;
    }

    public String getBrancos1() {
        return this.linha.substring(7, 17);
    }

    public String getQtdTitulosCobranca() {
        return this.linha.substring(17, 25);
    }

    public BigDecimal getValorTotalCobranca() {
        return new BigDecimal(this.linha.substring(25, 39)).divide(new BigDecimal(100));
    }

    public String getNumeroAvisoBancario() {
        return this.linha.substring(39, 47);
    }

    public String getBrancos2() {
        return this.linha.substring(47, 57);
    }

    public int getQtdRegistrosOcorrencia02ConfirmacaoEntradas() {
        return Integer.parseInt(this.linha.substring(57, 62));
    }

    public BigDecimal getValorRegistros02ConfirmacaoEntradas() {
        return new BigDecimal(this.linha.substring(62, 74)).divide(new BigDecimal(100));
    }

    public BigDecimal getValorRegistros06Liquidacao() {
        return new BigDecimal(this.linha.substring(74, 86)).divide(new BigDecimal(100));
    }

    public int getQtdRegistrosOcorrencia06() {
        return Integer.parseInt(this.linha.substring(86, 91));
    }

    public BigDecimal getValorRegistrosOcorrencia0609Baixados() {
        return new BigDecimal(this.linha.substring(91, 103)).divide(new BigDecimal(100));
    }

    public int getQtdRegistrosOcorrencia0910TitulosBaixados() {
        return Integer.parseInt(this.linha.substring(103, 108));
    }

    public BigDecimal getValorRegistrosOcorrencia0910TitulosBaixados() {
        return new BigDecimal(this.linha.substring(108, 120)).divide(new BigDecimal(100));
    }

    public int getQtdRegistrosOcorrencia13AbatimentoCancelado() {
        return Integer.parseInt(this.linha.substring(120, 125));
    }

    public BigDecimal getValorRegistrosOcorrencia13AbatimentoCancelado() {
        return new BigDecimal(this.linha.substring(125, 137)).divide(new BigDecimal(100));
    }

    public int getQtdRegistrosOcorrencia14VencimentoAlterado() {
        return Integer.parseInt(this.linha.substring(137, 142));
    }

    public BigDecimal getValorRegistrosOcorrencia14VencimentoAlterado() {
        return new BigDecimal(this.linha.substring(142, 154)).divide(new BigDecimal(100));
    }

    public int getQtdRegistrosOcorrencia12AbatimentoConcedido() {
        return Integer.parseInt(this.linha.substring(154, 159));
    }

    public BigDecimal getValorRegistrosOcorrencia12AbatimentoConcedido() {
        return new BigDecimal(this.linha.substring(159, 171)).divide(new BigDecimal(100));
    }

    public int getQtdRegistrosOcorrencia19ConfirmacaoInstrucaoProtesto() {
        return Integer.parseInt(this.linha.substring(171, 176));
    }

    public BigDecimal getValorOcorrencia19ConfirmacaoInstrucaoProtesto() {
        return new BigDecimal(this.linha.substring(176, 188)).divide(new BigDecimal(100));
    }

    public String getBrancos3() {
        return this.linha.substring(188, 362);
    }

    public BigDecimal getValorRateiosEfetuados() {
        return new BigDecimal(this.linha.substring(362, 377)).divide(new BigDecimal(100));
    }

    public int getQtdRateiosEfetuados() {
        return Integer.parseInt(this.linha.substring(377, 385));
    }
}