
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ProdutoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ProdutoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrar(Produto produto){
        String sql = "INSERT INTO produto (pro_nome, pro_desc, pro_precovenda, pro_qtdestoque) VALUES (?, ?, ?, ?);";
        try{
            PreparedStatement stmt = conn.prepareStatement(/*Comando SQL: */ sql);
            stmt.setInt(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDesc());
            stmt.setFloat(4, produto.getPrecoVenda());
            stmt.setInt(5, produto.getQtdEstoque());
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao Cadastrar o produto!! "+ ex.getMessage());
        }
    }//FIM do método 'cadastro'
    
    public void alterar(Produto produto){
        String sql = "UPDATE produto SET pro_nome = ?, pro_desc = ?, pro_precovenda = ?, pro_qtdestoque = ? WHERE pro_codigo = ?;";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(/*Comando SQL: */ sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDesc());
            stmt.setFloat(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQtdEstoque());
            stmt.setInt(5, produto.getCodigo());
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao alterar o produto!! "+ ex.getMessage());
        }
    }//FIM do método 'alterar'
}// Fim da Classe
