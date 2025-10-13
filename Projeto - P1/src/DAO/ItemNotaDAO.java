package DAO;

import ItemNota.ItemNota;
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
 * Classe criada para realizar a camada de persistencia com o Banco de Dados referente aos Itens da Nota
 * @author Augusto Andrade da Silva
 * @since Classe criada em 29/09/2025
 */
public class ItemNotaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ItemNotaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void cadastrar(ItemNota itemNota){
        String sql = "INSERT INTO itemNota (itm_quantidade, pro_codigo, nta_codigo) VALUES (?, ?, ?);";
        try{

            PreparedStatement stmt = conn.prepareStatement(/*Comando SQL: */ sql);
            stmt.setInt(1, itemNota.getQuantidade());
            stmt.setInt(2, itemNota.getPro_Codigo().getCodigo());
            stmt.setInt(3, itemNota.getNta_Codigo().getCodigo());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Item da Nota Cadastrado com sucesso!!", "Cadastro", 1);
            
            String sqlSelect = "SELECT tip_codigo FROM notas WHERE nta_codigo = ?;";
            try{
                PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                stmtSelect.setInt(1, itemNota.getNta_Codigo().getCodigo());
                ResultSet rs = stmtSelect.executeQuery();
                rs.first();
                
                //JOptionPane.showMessageDialog(null, "Busca pelo tipo de Nota Realizada com sucesso!!", "Busca Concluida", 1);
                String sqlUpdate;
                
                /*String sqlSelectQuantidade = "SELECT pro_quantidade FROM produto WHERE pro_codigo = ?;";
                try{
                    PreparedStatement stmtSelectQuantidade = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    stmtSelectQuantidade.setInt(1, itemNota.getPro_Codigo().getCodigo());
                    ResultSet rsQuantidade = stmtSelectQuantidade.executeQuery();
                    rs.first();
                    
                } catch(SQLException ex){
                    System.out.println("Erro ao pesquisar a quantidade do produto!! "+ ex.getMessage());
                }*/
                
                if(rs.getInt("tip_codigo") == 1){
                    sqlUpdate = "UPDATE produto SET pro_qtdestoque = pro_qtdestoque + ? WHERE pro_codigo = ?;";
                    JOptionPane.showMessageDialog(null, "Busca pelo tipo de Nota Realizada com sucesso!! 3", "Busca", 1);
                    
                } else{
                    sqlUpdate = "UPDATE produto SET pro_qtdestoque = pro_qtdestoque - ? WHERE pro_codigo = ?;";
                    //JOptionPane.showMessageDialog(null, "Busca pelo tipo de Nota Realizada com sucesso!! 4", "Busca", 1);
                    
                }
                try{
                    PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    stmtUpdate.setInt(1, itemNota.getQuantidade());
                    stmtUpdate.setInt(2, itemNota.getPro_Codigo().getCodigo());
                    
                    stmtUpdate.execute();
                    
                    JOptionPane.showMessageDialog(null, "Quantidade no Produto Atualizada com Sucesso!!", "Atualização", 1);
                } catch(SQLException ex){
                    System.out.println("Erro ao Atualizar a quantidade do produto!! "+ ex.getMessage());
                }
            } catch(SQLException ex){
                System.out.println("Erro ao Consultar o tipo de nota!! "+ ex.getMessage());
            }
        }catch(SQLException ex){
            System.out.println("Erro ao Cadastrar o Item da Nota!! "+ ex.getMessage());
        }
        
    }//FIM do método 'cadastrar'
    
    public List<ItemNota> getItemNotas(){
        String sql = "SELECT itm_codigo, itm_quantidade, pro_nome, nta_codigo "
                + "FROM itemNota "
                    + "INNER JOIN produto USING(pro_codigo) "
                    + "INNER JOIN notas USING (nta_codigo)"
                + "ORDER BY itm_codigo;";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            List<ItemNota> listaItemNotas = new ArrayList(); //Preparo uma lista de objetos que vou armazenar a consulta
            
            //Percorre rs e salva as informações dentro de um objeto ItemNota e depois adiciona na lista
            while (rs.next()){
                ItemNota itemnota = new ItemNota();
                itemnota.setCodigo(rs.getInt("itm_codigo"));
                itemnota.setQuantidade(rs.getInt("itm_quantidade"));
                itemnota.setPro_Nome(rs.getString("pro_nome"));
                itemnota.setNota_Codigo(rs.getInt("nta_codigo"));
                
                listaItemNotas.add(itemnota);
            }
            return listaItemNotas;
        } catch(SQLException ex){
            System.out.println("Erro ao consultar todos os Itens das Notas: "+ ex.getMessage());
            return null;
        }
    } //FIM do método 'getClientes'
    
}// Fim da Classe
