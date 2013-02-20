package com.google.code.cnab.arquivoretorno.registro;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import com.google.code.cnab.Registro;

public class RegistroBradesco extends Registro {
    private final String linha;

    public RegistroBradesco(final String linha) {
        if (!linha.startsWith(this.getCodigoRegistro())) {
            throw new IllegalArgumentException("Registro come\u00e7a com 1");
        }
        this.linha = linha;
    }

    @Override
    public String getCodigoRegistro() {
        return "1";
    }

    /**
     * Tipo de Inscricao da Empresa
     * */
    @Override
    public InscricaoDaEmpresa getInscricaoDaEmpresa() {
        return InscricaoDaEmpresa.valueOfCodigo(this.linha.substring(1, 3));
    }

    /**
     * representa o CGC/CPF, Número Filial, Controle
     * */
    @Override
    public String getNumeroInscricao() {
        return this.linha.substring(3, 17);
    }

    public String getZeros1() {
        return this.linha.substring(17, 20);
    }

    public String getIdentificacaoEmpresaCedente() {
        return this.linha.substring(20, 37);
    }

    /**
     * No bradesco este campo é representado Numero Controle do Participante
     * */
    @Override
    public String getUsoEmpresa() {
        return this.linha.substring(37, 62);
    }

    public String getZeros2() {
        return this.linha.substring(62, 70);
    }

    /**
     * Identificação do Título no Banco - Caso o Arquivo-Remessa tenha sido enviado com "Zeros", nesse campo estará sendo confirmado o Nosso Número gerado para o Título. - Caso o Arquivo-Remessa tenha sido enviado com o Nosso Número formatado, o mesmo será confirmado.
     * */
    @Override
    public String getNossoNumero() {
        return this.linha.substring(70, 82);
    }

    public String getUsoBanco1() {
        return this.linha.substring(82, 92);
    }

    public String getUsoBanco2() {
        return this.linha.substring(92, 104);
    }

    /**
     * Somente será informado "R", para a Empresa participante da rotina de rateio de crédito, caso não, será informado branco.
     * */
    public String getIndicadorRateio() {
        return this.linha.substring(104, 105);
    }

    public String getZeros3() {
        return this.linha.substring(105, 107);
    }

    @Override
    public String getCarteira() {
        return this.linha.substring(107, 108);
    }

    @Override
    public String getCodigoOcorrencia() {
        return this.linha.substring(108, 110);
    }

    @Override
    public Date getDataOcorrencia() {
        return "000000".equals(this.linha.substring(110, 116)) ? null : new GregorianCalendar(this.getDataOcorrenciaAno(), this.getDataOcorrenciaMes() - 1, this.getDataOcorrenciaDia()).getTime();
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

    /**
     * Número do Documento
     * */
    @Override
    public String getSeuNumero() {
        return this.linha.substring(116, 126);
    }

    public String getIdentificacaoTituloNoBanco() {
        return this.linha.substring(126, 146);
    }

    @Override
    public Date getVencimento() {
        return "000000".equals(this.linha.substring(146, 152)) ? null : new GregorianCalendar(this.getDataVencimentoAno(), this.getDataVencimentoMes() - 1, this.getDataVencimentoDia()).getTime();
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

    @Override
    public BigDecimal getValorTitulo() {
        return new BigDecimal(this.linha.substring(152, 165)).divide(new BigDecimal(100));
    }

    /**
     * Codigo do banco na Camara de compensacao
     * */
    public String getBancoCobrador() {
        return this.linha.substring(165, 168);
    }

    @Override
    public String getAgenciaCobradora() {
        return this.linha.substring(168, 173);
    }

    @Override
    public String getEspecie() {
        return this.linha.substring(173, 175);
    }

    /**
     * Despesas de cobrança para os Códigos de Ocorrência
     * */
    @Override
    public BigDecimal getTarifaDeCobranca() {
        return new BigDecimal(this.linha.substring(175, 188)).divide(new BigDecimal(100));
    }

    public BigDecimal getOutrasDespesas() {
        return new BigDecimal(this.linha.substring(188, 201)).divide(new BigDecimal(100));
    }

    public BigDecimal getJurosOperacaoEmAtraso() {
        return new BigDecimal(this.linha.substring(201, 214)).divide(new BigDecimal(100));
    }

    @Override
    public BigDecimal getIof() {
        return new BigDecimal(this.linha.substring(214, 227)).divide(new BigDecimal(100));
    }

    @Override
    public BigDecimal getValorAbatimento() {
        return new BigDecimal(this.linha.substring(227, 240)).divide(new BigDecimal(100));
    }

    @Override
    public BigDecimal getDescontos() {
        return new BigDecimal(this.linha.substring(240, 253)).divide(new BigDecimal(100));
    }

    /**
     * Neste campo será informado o valor total recebido
     * */
    @Override
    public BigDecimal getValorPrincipal() {
        return new BigDecimal(this.linha.substring(253, 266)).divide(new BigDecimal(100));
    }

    /**
     * Juros de Mora
     * */
    @Override
    public BigDecimal getValorJuros() {
        return new BigDecimal(this.linha.substring(266, 279)).divide(new BigDecimal(100));
    }

    public BigDecimal getOutrosCreditos() {
        return new BigDecimal(this.linha.substring(279, 292)).divide(new BigDecimal(100));
    }

    public String getBrancos1() {
        return this.linha.substring(292, 294);
    }

    public String getMotivoCodigoOcorrencia() {
        return this.linha.substring(294, 295);
    }

    @Override
    public Date getDataCredito() {
        return "000000".equals(this.linha.substring(295, 301)) ? null : new GregorianCalendar(this.getDataCreditoAno(), this.getDataCreditoMes() - 1, this.getDataCreditoDia()).getTime();
    }

    private int getDataCreditoAno() {
        return 2000 + Integer.parseInt(this.linha.substring(299, 301));
    }

    private int getDataCreditoMes() {
        return Integer.parseInt(this.linha.substring(297, 299));
    }

    private int getDataCreditoDia() {
        return Integer.parseInt(this.linha.substring(295, 297));
    }

    public String getBrancos2() {
        return this.linha.substring(301, 318);
    }

    public String getMotivosRejeicao() {
        return this.linha.substring(318, 328);
    }

    public String getBrancos3() {
        return this.linha.substring(328, 394);
    }

    @Override
    public int getSequencial() {
        return Integer.parseInt(this.linha.substring(394, 400));
    }
}