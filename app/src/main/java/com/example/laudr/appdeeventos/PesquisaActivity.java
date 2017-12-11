package com.example.laudr.appdeeventos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by laudr on 20/11/2017.
 */

public class PesquisaActivity  extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtId = (EditText) findViewById(R.id.edtId);



    }
    public void consultarEvento(View view) {
        String strId = edtId.getText().toString();

        if (strId.trim().isEmpty()) {
            Toast.makeText(this, "Informe o id do evento para consulta", Toast.LENGTH_LONG).show();
            edtId.requestFocus();
            return;
        }

        int id = Integer.parseInt(strId);

        EventoDB eventoDB = new EventoDB(this);

        Evento evento = eventoDB.busca(id);

        if (evento.getId() > 0) {
            edtNome.setText(evento.getNome());

        } else {
            Toast.makeText(this, "Id Não Encontrado", Toast.LENGTH_LONG).show();
            edtId.setText("");
            edtNome.setText("");
            edtId.requestFocus();
            return;
        }
    }

}
