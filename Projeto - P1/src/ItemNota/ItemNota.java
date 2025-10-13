package ItemNota;

import Nota.Nota;
import Produto.Produto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe criada para Representar os Itens da Nota
 * @author Augusto Andrade da Silva
 * @since Classe criada em 29/09/2025
 */
public class ItemNota {
    private int codigo;
    private int quantidade;
    private Produto pro_codigo;
    private Nota nta_codigo;
    private String pro_nome;
    private int nota_codigo;
    
    //GET
        public int getCodigo(){
            return codigo;
        }

        public int getQuantidade(){
            return quantidade;
        }

        public Produto getPro_Codigo(){
            return pro_codigo;
        }
        
        public Nota getNta_Codigo(){
            return nta_codigo;
        }
        
        public String getPro_Nome(){
            return pro_nome;
        }
        
        public int getNota_Codigo(){
            return nota_codigo;
        }
    
    //SET
        public void setCodigo(int codigo){
            this.codigo = codigo;
        }
        
        public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
        }
        
        public void setPro_Codigo(Produto pro_codigo){
            this.pro_codigo = pro_codigo;
        }
        
        public void setNta_Codigo(Nota nta_codigo){
            this.nta_codigo = nta_codigo;
        }
        
        public void setPro_Nome(String pro_nome){
            this.pro_nome = pro_nome;
        }
        
        public void setNota_Codigo(int nota_codigo){
            this.nota_codigo = nota_codigo;
        }
}// Fim da Classe
