package br.com.valcirjr98.makor.model;

public class Cliente {

    private String nome;

    private String CPF;

    private String estado;

    private String municipio;

    private String endereco;

    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, String CPF, String estado, String municipio, String endereco, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.estado = estado;
        this.municipio = municipio;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
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
}
