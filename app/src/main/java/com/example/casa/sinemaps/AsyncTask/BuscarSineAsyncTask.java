package com.example.casa.sinemaps.AsyncTask;

import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.casa.sinemaps.Entidades.SineDetalhado;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BuscarSineAsyncTask extends AsyncTask<String, Void, List<SineDetalhado>> {
    @Override
    protected List<SineDetalhado> doInBackground(String... params){
        List<SineDetalhado> sine = new ArrayList<SineDetalhado>();

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
                sine.add(converterSine(leitor));
            }
            leitor.endArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sine;
    }

    public SineDetalhado converterSine(JsonReader reader) throws IOException {
        String codPosto = "";
        String nome = "";
        String entidadeConveniada = "";
        String municipio = "";
        String uf = "";
        String cep = "";
        String latitude = "";
        String longitude = "";
        String bairro = "";
        String endereco = "";
        String telefone = "";

        SineDetalhado sine = new SineDetalhado();

        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            if (name.equals("codPosto"))
                sine.setCodPosto(reader.nextString());
            else if (name.equals("nome"))
                sine.setNome(reader.nextString());
            else if (name.equals("entidadeConveniada"))
                sine.setEntidadeConveniada(reader.nextString());
            else if (name.equals("endereco"))
                sine.setEndereco(reader.nextString());
            else if (name.equals("bairro"))
                sine.setBairro(reader.nextString());
            else if (name.equals("cep"))
                sine.setCep(reader.nextString());
            else if (name.equals("telefone"))
                sine.setTelefone(reader.nextString());
            else if (name.equals("municipio"))
                sine.setMunicipio(reader.nextString());
            else if (name.equals("uf"))
                sine.setUf(reader.nextString());
            else if (name.equals("lat"))
                sine.setLatitude(reader.nextString());
            else if (name.equals("long"))
                sine.setLongitude(reader.nextString());
            else
                reader.skipValue();
        }
        reader.endObject();
        return sine;
    }

    public void onPostExecute(List<SineDetalhado> result){
        super.onPostExecute(result);
    }

}