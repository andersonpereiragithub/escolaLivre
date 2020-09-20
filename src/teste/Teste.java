/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Aluno;
import br.vianna.escola.model.Professor;
import br.vianna.escola.model.db.dao.impl.AlunoDAO;
import br.vianna.escola.model.db.dao.impl.ProfessorDAO;
import java.sql.SQLException;

/**
 *
 * @author ander
 */
public class Teste {

    public static void main(String[] args) {
  
        //Professor p = new Professor(1, 80, "Delon", "x1a2n3d4a5", "Anderson", 47);
        //Aluno a = new Aluno(4, "Matriculado", "Alexandra", 10);
        try {
            
          //new AlunoDAO().inserir(a);
            //new ProfessorDAO().buscarPeloId(p.getId());
          
            //Professor p1 = new ProfessorDAO().buscarPeloId(3);
            Aluno a = new AlunoDAO().buscarPeloId(5);
            
            System.out.println("" + a.getNome());
            
        } catch (NotConnectionException | SQLException ex) {
            System.out.println("Erro ao Conectar!!!!" + ex.getMessage());
        }
    }
}
