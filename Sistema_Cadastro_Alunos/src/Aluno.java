/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe Criada para...
 * @author Augusto Andrade da Silva
 * @since CLasse criada em 08/09/2025
 */
public class Aluno {
    public String nome;
    public int idade;
    public String curso;
    
    public Aluno (String nome, int idade, String curso){
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    } //Fim do Construtor
    
    public Object[] obterDados(){
        return new Object[] {nome, idade, curso};
    } //Fim do método "obterDados"
    
}// Fim da classe
