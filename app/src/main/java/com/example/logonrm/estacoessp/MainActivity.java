package com.example.logonrm.estacoessp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.logonrm.estacoessp.adapter.LinhasAdapter;
import com.example.logonrm.estacoessp.api.APIUtil;
import com.example.logonrm.estacoessp.api.MetroAPI;
import com.example.logonrm.estacoessp.model.Linha;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvLinhas;
    LinhasAdapter linhasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linhasAdapter = new LinhasAdapter(new ArrayList<Linha>(),this);
        rvLinhas = (RecyclerView) findViewById(R.id.rvLinhas);
        rvLinhas.setLayoutManager(new LinearLayoutManager(this));
        rvLinhas.setHasFixedSize(true);
        rvLinhas.setAdapter(linhasAdapter);

        MetroAPI metroAPI = APIUtil.getCarroAPIService();
        metroAPI.getLinhas().enqueue(new Callback<List<Linha>>() {
            @Override
            public void onResponse(Call<List<Linha>> call, Response<List<Linha>> response) {
                if (response.isSuccessful()){
                    linhasAdapter.updateListLinhas(response.body());
                    linhasAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Linha>> call, Throwable t) {

            }
        });
    }
}
