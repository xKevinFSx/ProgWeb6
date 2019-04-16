package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaLocaisActivity extends AppCompatActivity {

    private LocalizacaoDAO localizacaoDAO;
    private RecyclerView locationsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_locais);
        localizacaoDAO = new  LocalizacaoDAO(this);
        ArrayList<Localizacao> localizacoes = (ArrayList<Localizacao>) localizacaoDAO.lista();
        locationsRecyclerView = findViewById(R.id.localizacoesRecyclerView);
        locationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        LocaisRecyclerViewAdapter adapter = new LocaisRecyclerViewAdapter(localizacoes);
        locationsRecyclerView.setAdapter(adapter);
//        locationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Localizacao location = locations.get(position);
//
//                Uri gmmIntentUri = Uri.parse(String.format("geo:%f,%f", location.getLongitude(), location.getLatitude()));
//
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                startActivity(mapIntent);
//            }
//        });
    }
}
