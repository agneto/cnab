package com.google.code.cnab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.code.cnab.arquivoretorno.Leitor;
import com.google.code.cnab.arquivoretorno.header.Header;
import com.google.code.cnab.arquivoretorno.registro.Registro;
import com.google.code.cnab.arquivoretorno.trailer.Trailer;

public class App {
    private static final Logger log = Logger.getLogger(App.class);

    public static void main(final String[] args) {
        Header header;
        Trailer trailer;
        List<Registro> registros;

        try (InputStream is = new FileInputStream(new File("/Users/abilio/Downloads/R19011.RET.txt"))) {
            final Leitor leitor = new Leitor(is);
            registros = leitor.getRegistros();
            final Iterator<Registro> i = registros.iterator();
            while (i.hasNext()) {
                final Registro r = i.next();
                System.out.println(String.format("Numero Sequencial %d, Agencia Cobradora %s", r.getSequencial(), r.getAgenciaCobradora()));
            }
            header = leitor.getHeader();
            System.out.println(header.getNomeBanco());
            trailer = leitor.getTrailer();
            System.out.println(trailer.getSequencial());
        } catch (final FileNotFoundException e) {
            log.error("Arquivo nao encontrado ", e);
        } catch (final IOException e) {
            log.error("Erro ao ler o arquivo ", e);
        }
    }
}