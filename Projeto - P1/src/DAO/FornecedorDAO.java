package DAO;

import Fornecedor.Fornecedor;
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
 * Classe criada para realizar a camada de persistencia com o Banco de Dados referente ao Fornecedor
 * @author Augusto Andrade da Silva
 * @since Classe criada em 29/09/2025
 */
public class FornecedorDAO {
    private Conexao conexao;
    private Connection conn;
    
    public FornecedorDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrar(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedores (for_nome, for_nomefantasia, for_cnpj, for_email, for_telefone, for_logradouro, for_bairro, for_municipio, for_uf)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            
            PreparedStatement stmt = conn.prepareStatement(/*Comando SQL: */ sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getNomeFantasia());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getTelefone());
            stmt.setString(6, fornecedor.getLogradouro());
            stmt.setString(7, fornecedor.getBairro());
            stmt.setString(8, fornecedor.getMunicipio());
            stmt.setString(9, fornecedor.getUf());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com sucesso!!", "Cadastro", 1);
        }catch(SQLException ex){
            System.out.println("Erro ao Cadastrar o Fornecedor!! "+ ex.getMessage());
        }
    }//FIM do método 'cadastro'
    
    public List<Fornecedor> getFornecedores(){
        String sql = "SELECT for_codigo, for_nome, for_nomefantasia, for_cnpj, for_email, for_telefone, for_logradouro, for_bairro, for_municipio, for_uf "
                + "FROM fornecedores;";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Fornecedor> listaFornecedores = new ArrayList(); //Preparo uma lista de objetos que vou armazenar a consulta
            
            //Percorre rs e salva as informações dentro de um objeto Produto e depois adiciona na lista
            while (rs.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(rs.getInt("for_codigo"));
                fornecedor.setNome(rs.getString("for_nome"));
                fornecedor.setNomeFantasia(rs.getString("for_nomefantasia"));
                fornecedor.setCnpj(rs.getString("for_cnpj"));
                fornecedor.setEmail(rs.getString("for_email"));
                fornecedor.setTelefone(rs.getString("for_telefone"));
                fornecedor.setLogradouro(rs.getString("for_logradouro"));
                fornecedor.setBairro(rs.getString("for_bairro"));
                fornecedor.setMunicipio(rs.getString("for_municipio"));
                fornecedor.setUf(rs.getString("for_uf"));
                
                listaFornecedores.add(fornecedor);
            }
            return listaFornecedores;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar todos os Fornecedores: "+ ex.getMessage());
            return null;
        }
    } //FIM do método 'getFornecedores'
}// Fim da Classe
