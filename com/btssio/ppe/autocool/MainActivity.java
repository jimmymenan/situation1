package com.btssio.ppe.autocool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import adapter.AdapterStation;
import xml.ReadXML;
import metier.Station;
import metier.Voiture;


public class MainActivity extends ActionBarActivity{
    ListView vueStations;
    List<Station> listeStations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReadXML XML = new ReadXML(this);

        vueStations = (ListView) findViewById(R.id.lv_listeStations);
        listeStations = XML.getLesStations();

        AdapterStation customAdapter = new AdapterStation(this, R.layout.liste_stations, listeStations);

        vueStations.setAdapter(customAdapter);

        vueStations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AfficheVoitures.class);
                Integer arg = (int) id;
                Station station = listeStations.get(arg);
                int i = 0;
                intent.putExtra("nomStation", station.getLieu());
                for(Voiture voiture : station.getSesVoitures()){
                    intent.putExtra("idVoiture"+i, voiture.getIdVoiture());
                    intent.putExtra("typeVoiture"+i, voiture.getTypeVoiture());
                    intent.putExtra("nbPlacesVoiture"+i, voiture.getNbPlacesVoiture());
                    intent.putExtra("auto"+i, voiture.getAuto());
                    i++;
                }
                intent.putExtra("total", Integer.toString(i));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
