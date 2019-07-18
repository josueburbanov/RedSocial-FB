
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 */
public class Publicación implements Serializable{
    private String texto;
    private ArrayList<Reacción> reacciones;    

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<Reacción> getReacciones() {
        return reacciones;
    }

    public void setReacciones(ArrayList<Reacción> reacciones) {
        this.reacciones = reacciones;
    }

    
    
    
}
