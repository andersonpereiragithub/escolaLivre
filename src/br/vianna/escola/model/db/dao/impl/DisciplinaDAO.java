/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model.db.dao.impl;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Disciplina;
import br.vianna.escola.model.db.conexao.ConnectionSingleton;
import br.vianna.escola.model.db.dao.IGenericsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Delon
 */
public class DisciplinaDAO implements IGenericsDAO<Disciplina, Integer> {

    @Override
    public void inserir(Disciplina obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Disciplina obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Disciplina obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Disciplina buscarPeloId(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Disciplina> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Disciplina> getDisciplinasProfessor(Integer idProfessor) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM disciplina d "
                + "WHERE d.professor_fk = ?; ";

        PreparedStatement st = c.prepareStatement(sql);
        st.setInt(1, idProfessor);

        ResultSet rs = st.executeQuery();

        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        while (rs.next()) {
            Disciplina d = new Disciplina(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("ano"),
                    rs.getInt("semestre"),
                    rs.getInt("carga_horaria"), null);
        }
        return disciplinas;
    }
}
