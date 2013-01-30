package com.google.code.cnab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.code.cnab.arquivoretorno.header.Header;
import com.google.code.cnab.arquivoretorno.registro.Registro;
import com.google.code.cnab.arquivoretorno.trailer.Trailer;

public class App {
    public static void main(final String[] args) {
        // System.out.println("Oi mundo!");
        new App().lerArquivo("/Users/abilio/Downloads/R19011.RET.txt");
    }

    public void lerArquivo(final String caminhoArquivo) {
        String linha = null;

        final List<Registro> registros = new ArrayList<Registro>();
        try (FileReader reader = new FileReader(caminhoArquivo)) {
            try (BufferedReader leitor = new BufferedReader(reader)) {

                while ((linha = leitor.readLine()) != null) {
                    // leitura do header
                    if (linha.startsWith("0")) {
                        new Header(linha);
                        // leitura do registro
                    } else if (linha.startsWith("1")) {
                        final Registro registro = new Registro(linha);
                        registros.add(registro);
                        System.out.println(registro.getInscricaoDaEmpresa());
                        System.out.println(registro.getVencimento() != null ? new SimpleDateFormat("dd/MM/yy").format(registro.getVencimento().getTime()) : "00/00/00");
                        System.out.println(registro.getFormaPagamento());
                        System.out.println(registro.getValorTitulo());
                        System.out.println(registro.getCodigoEmpresa());
                        System.out.println(registro.getFloatNegociado());
                        System.out.println("------------------------------------------------------");
                    } else {
                        final Trailer trailer = new Trailer(linha);
                        System.out.println("CodigoRegistro :: " + trailer.getCodigoRegistro());
                        System.out.println("Sequencial     :: " + trailer.getSequencial());
                    }
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

    }
}