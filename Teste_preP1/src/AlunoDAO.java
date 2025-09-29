
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fan25
 */
public class AlunoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public AlunoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Aluno aluno){
        String sql = "INSERT INTO professor (ra, media, faltas, sexo, idioma) VALUES (?, ?, ?, ?, ?);";
        try{
            
            PreparedStatement stmt = conn.prepareStatement(/*Comando SQL: */sql);
            stmt.setInt(1, aluno.getRa());
            stmt.setFloat(2, aluno.getMedia());
            stmt.setInt(3, aluno.getFaltas());
            stmt.setString(4, aluno.getSexo());
            stmt.setString(5, aluno.getIdioma());
            stmt.execute();
            
        }catch(SQLException ex){
            System.out.println("Falha ao Conectar com o Banco de Dados! "+ ex.getMessage());
            
        }
    }
    
    public void editar(){
        
    }
    
    public int excluir(int x){
        return x;
    }
    
    public int getAluno(int x){
        return x;
    }
}
