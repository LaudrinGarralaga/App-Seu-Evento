package com.example.laudr.appdeeventos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by laudr on 10/11/2017.
 */


public class EventosAdapter extends BaseAdapter {

    private Context ctx;
    private List<Evento> eventos;
    private String pathFoto;

    public EventosAdapter(Context ctx, List<Evento> eventos, String pathFoto) {
        this.ctx = ctx;
        this.eventos = eventos;
        this.pathFoto = pathFoto;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Evento evento = eventos.get(position);

        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_evento, null);

        ImageView imgFoto = (ImageView)linha.findViewById(R.id.imgFoto);
        TextView txtNome = (TextView)linha.findViewById(R.id.txtNome);
        TextView txtLocal = (TextView)linha.findViewById(R.id.txtLocal);
        TextView txtAtracao = (TextView)linha.findViewById(R.id.txtAtracao);
        TextView txtPreco = (TextView)linha.findViewById(R.id.txtPreco);


        Picasso.with(ctx).load(pathFoto+evento.getId()+".jpg").into(imgFoto);
        txtNome.setText(evento.getNome());
        txtLocal.setText(evento.getLocal());
        txtAtracao.setText(evento.getAtracao());

        NumberFormat nfBr = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        txtPreco.setText(nfBr.format(evento.getPreco()));

        return linha;
    }

}
