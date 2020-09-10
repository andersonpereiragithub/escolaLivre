/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model;

/**
 *
 * @author Delon
 */
public class PKMatricula {
    private int idAluno;
    private int idDisciplina;

    public PKMatricula() {
    }

    public PKMatricula(int idAluno, int idDisciplina) {
        this.idAluno = idAluno;
        this.idDisciplina = idDisciplina;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
}
