package Nota;

import Cliente.Cliente;
import Fornecedor.Fornecedor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe criada para representar as Notas
 * @author Augusto Andrade da Silva
 * @since Classe criada em 29/09/2025
 */
public class Nota {
    private int codigo;
    private String data;
    private Cliente cli_codigo;
    private Fornecedor for_codigo;
    private int tip_codigo;
    private String tip_nome;
    private String cli_nome;
    private String fun_nomefantasia;
    
    //GET
        public String toString(){
            return this.codigo +" - "+ this.tip_nome +" - "+ this.data;
        }
        
        public int getCodigo(){
            return codigo;
        }
        
        public String getData(){
            return data;
        }
        
        public Cliente getCli_Codigo(){
            return cli_codigo;
        }
        
        public Fornecedor getFor_Codigo(){
            return for_codigo;
        }
        
        public int getTip_Codigo(){
            return tip_codigo;
        }
        
        public String getTip_Nome(){
            return tip_nome;
        }
        
        public String getCli_Nome(){
            return cli_nome;
        }
        
        public String getFun_NomeFantasia(){
            return fun_nomefantasia;
        }
    
    //SET
        public void setCodigo(int codigo){
            this.codigo = codigo;
        }
        
        public void setData (String data){
            this.data = data;
        }
        
        public void setCli_Codigo(Cliente cli_codigo){
            this.cli_codigo = cli_codigo;
        }
        
        public void setFor_Codigo(Fornecedor for_codigo){
            this.for_codigo = for_codigo;
        }
        
        public void setTip_Codigo(int tip_codigo){
            this.tip_codigo = tip_codigo;
        }
        
        public void setTip_Nome(String tip_nome){
            this.tip_nome = tip_nome;
        }
        
        public void setCli_Nome(String cli_nome){
            this.cli_nome = cli_nome;
        }
        
        public void setFun_NomeFantasia(String fun_nomefantasia){
            this.fun_nomefantasia = fun_nomefantasia;
        }
    
}// Fim da Classe
