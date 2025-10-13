package DAO;


import Produto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe criada para realizar a camada de persistencia com o Banco de Dados referente ao Produto
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
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDesc());
            stmt.setFloat(3, produto.getPrecoVenda());
            stmt.setInt(4, produto.getQtdEstoque());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!!", "Cadastro", 1);
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
    
    public List<Produto> getProdutos(){
        String sql = "SELECT * FROM produto;";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Produto> listaProdutos = new ArrayList(); //Preparo uma lista de objetos que vou armazenar a consulta
            
            //Percorre rs e salva as informações dentro de um objeto Produto e depois adiciona na lista
            while (rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("pro_codigo"));
                produto.setNome(rs.getString("pro_nome"));
                produto.setDesc(rs.getString("pro_desc"));
                produto.setPrecoVenda(rs.getFloat("pro_precovenda"));
                produto.setQtdEstoque(rs.getInt("pro_qtdestoque"));
                listaProdutos.add(produto);
            }
            return listaProdutos;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar todos os produtos: "+ ex.getMessage());
            return null;
        }
    } //FIM do método 'getProdutos'
}// Fim da Classe
