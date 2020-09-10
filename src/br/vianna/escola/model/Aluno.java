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
public class Aluno extends Pessoa {
    private String registro;
    private ArrayList<Matricula> matriculas;

    public Aluno() {
        this(0, "", "", 0);
    }

    public Aluno(int id, String matricula, String nome, int idade) {
        super(id, nome, idade);
        this.registro = matricula;
        matriculas = new ArrayList<>();
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void addMatriculas(Matricula matriculas) {
        this.matriculas.add( matriculas );
    }
    
}
