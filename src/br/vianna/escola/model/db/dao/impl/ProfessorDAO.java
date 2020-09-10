/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model.db.dao.impl;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Professor;
import br.vianna.escola.model.db.conexao.ConnectionSingleton;
import br.vianna.escola.model.db.dao.IGenericsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class ProfessorDAO implements IGenericsDAO<Professor, Integer> {

    @Override
    public void inserir(Professor p) throws NotConnectionException, SQLException {

        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO pessoa (idade, nome) "
                + "VALUE (?, ?)";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, p.getIdade());
        st.setString(2, p.getNome());

        st.executeUpdate();

        ResultSet rs = st.executeQuery("select LAST_INSERT_ID();");
        rs.next();
        int idProf = rs.getInt(1); //Estas 3 linhas pega o id que acabou de ser inserido no banco        

        String sqlProf = "INSERT INTO professor"
                + "(id, valor_hora_aula, login, senha) "
                + "VALUE(?, ?, ?, ?);";

        st = c.prepareStatement(sqlProf);

        st.setInt(1, idProf);
        st.setDouble(2, p.getValorHoraAula());
        st.setString(3, p.getLogin());
        st.setString(4, p.getSenha());

        st.executeUpdate();
    }

    @Override
    public void alterar(Professor obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE pessoa "
                + "SET "
                + "idade = ?, "
                + "nome = ? "
                + "WHERE id = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdade());
        st.setString(2, obj.getNome());
        st.setInt(3, obj.getId());

        st.executeUpdate();

        String sqlProf = "UPDATE professor "
                + "SET "
                + "valor_hora_aula = ? "
                + "login = ? "
                + "senha = ? "
                + "WHERE id = ?";
        

        st = c.prepareStatement(sqlProf);

        st.setDouble(1, obj.getValorHoraAula());
        st.setString(2, obj.getLogin());
        st.setString(3, obj.getSenha());
        st.setInt(4, obj.getId());

        st.executeUpdate();
    }

    @Override
    public void apagar(Professor obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professor buscarPeloId(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Professor> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
