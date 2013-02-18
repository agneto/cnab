package com.google.code.cnab.arquivoretorno;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.code.cnab.arquivoretorno.header.Header;
import com.google.code.cnab.arquivoretorno.registro.Registro;
import com.google.code.cnab.arquivoretorno.trailer.Trailer;

public class Leitor {
    private static final Logger log = Logger.getLogger(Leitor.class);
    private Header header;
    private Trailer trailer;
    private final List<Registro> registros = new ArrayList<>();

    public Leitor(final InputStream is) {
        String linha = null;
        Registro registro;
        try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("0")) {
                    this.header = new Header(linha);
                } else if (linha.startsWith("1")) {
                    registro = new Registro(linha);
                    this.registros.add(registro);
                } else {
                    this.trailer = new Trailer(linha);
                }
            }
        } catch (final Exception e) {
            log.error("Erro ao fazer a leitura do arquivo ", e);
        }
    }

    public Header getHeader() {
        return this.header;
    }

    public Trailer getTrailer() {
        return this.trailer;
    }

    public List<Registro> getRegistros() {
        return this.registros;
    }
}