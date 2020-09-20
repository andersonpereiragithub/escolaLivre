/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model.db.dao.impl;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Aluno;
import br.vianna.escola.model.Disciplina;
import br.vianna.escola.model.EStatus;
import br.vianna.escola.model.Matricula;
import br.vianna.escola.model.PKMatricula;
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
public class MatriculaDAO implements IGenericsDAO<Matricula, PKMatricula>{

    @Override
    public void inserir(Matricula obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Matricula obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Matricula obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matricula buscarPeloId(PKMatricula key) throws NotConnectionException, SQLException {
        Connection c = ConnectionSingleton.getConnection();
        
        String sql = "SELECT * FROM matricula m "
                + "INNER JOIN aluno a on (a.id_aluno = m.aluno_fk) "
                + "INNER JOIN disciplina d on(d.id_displina = m.disciplina_fk) "
                + "WHERE aluno_fk = ? AND disciplina_fk = ? ";
        
        PreparedStatement st = c.prepareStatement(sql);
        
        st.setInt(1, key.getIdAluno());
        st.setInt(2, key.getIdDisciplina());
        
        ResultSet rs = st.executeQuery();
        
        Matricula mat = null;
        if(rs.next()){
            Aluno a = new Aluno (rs.getInt("aluno_fk"),
                rs.getString("registro"),
            rs.getString("nome"),
            rs.getInt("idade"));
            
            Disciplina d = new Disciplina(rs.getInt("disciplina_fk"),
                    rs.getString("nome"),
                    rs.getInt("ano"),
                    rs.getInt("semestre"),
                    rs.getInt("carga_horaria"), null);
         
            mat = new Matricula(key, a, d, rs.getDouble("nota_final"),
            rs.getInt("frequencia"), 
            EStatus.valueOf(rs.getString("status")));
            
            return mat;
        }else{
            return mat;
        }
    }

    @Override
    public ArrayList<Matricula> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
