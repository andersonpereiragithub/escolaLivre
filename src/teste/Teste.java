/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Professor;
import br.vianna.escola.model.db.dao.impl.ProfessorDAO;
import java.sql.SQLException;

/**
 *
 * @author ander
 */
public class Teste {

    public static void main(String[] args) {
  
        Professor p = new Professor(1, 40, "ac", "abc", "Anderson", 27);
        try {
            new ProfessorDAO().inserir(p);
            
        } catch (NotConnectionException | SQLException ex) {
            System.out.println("Erro ao Conectar!!!!" + ex.getMessage());
        }
    }
}
