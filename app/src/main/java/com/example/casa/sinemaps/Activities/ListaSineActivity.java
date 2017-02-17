package com.example.casa.sinemaps.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.casa.sinemaps.AsyncTask.BuscarSineAsyncTask;
import com.example.casa.sinemaps.AsyncTask.SineAsyncTask;
import com.example.casa.sinemaps.Entidades.Sine;
import com.example.casa.sinemaps.Entidades.SineDetalhado;
import com.example.casa.sinemaps.R;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class ListaSineActivity extends Activity {


    ListView lvSines;
    List<Sine> listaSine;
    ArrayAdapter<Sine> adaptador;

    protected void onCreate(Bundle savedInstanceState){
        Sine sine = new Sine();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sine);

        lvSines = (ListView) findViewById(R.id.listViewSine);
        SineAsyncTask processo = new SineAsyncTask();

        try {
            listaSine = processo.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/").get();
            adaptador = new ArrayAdapter<Sine> (this, android.R.layout.simple_list_item_1, listaSine);
            lvSines.setAdapter(adaptador);

            lvSines.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String codPost = (String) adaptador.getItem(position).getCodPosto();
                    ListView listDet = (ListView) findViewById(R.id.listViewSine);
                    BuscarSineAsyncTask listSineDet = new BuscarSineAsyncTask();
                    try {
                        ArrayAdapter<SineDetalhado> adapter = new ArrayAdapter<SineDetalhado>(view.getContext(), android.R.layout.simple_list_item_1, listSineDet.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/cod/" + codPost).get());
                        listDet.setAdapter(adapter);

                    } catch (InterruptedException|ExecutionException e){
                        e.printStackTrace();
                    }
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}