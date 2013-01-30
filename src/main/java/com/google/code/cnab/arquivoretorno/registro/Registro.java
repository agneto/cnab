package com.google.code.cnab.arquivoretorno.registro;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

public class Registro {

    private final String linha;

    public Registro(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException("Registro começa com 1");
        }
        this.linha = linha;
    }

    public String getCodigoRegistro() {
        return "1";
    }

    public InscricaoDaEmpresa getInscricaoDaEmpresa() {
        return this.linha.substring(1, 3).trim().equals("02") ? InscricaoDaEmpresa.CGC : InscricaoDaEmpresa.CPF;
    }

    public String getNumeroInscricao() {
        return this.linha.substring(3, 17).trim();
    }

    public String getCodigoEmpresa() {
        return this.linha.substring(17, 33).trim();
    }

    public String getUsoEmpresa() {
        return this.linha.substring(37, 62);
    }

    public String getNossoNumero() {
        return this.linha.substring(62, 73).trim();
    }

    public String getCodigoRejeicao() {
        return this.linha.substring(79, 82).trim();
    }

    public String getUsoBanco() {
        return this.linha.substring(82, 106);
    }

    public String getCarteira() {
        return this.linha.substring(106, 108).trim();
    }

    public String getCodigoOcorrencia() {
        return this.linha.substring(108, 110).trim();
    }

    public Date getDataOcorrencia() {
        final String dataOcorrencia = this.linha.substring(110, 116);
        if (!dataOcorrencia.equals("000000")) {
            return new GregorianCalendar(2000 + Integer.parseInt(dataOcorrencia.substring(4)), Integer.parseInt(dataOcorrencia.substring(2, 4)) - 1, Integer.parseInt(dataOcorrencia.substring(0, 2))).getTime();
        } else {
            return null;
        }
    }

    public String getSeuNumero() {
        return this.linha.substring(116, 126);
    }

    public Date getVencimento() {
        final String dataVencimento = this.linha.substring(146, 152).trim();
        if (!dataVencimento.equals("000000")) {
            return new GregorianCalendar(2000 + Integer.parseInt(dataVencimento.substring(4)), Integer.parseInt(dataVencimento.substring(2, 4)) - 1, Integer.parseInt(dataVencimento.substring(0, 2))).getTime();
        } else {
            return null;
        }
    }

    public BigDecimal getValorTitulo() {
        return new BigDecimal(this.linha.substring(152, 165).trim()).divide(new BigDecimal(100));
    }

    public String getCodigoBanco() {
        return this.linha.substring(165, 168).trim();
    }

    public String getAgenciaCobradora() {
        return this.linha.substring(168, 173).trim();
    }

    public String getEspecie() {
        return this.linha.substring(173, 175).trim();
    }

    public BigDecimal getTarifaDeCobranca() {
        return new BigDecimal(this.linha.substring(175, 188).trim()).divide(new BigDecimal(100));
    }

    public Integer getTipoLiquidacao() {
        return Integer.parseInt(this.linha.substring(188, 191).trim());
    }

    public FormaPagamento getFormaPagamento() {
        return this.linha.substring(191, 192).equals("1") ? FormaPagamento.DINHEIRO : FormaPagamento.CHEQUE;
    }

    public int getFloatNegociado() {
        return Integer.parseInt(this.linha.substring(192, 194).trim());
    }

    public Date getDataDebitoTarifa() {
        final String debitoTarifa = this.linha.substring(194, 200).trim();
        if (!debitoTarifa.equals("000000")) {
            return new GregorianCalendar(2000 + Integer.parseInt(debitoTarifa.substring(4)), Integer.parseInt(debitoTarifa.substring(2, 4)) - 1, Integer.parseInt(debitoTarifa.substring(0, 2))).getTime();
        } else {
            return null;
        }
    }

    public BigDecimal getIof() {
        return new BigDecimal(this.linha.substring(214, 227)).divide(new BigDecimal(100));
    }

    public BigDecimal getValorAbatimento() {
        return new BigDecimal(this.linha.substring(227, 240).trim()).divide(new BigDecimal(100));
    }

    public BigDecimal getDescontos() {
        return new BigDecimal(this.linha.substring(240, 253).trim()).divide(new BigDecimal(100));
    }

    public BigDecimal getValorPrincipal() {
        return new BigDecimal(this.linha.substring(253, 266).trim()).divide(new BigDecimal(100));
    }

    public BigDecimal getValorJuros() {
        return new BigDecimal(this.linha.substring(266, 279).trim()).divide(new BigDecimal(100));
    }

    public BigDecimal getValorMulta() {
        return new BigDecimal(this.linha.substring(279, 292).trim()).divide(new BigDecimal(100));
    }

    public Integer getCodigoMoeda() {
        return Integer.parseInt(this.linha.substring(292, 293));
    }

    public Date getDataCredito() {
        final String dtCredito = this.linha.substring(293, 299).trim();
        if (!dtCredito.equals("000000")) {
            return new GregorianCalendar(2000 + Integer.parseInt(dtCredito.substring(4)), Integer.parseInt(dtCredito.substring(2, 4)) - 1, Integer.parseInt(dtCredito.substring(0, 2))).getTime();
        } else {
            return null;
        }
    }

    public int getSequencial() {
        return Integer.parseInt(this.linha.substring(394, 400).trim());
    }
}