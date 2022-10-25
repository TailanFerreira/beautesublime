package com.example.trabalhofinaltailan;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Webservice extends AsyncTask<Void, Void, Produtos> {
    private final String Produtos;

    public Webservice(String Produtos) {
        this.Produtos = Produtos;
    }

    @Override
    protected Produtos doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        if (this.Produtos != null && this.Produtos.length() == 8) {
            try {
                URL url = new URL("https://lumewebservicetailan.herokuapp.com/produtos.json");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new Gson().fromJson(resposta.toString(), Produtos.class);
    }
}
