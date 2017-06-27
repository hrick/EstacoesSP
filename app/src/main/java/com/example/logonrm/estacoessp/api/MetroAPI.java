package com.example.logonrm.estacoessp.api;

import com.example.logonrm.estacoessp.model.Estacoes;
import com.example.logonrm.estacoessp.model.Linha;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by logonrm on 26/06/2017.
 */

public interface MetroAPI {

    @GET("/linhas")
    Call<List<Linha>> getLinhas();

    @GET("{linhas}/estacoes")
    Call<List<Estacoes>> getEstacoes(@Path("estacoes") String linha);
}
