package com.example.logonrm.estacoessp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.logonrm.estacoessp.R;
import com.example.logonrm.estacoessp.api.APIUtil;
import com.example.logonrm.estacoessp.model.Linha;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by logonrm on 26/06/2017.
 */

public class LinhasAdapter extends RecyclerView.Adapter<LinhasAdapter.LinhaViewHolder> {

    private List<Linha> linhas;
    private Context context;
    private OnItemClickListener listener;

    public LinhasAdapter(List<Linha> linhas, Context context, OnItemClickListener listener) {
        this.linhas = linhas;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public LinhaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linha_row, parent, false);
        return new LinhaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LinhaViewHolder holder,final int position) {
        Linha linha = linhas.get(position);
        holder.tvCor.setText(linha.getCor());
        holder.tvNumeroLinha.setText(context.getString(R.string.titulo_linha,linha.getNumero()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(linhas.get(position));
            }
        });

        Picasso.with(context)
                .load(APIUtil.BASE_URL + linha.getUrlImagem())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivLinha);
    }

    public void updateListLinhas(List<Linha> linhas){
        this.linhas = linhas;
    }


    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public class LinhaViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivLinha;
        public TextView tvCor;
        public TextView tvNumeroLinha;

        public LinhaViewHolder(View itemView) {
            super(itemView);

            ivLinha = (ImageView) itemView.findViewById(R.id.ivLinha);
            tvCor = (TextView) itemView.findViewById(R.id.tvCor);
            tvNumeroLinha = (TextView) itemView.findViewById(R.id.tvNumeroLinha);
        }
    }
}
