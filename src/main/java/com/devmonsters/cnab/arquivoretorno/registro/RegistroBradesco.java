package com.devmonsters.cnab.arquivoretorno.registro;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

public class RegistroBradesco extends Registro {
    
    public RegistroBradesco(final String linha) {
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
    
    public String getZeros1() {
        return super.getLinha().substring(17, 20);
    }
    
    public String getIdentificacaoEmpresaCedente() {
        return super.getLinha().substring(20, 37);
    }
    
    /**
     * No bradesco este campo eh representado Numero Controle do Participante
     */
    @Override
    public String getUsoEmpresa() {
        return super.getLinha().substring(37, 62);
    }
    
    public String getZeros2() {
        return super.getLinha().substring(62, 70);
    }
    
    /**
     * Identificação do Título no Banco - Caso o Arquivo-Remessa tenha sido enviado com "Zeros", nesse campo estará sendo confirmado o Nosso Número gerado para o Título. - Caso o Arquivo-Remessa tenha sido enviado com o Nosso Número formatado, o mesmo será confirmado.
     */
    @Override
    public String getNossoNumero() {
        return super.getLinha().substring(70, 82);
    }
    
    public String getUsoBanco1() {
        return super.getLinha().substring(82, 92);
    }
    
    public String getUsoBanco2() {
        return super.getLinha().substring(92, 104);
    }
    
    /**
     * Somente será informado "R", para a Empresa participante da rotina de rateio de crédito, caso não, será informado branco.
     */
    public String getIndicadorRateio() {
        return super.getLinha().substring(104, 105);
    }
    
    public String getZeros3() {
        return super.getLinha().substring(105, 107);
    }
    
    @Override
    public String getCarteira() {
        return super.getLinha().substring(107, 108);
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
    
    public String getIdentificacaoTituloNoBanco() {
        return super.getLinha().substring(126, 146);
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
    
    public String getBancoCobrador() {
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
    
    public BigDecimal getOutrasDespesas() {
        return new BigDecimal(super.getLinha().substring(188, 201)).divide(new BigDecimal(100));
    }
    
    public BigDecimal getJurosOperacaoEmAtraso() {
        return new BigDecimal(super.getLinha().substring(201, 214)).divide(new BigDecimal(100));
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
    
    public BigDecimal getOutrosCreditos() {
        return new BigDecimal(super.getLinha().substring(279, 292)).divide(new BigDecimal(100));
    }
    
    public String getBrancos1() {
        return super.getLinha().substring(292, 294);
    }
    
    public String getMotivoCodigoOcorrencia() {
        return super.getLinha().substring(294, 295);
    }
    
    @Override
    public Date getDataCredito() {
        return "000000".equals(super.getLinha().substring(295, 301)) ? null : new GregorianCalendar(this.getDataCreditoAno(), this.getDataCreditoMes() - 1, this.getDataCreditoDia()).getTime();
    }
    
    private int getDataCreditoAno() {
        return 2000 + Integer.parseInt(super.getLinha().substring(299, 301));
    }
    
    private int getDataCreditoMes() {
        return Integer.parseInt(super.getLinha().substring(297, 299));
    }
    
    private int getDataCreditoDia() {
        return Integer.parseInt(super.getLinha().substring(295, 297));
    }
    
    public String getBrancos2() {
        return super.getLinha().substring(301, 318);
    }
    
    public String getMotivosRejeicao() {
        return super.getLinha().substring(318, 328);
    }
    
    public String getBrancos3() {
        return super.getLinha().substring(328, 394);
    }
    
    @Override
    public int getSequencial() {
        return Integer.parseInt(super.getLinha().substring(394, 400));
    }
}