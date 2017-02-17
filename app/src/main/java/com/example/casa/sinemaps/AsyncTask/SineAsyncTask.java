package com.example.casa.sinemaps.AsyncTask;

import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.casa.sinemaps.Entidades.Sine;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SineAsyncTask extends AsyncTask<String, Void, List<Sine>> {
    @Override
    protected List<Sine> doInBackground(String... params){
        List<Sine> listaSine = new ArrayList<Sine>();

        try {
            URL url = new URL(params[0]);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.connect();

            InputStream resposta;
            resposta = conexao.getInputStream();
            JsonReader leitor = new JsonReader (new InputStreamReader(resposta, "UTF-8"));

            leitor.beginArray();
            while (leitor.hasNext()){
                listaSine.add(converterSine(leitor));
            }
            leitor.endArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return listaSine;
    }

    public Sine converterSine(JsonReader reader) throws IOException {
        String codPosto = "";
        String nome = "";
        String entidadeConveniada = "";
        String uf = "";

        Sine sine = new Sine();

        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            if (name.equals("codPosto"))
                sine.setCodPosto(reader.nextString());
            else if (name.equals("nome"))
                sine.setNome(reader.nextString());
            else if (name.equals("entidadeConveniada"))
                sine.setEntidadeConveniada(reader.nextString());
            else if (name.equals("uf"))
                sine.setUf(reader.nextString());
            else
                reader.skipValue();
        }
        reader.endObject();
        return sine;
    }

    public void onPostExecute(List<Sine> result){
        super.onPostExecute(result);
    }

}