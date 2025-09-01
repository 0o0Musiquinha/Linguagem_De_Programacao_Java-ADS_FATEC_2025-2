/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula01;

/**
 *
 * @author 2830482411021
 */
public class Aula01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //-------------------->Carro
        System.out.println("-------------------->Carro");
        System.out.println("Hello World!!");
        
        Carro c1 = new Carro();
        c1.anofabricacao = 2020;
        c1.modelo = "Corsa";
        System.out.println(c1.modelo);
        System.out.println(c1.anofabricacao);
        
        c1.ligar();
        //System.out.println(c1.getEstado()+"\n"+c1.anofabricacao);
        
        if(c1.getEstado()){
            System.out.println("Carro Ligado!!");
        }
        else{
            System.out.println("Carro Desligado!");
        }
        
        //-------------------->Pessoa
        System.out.println("\n-------------------->Pessoa");
        Pessoa p1 = new Pessoa();
        p1.nome = "Astolfo";
        Pessoa p2 = new Pessoa();
        p2.nome = "Marcia";
        
        System.out.println("O nome da pessoa 1 é "+p1.nome);
        System.out.println("O nome da pessoa 1 é "+p2.nome);
        
        
        //-------------------->Livro
        System.out.println("\n-------------------->Livro");
        Livro livro1 = new Livro();
        livro1.titulo = "Jurassic Park";
        livro1.autor = "Michael Crichton";
        livro1.anopublicacao = 1990;
        
        Livro livro2 = new Livro();
        livro2.titulo = "Percy Jackson: O Ladrão de Raios";
        livro2.autor = "Rick Riordan";
        livro2.anopublicacao = 2005;
        
        
        System.out.println("O livro '"+livro1.titulo+"' Foi publicado em "+livro1.anopublicacao+" por "+livro1.autor);
        System.out.println("O livro '"+livro2.titulo+"' Foi publicado em "+livro2.anopublicacao+" por "+livro2.autor);
        
    }
    
}
