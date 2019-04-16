package br.usjt.ciclodevidagpsemapas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.List;

public class LocaisRecyclerViewAdapter extends RecyclerView.Adapter<LocaisViewHolder> {

    private List<Localizacao> localizacoes;

    public LocaisRecyclerViewAdapter(List<Localizacao> localizacoes){
        this.localizacoes = localizacoes;
    }

    @NonNull
    @Override
    public LocaisViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View raiz = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new LocaisViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull LocaisViewHolder locaisViewHolder, int i) {
        Localizacao localizacao = localizacoes.get(i);
        locaisViewHolder.iconLocalizacaoImageView.setImageResource(R.drawable.ic_location_on_black_24dp);
        locaisViewHolder.longitudeTextView.setText("Longitude: " + localizacao.getLongitude());
        locaisViewHolder.latitudeTextView.setText("Latitude: " + localizacao.getLatitude());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        locaisViewHolder.dataTextView.setText(dateFormat.format(localizacao.getData()));
    }

    @Override
    public int getItemCount() {
        return localizacoes.size();
    }
}
