package com.example.casa.sinemaps.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.casa.sinemaps.AsyncTask.SineAsyncTask;
import com.example.casa.sinemaps.Entidades.Sine;
import com.example.casa.sinemaps.R;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class SineRegiaoActivity extends Activity {

    ListView lvSinesProximos;
    List<Sine> sineRegiao;
    ArrayAdapter<Sine> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sine_regiao);

        lvSinesProximos = (ListView) findViewById(R.id.lvSinesProximos);
        SineAsyncTask processo = new SineAsyncTask();

        try {
            sineRegiao = processo.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/latitude/-7.242662/longitude/-35.9716057/raio/100").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        adaptador = new ArrayAdapter<Sine> (this, android.R.layout.simple_list_item_1, sineRegiao);
        lvSinesProximos.setAdapter(adaptador);
    }
}