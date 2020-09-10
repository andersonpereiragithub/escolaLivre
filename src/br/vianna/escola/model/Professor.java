/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model;

import java.util.ArrayList;

/**
 *
 * @author ander
 */
public class Professor extends Pessoa{
    private double valorHoraAula;
    private String login;
    private String senha;
    private ArrayList<Disciplina> minhasDisciplinas;

    public Professor() {
        this(0, 0, "", "", "", 0);
    }

    public Professor(int id, double valorHoraAula, String login, String senha, String nome, int idade) {
        super(id, nome, idade);
        this.valorHoraAula = valorHoraAula;
        this.login = login;
        this.senha = senha;
        minhasDisciplinas = new ArrayList<>();
    }

    public ArrayList<Disciplina> getMinhasDisciplinas() {
        return minhasDisciplinas;
    }

    public void addMinhasDisciplinas(Disciplina minhasDisciplinas) {
        this.minhasDisciplinas.add(minhasDisciplinas);
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
