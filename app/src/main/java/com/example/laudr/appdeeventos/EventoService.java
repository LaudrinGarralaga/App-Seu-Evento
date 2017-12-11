package com.example.laudr.appdeeventos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by laudr on 10/11/2017.
 */

public interface EventoService {

    // nome do WebService que irá retornar a lista de dados
    @GET("lista_eventos.php")
    Call<List<Evento>> getEventos();

    // no POST deve-se colocar o nome do WebService PHP que irá receber os dados
    // cada campo do WS de inclusão deve ser indicado no Field
    // gravaProposta é o nome dado para a chamada do método
    @FormUrlEncoded
    @POST("insere_convite.php")
    Call<Convite> gravaConvite(@Field("convidado") String convidado,
                                @Field("email") String email,
                                @Field("evento_id") int evento_id);
}
