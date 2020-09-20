/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model;

/**
 *
 * @author ander
 */
public class Pessoa {
    private int id_Pessoa;
    private String nome;
    private int idade;

    public Pessoa(int id, String nome, int idade) {
        this.id_Pessoa = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa() {
    }
    
    public int getId() {
        return id_Pessoa;
    }

    public void setId(int id) {
        this.id_Pessoa = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
