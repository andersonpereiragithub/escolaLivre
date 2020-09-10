/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.vianna.escola.exception.NotConnectionException;
import br.vianna.escola.model.Professor;
import br.vianna.escola.model.db.conexao.ConnectionSingleton;
import br.vianna.escola.model.db.dao.impl.ProfessorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class Teste {

    public static void main(String[] args) {

 //       try{
          //       Scanner ler = new Scanner(System.ini);
//         try{
//                ler.nextInt();
                
//        }catch (Exception e){
//          System.out.println("Deu Ruim!!!");
//        }
    
 //               Connection c = ConnectionSingleton.getConnection();
    
        
 //       } catch (NotConnectionException ex){
//            System.out.println("Erro ao Conecta!!!");
//        }
//       System.out.println("Conectou");

        Professor p = new Professor(6, 40, "ac", "abc", "Anderson Xanda", 27);

        try {
            new ProfessorDAO().inserir(p);
            
        } catch (NotConnectionException | SQLException ex) {
            System.out.println("Erro ao Conectar!!!!" + ex.getMessage());
        }
    }
}
