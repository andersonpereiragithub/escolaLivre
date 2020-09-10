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
import java.util.logging.Level;
import java.util.logging.Logger;

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
                Class.forName("com.mysql.jdbc.Driver");

                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3307/escola_java",
                        "root",
                        "123456");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NotConnectionException();
        }
        return conexao;
    }
}
