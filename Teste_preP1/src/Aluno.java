/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fan25
 */
public class Aluno {
    int ra;
    float media;
    int faltas;
    String sexo;
    String idioma;
    
    
    public int getRa(){
        return ra;
    }
    public float getMedia(){
        return media;
    }
    public int getFaltas(){
        return faltas;
    }
    public String getSexo(){
        return sexo;
    }
    public String getIdioma(){
        return idioma;
    }
    
    public void setRa(int ra){
        this.ra = ra;
    }
    public void setMedia(float media){
        this.media = media;
    }
    public void setFaltas(int faltas){
        this.faltas = faltas;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public void setIdioma(String idioma){
        this.idioma = idioma;
    }
}
