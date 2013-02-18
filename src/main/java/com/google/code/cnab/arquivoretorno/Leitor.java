package com.google.code.cnab.arquivoretorno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.code.cnab.arquivoretorno.header.Header;
import com.google.code.cnab.arquivoretorno.registro.Registro;
import com.google.code.cnab.arquivoretorno.trailer.Trailer;

public class Leitor {
    private Header header;
    private Trailer trailer;
    private final List<Registro> registros = new ArrayList<>();

    public Leitor(final InputStream is) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
            String linha = null;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("0")) {
                    this.header = new Header(linha);
                } else if (linha.startsWith("1")) {
                    this.registros.add(new Registro(linha));
                } else {
                    this.trailer = new Trailer(linha);
                }
            }
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