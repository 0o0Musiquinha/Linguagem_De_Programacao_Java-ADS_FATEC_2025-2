package Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe criada para representar os clientes
 * @author Augusto Andrade da Silva
 * @since Classe criada em 29/09/2025
 */
public class Cliente {
    private int codigo;
    private String nome;
    private String documento;
    private String email;
    private String telefone;
    private String logradouro;
    private String bairro;
    private String municipio;
    private String uf;
    private int codigoTipo;
    private String nomeTipo;
    
    //GET
        public String toString(){
            return this.codigo+" - "+this.nome;
        }
    
        public int getCodigo(){
            return codigo;
        }
        
        public String getNome(){
            return nome;
        }
        
        public String getDocumento(){
            return documento;
        }
        
        public String getEmail(){
            return email;
        }
        
        public String getTelefone(){
            return telefone;
        }
        
        public String getLogradouro(){
            return logradouro;
        }
        
        public String getBairro(){
            return bairro;
        }
        
        public String getMunicipio(){
            return municipio;
        }
        
        public String getUf(){
            return uf;
        }
        
        public int getCodigoTipo(){
            return codigoTipo;
        }
        
        public String getNomeTipo(){
            return nomeTipo;
        }
       
    //SET
        public void setCodigo(int codigo){
            this.codigo = codigo;
        }
        
        public void setNome(String nome){
            this.nome = nome;
        }
        
        public void setDocumento(String documento){
            this.documento = documento;
        }
        
        public void setEmail(String email){
            this.email = email;
        }
        
        public void setTelefone(String telefone){
            this.telefone = telefone;
        }
        
        public void setLogradouro(String logradouro){
            this.logradouro = logradouro;
        }
        
        public void setBairro(String bairro){
            this.bairro = bairro;
        }
        
        public void setMunicipio(String municipio){
            this.municipio = municipio;
        }
        
        public void setUf (String uf){
            this.uf = uf;
        }
        
        public void setCodigoTipo (int codigoTipo){
            this.codigoTipo = codigoTipo;
        }
        
        public void setNomeTipo (String nomeTipo){
            this.nomeTipo = nomeTipo;
        }
        
        
}// Fim da Classe
