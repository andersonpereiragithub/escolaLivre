/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.escola.model.db.conexao;

import br.vianna.escola.exception.NotConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ander
 */
public class ConnectionSingleton {

    private static Connection conexao;

    private ConnectionSingleton() {
    }

    public static Connection getConnection() throws NotConnectionException {
        try {
            if (conexao == null || conexao.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");

                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola_java", "root", "x1a2n3d4a5");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NotConnectionException();
        }
        return conexao;
    }
}
