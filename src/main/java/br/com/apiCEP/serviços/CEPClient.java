package br.com.apiCEP.serviços;

import br.com.apiCEP.modelos.Endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CEPClient {

    private static String BASE_URL = "https://viacep.com.br/ws/";

    public Endereco search(String cep) throws IOException, InterruptedException {
        String url = BASE_URL + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(), Endereco.class);

    }
}
