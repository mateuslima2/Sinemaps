package com.example.casa.sinemaps.Entidades;

public class SineDetalhado {
    private String codPosto;
    private String nome;
    private String entidadeConveniada;
    private String municipio;
    private String uf;
    private String cep;
    private String latitude;
    private String longitude;
    private String bairro;
    private String endereco;
    private String telefone;

    public SineDetalhado() {

    }

    public String getCodPosto() {
        return codPosto;
    }

    public void setCodPosto(String codPosto) {
        this.codPosto = codPosto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEntidadeConveniada() {
        return entidadeConveniada;
    }

    public void setEntidadeConveniada(String entidadeConveniada) {
        this.entidadeConveniada = entidadeConveniada;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "\n Sine\n" +
                "\n Código do Posto: " + codPosto + '\'' +
                "\n Nome: " + nome + '\'' +
                "\n Entidade Conveniada: " + entidadeConveniada + '\'' +
                "\n Endereço: " + endereco + '\'' +
                "\n Bairro: " + bairro + '\'' +
                "\n Cep: " + cep + '\'' +
                "\n Telefone: " + telefone + '\'' +
                "\n Município: " + municipio + '\'' +
                "\n UF: " + uf + '\'' +
                "\n Latitude: " + latitude +
                "\n Longitude: " + longitude;
    }
}