package DAO;

import Nota.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe criada para realizar a camada de persistencia com o Banco de Dados referente a Nota
 * @author Augusto Andrade da Silva
 * @since Classe criada em 29/09/2025
 */
public class NotaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public NotaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrar(Nota nota){
        if(nota.getCli_Codigo() != null){
            String sql = "INSERT INTO notas (nta_data, cli_codigo, tip_codigo) VALUES (?, ?, ?);";
            try{

                PreparedStatement stmt = conn.prepareStatement(/*Comando SQL: */ sql);
                LocalDate data = LocalDate.now();
                stmt.setString(1, data.toString());
                stmt.setInt(2, nota.getCli_Codigo().getCodigo());
                stmt.setInt(3, nota.getTip_Codigo());

                stmt.execute();

                JOptionPane.showMessageDialog(null, "Nota Cadastrada com sucesso!!", "Cadastro", 1);
            }catch(SQLException ex){
                System.out.println("Erro ao Cadastrar o Nota!! "+ ex.getMessage());
            }
        } else{
            String sql = "INSERT INTO notas (nta_data, for_codigo, tip_codigo) VALUES (?, ?, ?);";
            try{

                PreparedStatement stmt = conn.prepareStatement(/*Comando SQL: */ sql);
                LocalDate data = LocalDate.now();
                stmt.setString(1, data.toString());
                stmt.setInt(2, nota.getFor_Codigo().getCodigo());
                stmt.setInt(3, nota.getTip_Codigo());

                stmt.execute();

                JOptionPane.showMessageDialog(null, "Nota Cadastrada com sucesso!!", "Cadastro", 1);
            }catch(SQLException ex){
                System.out.println("Erro ao Cadastrar o Nota!! "+ ex.getMessage());
            }
        }
        
    }//FIM do método 'cadastrar'
    
    public List<Nota> getNotas(){
        String sql = "SELECT nta_codigo, nta_data, cli_nome, for_nomefantasia, tip_nome "
                + "FROM notas "
                    + "LEFT JOIN clientes USING(cli_codigo) "
                    + "LEFT JOIN fornecedores USING(for_codigo) "
                    + "INNER JOIN tipoNota USING (tip_codigo);";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<Nota> listaNotas = new ArrayList(); //Preparo uma lista de objetos que vou armazenar a consulta
            
            //Percorre rs e salva as informações dentro de um objeto Nota e depois adiciona na lista
            while (rs.next()){
                Nota nota = new Nota();
                nota.setCodigo(rs.getInt("nta_codigo"));
                nota.setData(rs.getString("nta_data"));
                nota.setCli_Nome(rs.getString("cli_nome"));
                nota.setFun_NomeFantasia(rs.getString("for_nomefantasia"));
                nota.setTip_Nome(rs.getString("tip_nome"));
                
                listaNotas.add(nota);
            }
            return listaNotas;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar todas as Notas: "+ ex.getMessage());
            return null;
        }
    } //FIM do método 'getNotas'
    
}// Fim da Classe
