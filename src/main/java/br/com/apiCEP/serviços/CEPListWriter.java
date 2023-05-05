package br.com.apiCEP.serviços;

import br.com.apiCEP.modelos.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CEPListWriter {

    static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public static void writeToFile(List<Endereco> ceps, String fileName) {
        FileWriter escrita = null;
        try {
            escrita = new FileWriter(fileName.toString()+".json");
            escrita.write(gson.toJson(ceps));
            escrita.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
