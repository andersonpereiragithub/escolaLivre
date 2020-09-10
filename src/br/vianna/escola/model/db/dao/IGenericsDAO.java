/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model.db.dao;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Professor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ander
 */
public interface IGenericsDAO<C, K> {

    public void inserir(C obj) throws NotConnectionException, SQLException;

    public void alterar(C obj) throws NotConnectionException, SQLException;

    public void apagar(C obj) throws NotConnectionException, SQLException;

    public C buscarPeloId(K key) throws NotConnectionException, SQLException;

    public ArrayList<C> buscarTodos() throws NotConnectionException, SQLException;

    public int quantidade() throws NotConnectionException, SQLException;
}
