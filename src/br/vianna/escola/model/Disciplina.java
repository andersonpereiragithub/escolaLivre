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
public class Disciplina {
    private int id;
    private String nome;
    private int ano, semestre, cargaHoraria;
    private Professor professor;
    private ArrayList<Matricula> matriculas;

    public Disciplina() {
        this(0, "", 0, 0, 0, null);
    }

    public Disciplina(int id, String nome, int ano, int semestre, int cargaHoraria, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        matriculas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void addMatriculas(Matricula matriculas) {
        this.matriculas.add( matriculas );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
