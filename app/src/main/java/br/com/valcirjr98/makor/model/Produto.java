package br.com.valcirjr98.makor.model;

public class Produto {

    private String codigo;

    private String nome;

    private String peso;

    private String preco;

    public Produto(String codigo, String nome, String peso, String preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public Produto(){

    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

   
}
