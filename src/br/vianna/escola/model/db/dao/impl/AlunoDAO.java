/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model.db.dao.impl;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Aluno;
import br.vianna.escola.model.Professor;
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
public class AlunoDAO implements IGenericsDAO<Aluno, Integer>{

    @Override
    public void inserir(Aluno obj) throws NotConnectionException, SQLException {
        
        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO pessoa (idade, nome) "
                + "VALUE (?, ?);";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdade());
        st.setString(2, obj.getNome());

        st.executeUpdate();

        ResultSet rs = st.executeQuery("select LAST_INSERT_ID();");
        rs.next();
        int idAluno = rs.getInt(1); //Estas 3 linhas pega o id que acabou de ser inserido no banco        

        String sqlAluno = "INSERT INTO aluno (id_aluno, registro)"
                + "VALUES(?,?)";

        st = c.prepareStatement(sqlAluno);

        st.setInt(1, idAluno);
        st.setString(2, obj.getRegistro());
        

        st.executeUpdate();
    }

    @Override
    public void alterar(Aluno obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "UPDATE pessoa "
                + "SET "
                + "idade = ?, "
                + "nome = ? "
                + "WHERE id_Pessoa = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdade());
        st.setString(2, obj.getNome());
        st.setInt(3, obj.getId());

        st.executeUpdate();

        String sqlAluno = "UPDATE aluno "
                + "SET "
                + "registro = ? "
                + "WHERE id_Aluno = ?;";

        st = c.prepareStatement(sqlAluno);

        st.setString(1, obj.getRegistro());
        st.setInt(2, obj.getId());

        st.executeUpdate();}

    @Override
    public void apagar(Aluno obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sqlAluno = "DELETE FROM Aluno "
                + "WHERE id_aluno = ?";

        PreparedStatement st = c.prepareStatement(sqlAluno);

        st.setInt(1, obj.getId());

        st.executeUpdate();

        String sql = "DELETE FROM Pessoa "
                + "WHERE id_Pessoa = ?;";

        st = c.prepareStatement(sql);
        st.setDouble(1, obj.getId());

        st.executeUpdate();
    }

    @Override
    public Aluno buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM pessoa p\n"
                + "INNER JOIN aluno a On(p.id_pessoa = a.id_aluno)"
                + "WHERE p.id_pessoa = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        Aluno a = null;
        if (rs.next()) {
            a = new Aluno(rs.getInt("id_pessoa"),
                    rs.getString("registro"),
                    rs.getString("nome"),
                    rs.getInt("idade"));
            return a;
        } else {
            return a;
        }
    }

    @Override
    public ArrayList<Aluno> buscarTodos() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM pessoa p\n"
                + "INNER JOIN aluno a On(p.id_pessoa = a.id_aluno)"
                + "WHERE p.id_pessoa = ?";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        ArrayList<Aluno> lista = new ArrayList<>();
        if (rs.next()) {
            Aluno a = new Aluno(rs.getInt("id_aluno"),
                    rs.getString("registro"),
                    rs.getString("nome"),
                    rs.getInt("idade"));
            lista.add(a);
        }
        return lista;
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(*) FROM Pessoa p "
                + "INNER JOIN Aluno a (p.id_pessoa = a.id_aluno) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();
        
        return rs.getInt(1);
    } 
}
