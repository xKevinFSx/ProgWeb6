package br.usjt.ciclodevidagpsemapas;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LocaisViewHolder extends RecyclerView.ViewHolder {
    public ImageView iconLocalizacaoImageView;
    public TextView latitudeTextView;
    public TextView longitudeTextView;
    public TextView dataTextView;

    public LocaisViewHolder(View itemView) {
        super(itemView);
        iconLocalizacaoImageView = itemView.findViewById(R.id.iconLocalizacaoImageView);
        latitudeTextView = itemView.findViewById(R.id.latitudeTextView);
        longitudeTextView = itemView.findViewById(R.id.longitudeTextView);
        dataTextView = itemView.findViewById(R.id.dataTextView);
    }
}
