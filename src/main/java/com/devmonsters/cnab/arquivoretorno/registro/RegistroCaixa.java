package com.devmonsters.cnab.arquivoretorno.registro;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

public class RegistroCaixa extends Registro {
    
    public RegistroCaixa(final String linha) {
        super(linha);
    }
    
    @Override
    public InscricaoDaEmpresa getInscricaoDaEmpresa() {
        return InscricaoDaEmpresa.valueOfCodigo(super.getLinha().substring(1, 3));
    }
    
    @Override
    public String getNumeroInscricao() {
        return super.getLinha().substring(3, 17);
    }
    
    public String getCodigoEmpresa() {
        return super.getLinha().substring(17, 33);
    }
    
    @Override
    public String getUsoEmpresa() {
        return super.getLinha().substring(37, 62);
    }
    
    @Override
    public String getNossoNumero() {
        return super.getLinha().substring(62, 73);
    }
    
    public String getCodigoRejeicao() {
        return super.getLinha().substring(79, 82);
    }
    
    public String getUsoBanco() {
        return super.getLinha().substring(82, 106);
    }
    
    @Override
    public String getCarteira() {
        return super.getLinha().substring(106, 108);
    }
    
    @Override
    public String getCodigoOcorrencia() {
        return super.getLinha().substring(108, 110);
    }
    
    @Override
    public Date getDataOcorrencia() {
        return "000000".equals(super.getLinha().substring(110, 116)) ? null : new GregorianCalendar(this.getDataOcorrenciaAno(), this.getDataOcorrenciaMes() - 1, this.getDataOcorrenciaDia()).getTime();
    }
    
    private int getDataOcorrenciaAno() {
        return 2000 + Integer.parseInt(super.getLinha().substring(114, 116));
    }
    
    private int getDataOcorrenciaMes() {
        return Integer.parseInt(super.getLinha().substring(112, 114));
    }
    
    private int getDataOcorrenciaDia() {
        return Integer.parseInt(super.getLinha().substring(110, 112));
    }
    
    @Override
    public String getSeuNumero() {
        return super.getLinha().substring(116, 126);
    }
    
    @Override
    public Date getVencimento() {
        return "000000".equals(super.getLinha().substring(146, 152)) ? null : new GregorianCalendar(this.getDataVencimentoAno(), this.getDataVencimentoMes() - 1, this.getDataVencimentoDia()).getTime();
    }
    
    private int getDataVencimentoAno() {
        return 2000 + Integer.parseInt(super.getLinha().substring(150, 152));
    }
    
    private int getDataVencimentoMes() {
        return Integer.parseInt(super.getLinha().substring(148, 150));
    }
    
    private int getDataVencimentoDia() {
        return Integer.parseInt(super.getLinha().substring(146, 148));
    }
    
    @Override
    public BigDecimal getValorTitulo() {
        return new BigDecimal(super.getLinha().substring(152, 165)).divide(new BigDecimal(100));
    }
    
    public String getCodigoBanco() {
        return super.getLinha().substring(165, 168);
    }
    
    @Override
    public String getAgenciaCobradora() {
        return super.getLinha().substring(168, 173);
    }
    
    @Override
    public String getEspecie() {
        return super.getLinha().substring(173, 175);
    }
    
    @Override
    public BigDecimal getTarifaDeCobranca() {
        return new BigDecimal(super.getLinha().substring(175, 188)).divide(new BigDecimal(100));
    }
    
    public int getTipoLiquidacao() {
        return Integer.parseInt(super.getLinha().substring(188, 191));
    }
    
    public FormaPagamento getFormaPagamento() {
        return FormaPagamento.valueOfCodigo(Integer.parseInt(super.getLinha().substring(191, 192)));
    }
    
    public int getFloatNegociado() {
        return Integer.parseInt(super.getLinha().substring(192, 194));
    }
    
    public Date getDataDebitoTarifa() {
        return "000000".equals(super.getLinha().substring(194, 200)) ? null : new GregorianCalendar(this.getDataDebitoTarifaAno(), this.getDataDebitoTarifaMes() - 1, this.getDataDebitoTarifaDia()).getTime();
    }
    
    private int getDataDebitoTarifaAno() {
        return 2000 + Integer.parseInt(super.getLinha().substring(198, 200));
    }
    
    private int getDataDebitoTarifaMes() {
        return Integer.parseInt(super.getLinha().substring(196, 198));
    }
    
    private int getDataDebitoTarifaDia() {
        return Integer.parseInt(super.getLinha().substring(194, 196));
    }
    
    @Override
    public BigDecimal getIof() {
        return new BigDecimal(super.getLinha().substring(214, 227)).divide(new BigDecimal(100));
    }
    
    @Override
    public BigDecimal getValorAbatimento() {
        return new BigDecimal(super.getLinha().substring(227, 240)).divide(new BigDecimal(100));
    }
    
    @Override
    public BigDecimal getDescontos() {
        return new BigDecimal(super.getLinha().substring(240, 253)).divide(new BigDecimal(100));
    }
    
    @Override
    public BigDecimal getValorPrincipal() {
        return new BigDecimal(super.getLinha().substring(253, 266)).divide(new BigDecimal(100));
    }
    
    @Override
    public BigDecimal getValorJuros() {
        return new BigDecimal(super.getLinha().substring(266, 279)).divide(new BigDecimal(100));
    }
    
    public BigDecimal getValorMulta() {
        return new BigDecimal(super.getLinha().substring(279, 292)).divide(new BigDecimal(100));
    }
    
    public int getCodigoMoeda() {
        return Integer.parseInt(super.getLinha().substring(292, 293));
    }
    
    @Override
    public Date getDataCredito() {
        return "000000".equals(super.getLinha().substring(293, 299)) ? null : new GregorianCalendar(this.getDataCreditoAno(), this.getDataCreditoMes() - 1, this.getDataCreditoDia()).getTime();
    }
    
    private int getDataCreditoAno() {
        return 2000 + Integer.parseInt(super.getLinha().substring(297, 299));
    }
    
    private int getDataCreditoMes() {
        return Integer.parseInt(super.getLinha().substring(295, 297));
    }
    
    private int getDataCreditoDia() {
        return Integer.parseInt(super.getLinha().substring(293, 295));
    }
    
    @Override
    public int getSequencial() {
        return Integer.parseInt(super.getLinha().substring(394, 400));
    }
}