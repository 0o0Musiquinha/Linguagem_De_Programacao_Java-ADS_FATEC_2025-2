package DAO;

import Cliente.Cliente;
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
 * Classe criada para realizar a camada de persistencia com o Banco de Dados referente ao Cliente
 * @author Augusto Andrade da Silva
 * @since Classe criada em 29/09/2025
 */
public class ClienteDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrar(Cliente cliente){
        String sql = "INSERT INTO clientes (cli_nome, cli_documento, cli_email, cli_telefone, cli_logradouro, cli_bairro, cli_municipio, cli_uf, tcl_codigo)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            
            PreparedStatement stmt = conn.prepareStatement(/*Comando SQL: */ sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getDocumento());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getLogradouro());
            stmt.setString(6, cliente.getBairro());
            stmt.setString(7, cliente.getMunicipio());
            stmt.setString(8, cliente.getUf());
            stmt.setInt(9, cliente.getCodigoTipo());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!!", "Cadastro", 1);
        }catch(SQLException ex){
            System.out.println("Erro ao Cadastrar o Cliente!! "+ ex.getMessage());
        }
    }//FIM do método 'cadastro'
    
    public List<Cliente> getClientes(){
        String sql = "SELECT cli_codigo, cli_nome, cli_documento, cli_email, cli_telefone, cli_logradouro, cli_bairro, cli_municipio, cli_uf, tcl_nome "
                + "FROM clientes INNER JOIN tipoCliente USING(tcl_codigo);";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Cliente> listaClientes = new ArrayList(); //Preparo uma lista de objetos que vou armazenar a consulta
            
            //Percorre rs e salva as informações dentro de um objeto Produto e depois adiciona na lista
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("cli_codigo"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setDocumento(rs.getString("cli_documento"));
                cliente.setEmail(rs.getString("cli_email"));
                cliente.setTelefone(rs.getString("cli_telefone"));
                cliente.setLogradouro(rs.getString("cli_logradouro"));
                cliente.setBairro(rs.getString("cli_bairro"));
                cliente.setMunicipio(rs.getString("cli_municipio"));
                cliente.setUf(rs.getString("cli_uf"));
                cliente.setNomeTipo(rs.getString("tcl_nome"));
                
                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar todos os clientes: "+ ex.getMessage());
            return null;
        }
    } //FIM do método 'getClientes'
}// Fim da Classe
