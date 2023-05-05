package br.com.apiCEP.principal;

import br.com.apiCEP.modelos.Endereco;
import br.com.apiCEP.serviços.CEPClient;
import br.com.apiCEP.serviços.CEPListWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class buscaCEP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Endereco> ceps = new ArrayList<>();
        String busca = "";

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um CEP para busca: ");
            busca = sc.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            CEPClient buscador = new CEPClient();

            Endereco endereco= null;
            try {
                endereco = buscador.search(busca);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Não consegui encontrar o endereco!");

            }
            ceps.add(endereco);
        }

        CEPListWriter.writeToFile(ceps, "ceps");

    }
}
