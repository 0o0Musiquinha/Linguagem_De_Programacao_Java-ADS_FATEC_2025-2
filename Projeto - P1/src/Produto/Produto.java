package Produto;

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
public class Produto {
    int codigo;
    String nome;
    String desc;
    float precoVenda;
    int qtdEstoque;
    
    //GET
        public int getCodigo(){
            return codigo;
        }

        public String getNome(){
            return nome;
        }

        public String getDesc(){
            return desc;
        }

        public float getPrecoVenda(){
            return precoVenda;
        }
    
        public int getQtdEstoque(){
            return qtdEstoque;
        }
    
    //SET
        public void setCodigo(int codigo){
            this.codigo = codigo;
        }
        
        public void setNome(String nome){
            this.nome = nome;
        }
        
        public void setDesc(String desc){
            this.desc = desc;
        }
        
        public void setPrecoVenda(float precoVenda){
            this.precoVenda = precoVenda;
        }
        
        public void setQtdEstoque(int qtdEstoque){
            this.qtdEstoque = qtdEstoque;
        }
}// Fim da Classe
