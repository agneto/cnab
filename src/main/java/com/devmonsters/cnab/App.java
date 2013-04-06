package com.devmonsters.cnab;

import com.devmonsters.cnab.arquivoretorno.registro.RegistroCaixa;
import com.devmonsters.cnab.arquivoretorno.trailer.Trailer;
import com.devmonsters.cnab.bancos.Bancos;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
    private static final Logger log = Logger.getLogger(App.class);

    public static void main(final String[] args) {
        try {
            final List<String> linhas = FileUtils.readLines(new File("/Users/abilio/Downloads/R19011.RET.txt"), "UTF8");
            int count = 0;
            for (final String linha : linhas) {
                if (linha.startsWith("1")) {
                    final Registro registro = CnabFactory.getInstanceRegistro(Bancos.CEF, linha);
                    if (registro instanceof RegistroCaixa) {
                        System.out.println(((RegistroCaixa) registro).getFloatNegociado());
                        count++;
                    }
                } else if (linha.startsWith("9")) {
                    final Trailer trailer2 = CnabFactory.getInstanceTrailer(Bancos.CEF, linha);
                    System.out.println(trailer2.getCodigoRetorno());
                }
            }
            System.out.println(count);
        } catch (final IOException e) {
            App.log.error("Erro ao ler o arquivo ", e);
        }
    }
}