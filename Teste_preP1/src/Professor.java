/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fan25
 */
public class Professor {
    int codigo;
    String disciplina;
    float salario;
    char sexo;
    String idioma;
    
    
    public int getCodigo(){
        return codigo;
    }
    public String getDisiplina(){
        return disciplina;
    }
    public float getSalario(){
        return salario;
    }
    public char getSexo(){
        return sexo;
    }
    public String getIdioma(){
        return idioma;
    }
    
    public void SetCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }
    public void setSalario(float salario){
        this.salario = salario;
    }
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    public void setIdioma(String idioma){
        this.idioma = idioma;
    }
}
