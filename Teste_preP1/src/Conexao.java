
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe criada para ...
 * @author Augusto Andrade da Silva
 * @since Classe criada em 29/09/2025
 */
public class Conexao {
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection(/*URL: */ "jdbc:mysql://localhost:3306/bancojava?useTimezone=true&serverTimezone=UTC",/*USER: */ "root",/*Password: */ "");
            return conn;
        } catch(SQLException ex){
            System.out.println("Erro ao conectar com o Banco de Dados! "+ ex.getMessage());
            return null;
        }
    }
}
