package com.example.laudr.appdeeventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvEventos = (ListView) findViewById(R.id.lvEventos);

        lvEventos.setOnItemClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/app_eventos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EventoService service = retrofit.create(EventoService.class);

        Call<List<Evento>> eventos = service.getEventos();

        eventos.enqueue(new Callback<List<Evento>>() {

            @Override
            public void onResponse(Call<List<Evento>> call,
                                   Response<List<Evento>> response) {
                if (response.isSuccessful()) {

                    List<Evento> lista = response.body();

                    EventosAdapter adapter = new EventosAdapter(
                            getApplicationContext(), lista, "http://10.0.2.2/app_eventos/fotos/");

                    lvEventos.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {

            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Evento evento = (Evento)parent.getItemAtPosition(position);

      //  Toast.makeText(this, "Você clicou no carro " + evento.getNome(), Toast.LENGTH_LONG).show();

        Intent it = new Intent(this, ConviteActivity.class);
        it.putExtra("id", evento.getId());
        it.putExtra("nome", evento.getNome());
        it.putExtra("local", evento.getLocal());
        it.putExtra("atracao", evento.getAtracao());
        it.putExtra("data", evento.getPreco());
        it.putExtra("detalhes", evento.getDetalhes());
        it.putExtra("preco" , evento.getPreco());

        startActivity(it);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = new Intent(this, PesquisaActivity.class);

        startActivity(it);
        return super.onOptionsItemSelected(item);
    }
}
