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
        return InscricaoDaEmpresa.valueOfCodigo(this.linha.substring(1, 3));
    }

    public String getNumeroInscricao() {
        return this.linha.substring(3, 17);
    }

    public String getCodigoEmpresa() {
        return this.linha.substring(17, 33);
    }

    public String getUsoEmpresa() {
        return this.linha.substring(37, 62);
    }

    public String getNossoNumero() {
        return this.linha.substring(62, 73);
    }

    public String getCodigoRejeicao() {
        return this.linha.substring(79, 82);
    }

    public String getUsoBanco() {
        return this.linha.substring(82, 106);
    }

    public String getCarteira() {
        return this.linha.substring(106, 108);
    }

    public String getCodigoOcorrencia() {
        return this.linha.substring(108, 110);
    }

    public Date getDataOcorrencia() {
        return "000000".equals(this.linha.substring(110, 116)) ? null : new GregorianCalendar(getDataOcorrenciaAno(), getDataOcorrenciaMes() - 1, getDataOcorrenciaDia()).getTime();
    }

    private int getDataOcorrenciaAno() {
        return 2000 + Integer.parseInt(this.linha.substring(114, 116));
    }

    private int getDataOcorrenciaMes() {
        return Integer.parseInt(this.linha.substring(112, 114));
    }

    private int getDataOcorrenciaDia() {
        return Integer.parseInt(this.linha.substring(110, 112));
    }

    public String getSeuNumero() {
        return this.linha.substring(116, 126);
    }

    public Date getVencimento() {
        return "000000".equals(this.linha.substring(146, 152)) ? null : new GregorianCalendar(getDataVencimentoAno(), getDataVencimentoMes() - 1, getDataVencimentoDia()).getTime();
    }

    private int getDataVencimentoAno() {
        return 2000 + Integer.parseInt(this.linha.substring(150, 152));
    }

    private int getDataVencimentoMes() {
        return Integer.parseInt(this.linha.substring(148, 150));
    }

    private int getDataVencimentoDia() {
        return Integer.parseInt(this.linha.substring(146, 148));
    }

    public BigDecimal getValorTitulo() {
        return new BigDecimal(this.linha.substring(152, 165)).divide(new BigDecimal(100));
    }

    public String getCodigoBanco() {
        return this.linha.substring(165, 168);
    }

    public String getAgenciaCobradora() {
        return this.linha.substring(168, 173);
    }

    public String getEspecie() {
        return this.linha.substring(173, 175);
    }

    public BigDecimal getTarifaDeCobranca() {
        return new BigDecimal(this.linha.substring(175, 188)).divide(new BigDecimal(100));
    }

    public int getTipoLiquidacao() {
        return Integer.parseInt(this.linha.substring(188, 191));
    }

    public FormaPagamento getFormaPagamento() {
        return FormaPagamento.valueOfCodigo(Integer.parseInt(this.linha.substring(191, 192)));
    }

    public int getFloatNegociado() {
        return Integer.parseInt(this.linha.substring(192, 194));
    }

    public Date getDataDebitoTarifa() {
        return "000000".equals(this.linha.substring(194, 200)) ? null : new GregorianCalendar(getDataDebitoTarifaAno(), getDataDebitoTarifaMes() - 1, getDataDebitoTarifaDia()).getTime();
    }

    private int getDataDebitoTarifaAno() {
        return 2000 + Integer.parseInt(this.linha.substring(198, 200));
    }

    private int getDataDebitoTarifaMes() {
        return Integer.parseInt(this.linha.substring(196, 198));
    }

    private int getDataDebitoTarifaDia() {
        return Integer.parseInt(this.linha.substring(194, 196));
    }

    public BigDecimal getIof() {
        return new BigDecimal(this.linha.substring(214, 227)).divide(new BigDecimal(100));
    }

    public BigDecimal getValorAbatimento() {
        return new BigDecimal(this.linha.substring(227, 240)).divide(new BigDecimal(100));
    }

    public BigDecimal getDescontos() {
        return new BigDecimal(this.linha.substring(240, 253)).divide(new BigDecimal(100));
    }

    public BigDecimal getValorPrincipal() {
        return new BigDecimal(this.linha.substring(253, 266)).divide(new BigDecimal(100));
    }

    public BigDecimal getValorJuros() {
        return new BigDecimal(this.linha.substring(266, 279)).divide(new BigDecimal(100));
    }

    public BigDecimal getValorMulta() {
        return new BigDecimal(this.linha.substring(279, 292)).divide(new BigDecimal(100));
    }

    public int getCodigoMoeda() {
        return Integer.parseInt(this.linha.substring(292, 293));
    }

    public Date getDataCredito() {
        return "000000".equals(this.linha.substring(293, 299)) ? null : new GregorianCalendar(getDataCreditoAno(), getDataCreditoMes() - 1, getDataCreditoDia()).getTime();
    }

    private int getDataCreditoAno() {
        return 2000 + Integer.parseInt(this.linha.substring(297, 299));
    }

    private int getDataCreditoMes() {
        return Integer.parseInt(this.linha.substring(295, 297));
    }

    private int getDataCreditoDia() {
        return Integer.parseInt(this.linha.substring(293, 295));
    }

    public int getSequencial() {
        return Integer.parseInt(this.linha.substring(394, 400));
    }
}