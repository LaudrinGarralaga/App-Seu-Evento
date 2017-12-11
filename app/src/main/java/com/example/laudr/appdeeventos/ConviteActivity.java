package com.example.laudr.appdeeventos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
 * Created by laudr on 10/11/2017.
 */

public class ConviteActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgEvento;
    private TextView txtNome;
    private TextView txtPreco;
    private EditText edtConvidado;
    private EditText edtEmail;
    private Button btnEnviar;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convite);

        // associa objetos a suas respectivas views
        imgEvento = (ImageView)findViewById(R.id.imgEvento);
        txtNome = (TextView)findViewById(R.id.txtNome);
        txtPreco = (TextView)findViewById(R.id.txtPreco);
        edtConvidado = (EditText)findViewById(R.id.edtConvidado);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        // registra "ouvinte" para o botão
        btnEnviar.setOnClickListener(this);

        // para obter dados da MainActivity
        Intent it = getIntent();

        // obtém dados passados da MainActivity
        id = it.getIntExtra("id", -1);
        String nome = it.getStringExtra("nome");
        String atracao = it.getStringExtra("atracao");
        String local = it.getStringExtra("local");
        double preco = it.getDoubleExtra("preco", -1);


        // carrega a imagem
        Picasso.with(this).load("http://10.0.2.2/app_eventos/fotos/"+id+".jpg").into(imgEvento);
        // exibe texto no TextView
        txtNome.setText(nome);

        // define formatação do preço
        NumberFormat nfBr = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        // exibe texto no TextView
        txtPreco.setText("Preço: "+nfBr.format(preco));

    }

    @Override
    public void onClick(View v) {
        // obtém conteúdos dos EditText's
        String convidado = edtConvidado.getText().toString();
        String email = edtEmail.getText().toString();


        // verifica se campos de edição estão preenchidos
        // trim(): retira espaços em branco no início e final da string
        if (convidado.trim().isEmpty() || email.trim().isEmpty()) {
            Toast.makeText(this, "Preencha os dados", Toast.LENGTH_LONG).show();
            edtConvidado.requestFocus();   // Joga o foco no edtConvidado
            return;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/app_eventos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EventoService service = retrofit.create(EventoService.class);

        Call<Convite> callConvite = service.gravaConvite(convidado, email, id);

        callConvite.enqueue(new Callback<Convite>() {

            @Override
            public void onResponse(Call<Convite> call, Response<Convite> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),
                            "Ok! Convite Enviado - Cód: " + response.body().getId(),
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Convite> call, Throwable t) {

            }
        });

    }
}

