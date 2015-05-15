package com.btssio.ppe.autocool;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.AdapterVoiture;
import metier.Voiture;


public class AfficheVoitures extends ActionBarActivity {
    ListView vueVoitures;
    List<Voiture> listeVoitures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_voitures);

        Intent intent = this.getIntent();
        setTitle(intent.getStringExtra("nomStation"));

        vueVoitures = (ListView) findViewById(R.id.lv_listeVoiture);

        int total = Integer.parseInt(intent.getStringExtra("total"));

        listeVoitures = new ArrayList<Voiture>();
        for(int i=0; i<total; i++){
            Voiture voiture = new Voiture();
            voiture.setIdVoiture(intent.getStringExtra("idVoiture"+i));
            voiture.setTypeVoiture(intent.getStringExtra("typeVoiture"+i));
            voiture.setNbPlacesVoiture(intent.getStringExtra("nbPlacesVoiture"+i));
            voiture.setAuto(intent.getStringExtra("auto"+i));
            listeVoitures.add(voiture);
        }

        AdapterVoiture customAdapter = new AdapterVoiture(this, R.layout.sous_liste_voitures, listeVoitures);

        vueVoitures.setAdapter(customAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_affiche_voitures, menu);
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
