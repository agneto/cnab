package com.google.code.cnab.arquivoretorno;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        return this.linha.substring(37, 62).trim();
    }

    public String getNossoNumero() {
        return this.linha.substring(62, 73).trim();
    }

    public String getCodigoRejeicao() {
        return this.linha.substring(79, 82).trim();
    }

    public String getUsoBanco() {
        return this.linha.substring(84, 106).trim();
    }

    public String getCarteira() {
        return this.linha.substring(106, 108).trim();
    }

    public String getCodigoOcorrencia() {
        return this.linha.substring(108, 110).trim();
    }

    public Calendar getDataOcorrencia() {
        final Calendar dataOcorrecncia = Calendar.getInstance();
        try {
            dataOcorrecncia.setTime(new SimpleDateFormat("ddMMyy").parse(this.linha.substring(110, 116).trim()));
            return dataOcorrecncia;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return Calendar.getInstance();
    }

    public String getSeuNumero() {
        return this.linha.substring(116, 126).trim();
    }

    public Calendar getVencimento() {
        final Calendar vencimento = Calendar.getInstance();
        try {
            vencimento.setTime(new SimpleDateFormat("ddMMyy").parse(this.linha.substring(146, 152).trim()));
            return vencimento;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return Calendar.getInstance();
    }

    public BigDecimal getValorTitulo() {
        return new BigDecimal(this.removerZerosAEsquerda(this.linha.substring(152, 165).trim()));
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
        return new BigDecimal(this.removerZerosAEsquerda(this.linha.substring(175, 188).trim()));
    }

    public Integer getTipoLiquidacao() {
        return Integer.parseInt(this.linha.substring(188, 191).trim());
    }

    public FormaPagamento getFormaPagamento() {
        return this.linha.substring(191, 192).equals("1") ? FormaPagamento.DINHEIRO : FormaPagamento.CHEQUE;
    }

    public Integer getFloatNegociado() {
        return Integer.parseInt(this.linha.substring(192, 194).trim());
    }

    public Calendar getDataDebitoTarifa() {
        final Calendar dataDebitoTarifa = Calendar.getInstance();
        try {
            dataDebitoTarifa.setTime(new SimpleDateFormat("ddMMyy").parse(this.linha.substring(196, 200).trim()));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return dataDebitoTarifa;
    }

    public BigDecimal getIof() {
        return new BigDecimal(this.removerZerosAEsquerda(this.linha.substring(214, 227).trim()));
    }

    public BigDecimal getValorAbatimento() {
        return new BigDecimal(this.removerZerosAEsquerda(this.linha.substring(227, 240).trim()));
    }

    public BigDecimal getDescontos() {
        return new BigDecimal(this.removerZerosAEsquerda(this.linha.substring(240, 253).trim()));
    }

    public BigDecimal getValorPrincipal() {
        return new BigDecimal(this.removerZerosAEsquerda(this.linha.substring(253, 266).trim()));
    }

    public BigDecimal getValorJuros() {
        return new BigDecimal(this.removerZerosAEsquerda(this.linha.substring(266, 279).trim()));
    }

    public BigDecimal getValorMulta() {
        return new BigDecimal(this.removerZerosAEsquerda(this.linha.substring(279, 292).trim()));
    }

    public Integer getCodigoMoeda() {
        return Integer.parseInt(this.linha.substring(292, 293));
    }

    public Calendar getDataCredito() {
        final Calendar dataCredito = Calendar.getInstance();
        try {
            dataCredito.setTime(new SimpleDateFormat("ddMMyy").parse(this.linha.substring(293, 299).trim()));
            return dataCredito;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return Calendar.getInstance();
    }

    public Integer getSequencial() {
        return Integer.parseInt(this.linha.substring(394, 400).trim());// 394 a 400
    }

    // substitui os zeros a esquerda por caracter branco
    private String removerZerosAEsquerda(final String numero) {
        final char[] s = numero.toCharArray();
        int count = 0;
        for (final char element : s) {
            if (element == '0') {
                count++;
            } else {
                break;
            }
        }
        return numero.substring(count);
    }
}
