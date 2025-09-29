
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411021
 */
public class PessoaDAO /*Data Access Object*/ {
    private Conexao conexao;
    private Connection conn;
    
    public PessoaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir (Pessoa pessoa){
        String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?, ?, ?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(/*String SQL: */ sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            
            stmt.execute();
        }
        catch(SQLException ex){
            System.out.println("Erro ao inserir pesoa: "+ ex.getMessage());
        }
                
    }
    
    public void editar(Pessoa pessoa){
        try{
            String sql = "UPDATE pessoa set nome = ?, sexo = ?, idioma = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.setInt(4, pessoa.getId());
            stmt.execute();
        } catch(SQLException ex){
            System.out.println("Erro ao atualizar pessoa: "+ex.getMessage());
        }
    }
    
    public void excluir (int id){
        try{
            String sql = "DELETE FROM pessoa WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }catch (SQLException ex){
            System.out.println("Erro ao excluir pessoa: "+ ex.getMessage());
        }
    }
    
    public Pessoa getPessoa(int id){
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //1º Parametro é o tipo de ResultSet -
            //ResultSet scroll, ou seja, o cursor se move para frente o para tras.
            /*Este tipo de ResultSet é sensivel às alterações feitas no banco de 
            dados, ou seja, as modificações feitas no banco de dados são refletidas no ResultSet.*/
            //3º parâmetro é sobre os parâmetros de concorrencia - pode ser "read only" ou atualizavel
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(); //Obtenho o retorno da consula e armazeno no ResultSet:
            Pessoa p = new Pessoa(); //Obtenho o retorno da consulta e armazeno no ResultSet
            //Primeiramente, vamos posicionar um objetoque vou armazenar a consulta
            //Em alguns casos, a consulta terá mais de um resultado de retorno
            rs.first();
            p.setID(id);
            p.setNome(rs.getString("nome"));
            p.setSexo(rs.getString("sexo"));
            p.setIdioma(rs.getString("idioma"));
            return p;
        
        } catch(SQLException ex){
            System.out.println("Erro ao consultar pessoa: "+ ex.getMessage());
            return null;
        }
    }
}
