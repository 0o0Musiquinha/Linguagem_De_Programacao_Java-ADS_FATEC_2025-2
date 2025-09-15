
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411021
 */
public class Conexao {
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection(/*URL:*/"jdbc:mysql://localhost:3306/bancojava?useTimezone=true&serverTimezone=UTC", /*USER:*/"root", /*PASSWORD:*/"root");
            System.out.println("Conexão realizada com sucesso!");
            return conn;
        }
        catch(Exception e){
            System.out.println("Erro ao conectar no BD"+ e.getMessage());
            return null;
        }
    }
}
