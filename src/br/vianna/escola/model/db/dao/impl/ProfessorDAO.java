/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model.db.dao.impl;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Disciplina;
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
 * @author ander
 */
public class ProfessorDAO implements IGenericsDAO<Professor, Integer> {

    @Override
    public void inserir(Professor p) throws NotConnectionException, SQLException {

        Connection c = ConnectionSingleton.getConnection();

        String sql = "INSERT INTO pessoa (idade, nome) "
                + "VALUE (?, ?);";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, p.getIdade());
        st.setString(2, p.getNome());

        st.executeUpdate();

        ResultSet rs = st.executeQuery("select LAST_INSERT_ID();");
        rs.next();
        int idProf = rs.getInt(1); //Estas 3 linhas pega o id que acabou de ser inserido no banco        

        String sqlProf = "INSERT INTO professor (id_Professor, valor_hora_aula, login, senha)"
                + "VALUES(?,?,?,?)";

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
                + "WHERE id_Pessoa = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, obj.getIdade());
        st.setString(2, obj.getNome());
        st.setInt(3, obj.getId());

        st.executeUpdate();

        String sqlProf = "UPDATE professor "
                + "SET "
                + "valor_hora_aula = ?, "
                + "login = ?, "
                + "senha = ? "
                + "WHERE id_Professor = ?;";

        st = c.prepareStatement(sqlProf);

        st.setDouble(1, obj.getValorHoraAula());
        st.setString(2, obj.getLogin());
        st.setString(3, obj.getSenha());
        st.setInt(4, obj.getId());

        st.executeUpdate();
    }

    @Override
    public void apagar(Professor obj) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sqlProf = "DELETE FROM Professor "
                + "WHERE id_professor = ?";

        PreparedStatement st = c.prepareStatement(sqlProf);

        st.setInt(1, obj.getId());

        st.executeUpdate();

        String sql = "DELETE FROM Pessoa "
                + "WHERE id_Pessoa = ?;";

        st = c.prepareStatement(sql);
        st.setDouble(1, obj.getId());

        st.executeUpdate();
    }

    @Override
    public Professor buscarPeloId(Integer key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM pessoa p\n"
                + "INNER JOIN professor prof On(p.id_pessoa = prof.id_professor)"
                + "WHERE p.id_pessoa = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setInt(1, key);

        ResultSet rs = st.executeQuery();

        Professor p = null;
        if (rs.next()) {
            p = new Professor(rs.getInt("id_pessoa"),
                    rs.getDouble("valor_hora_aula"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("nome"),
                    rs.getInt("idade"));
            return p;
        } else {
            return p;
        }
    }

    public Professor buscarPeloLoginESenhaId(String login, String senha) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM pessoa p "
                + "INNER JOIN professor prof On(p.id_pessoa = prof.id_professor)"
                + "WHERE prof.login = ? and prof.senha = ?";

        PreparedStatement st = c.prepareStatement(sql);

        st.setString(1, login);
        st.setString(2, senha);

        ResultSet rs = st.executeQuery();

        Professor p = null;
        if (rs.next()) {
            p = new Professor(rs.getInt("id_pessoa"),
                    rs.getDouble("valor_hora_aula"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("nome"),
                    rs.getInt("idade"));
            return p;
        } else {
            return p;
        }
    }

    public ArrayList<Disciplina> getDisciplina(Integer idProfessor) throws NotConnectionException, SQLException {
        return new DisciplinaDAO().getDisciplinasProfessor(idProfessor);
    }

    @Override
    public ArrayList<Professor> buscarTodos() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT * FROM Pessoa p\n"
                + "INNER JOIN Professor prof On (p.id_pessoa = prof.id_professor) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();

        ArrayList<Professor> lista = new ArrayList<>();
        while (rs.next()) {
            Professor p = new Professor(rs.getInt("id_Professor"),
                    rs.getDouble("valor_hora_aula"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("nome"),
                    rs.getInt("idade"));

            lista.add(p);
        }
        return lista;
    }

    @Override
    public int quantidade() throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();

        String sql = "SELECT count(*) FROM Pessoa p "
                + "INNER JOIN Professor prof On (p.id_pessoa = prof.id_professor) ";

        PreparedStatement st = c.prepareStatement(sql);

        ResultSet rs = st.executeQuery();
        rs.next();

        return rs.getInt(1);
    }
}
