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
public class Matricula {
    private PKMatricula id;
    private Aluno aluno;
    private Disciplina disciplina;
    private double notaFinal;
    private int frequencia;
    private EStatus status;

    public Matricula() {
    }

    public Matricula(PKMatricula id, Aluno aluno, Disciplina disciplina, double notaFinal, int frequencia, EStatus status) {
        this.id = id;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.notaFinal = notaFinal;
        this.frequencia = frequencia;
        this.status = status;
    }

    public PKMatricula getId() {
        return id;
    }

    public void setId(PKMatricula id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }
    
    
}
