
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
    private ArrayList<Reacción> reacciones = new ArrayList<>();    
    private Usuario dueño;

    public Publicación(String texto, Usuario dueño) {
        this.texto = texto;
        this.dueño = dueño;
    }
    
    

    public String getTexto() {
        return texto;
    }
    
    public Usuario getDueño()
    {
        return dueño;
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

    @Override
    public String toString() {
        return "\n*************************************************\n------Publicación:-------\n"+ texto + "\nReacciones=" + reacciones + "\nPublicada por=" + dueño.getNombre() + "\n******************************************";
    }

    
    
    
    
    
}
