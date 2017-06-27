package com.example.logonrm.estacoessp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by logonrm on 26/06/2017.
 */

public class Estacoes {

    @SerializedName("area_construida_m_2")
    private String areaM2;
    @SerializedName("capacidade_passageiro_hora_pico")
    private String capacidadePico;
    private String nome;
    private String endereco;
    private String latitude;
    private String longitude;
    private String inauguracao;
    private Linha linha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getInauguracao() {
        return inauguracao;
    }

    public void setInauguracao(String inauguracao) {
        this.inauguracao = inauguracao;
    }

    public String getCapacidadePico() {
        return capacidadePico;
    }

    public void setCapacidadePico(String capacidadePico) {
        this.capacidadePico = capacidadePico;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public String getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(String areaM2) {
        this.areaM2 = areaM2;
    }
}
