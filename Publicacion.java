

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
public class Publicacion implements Serializable{
    private String texto;
    private ArrayList<Reaccion> reacciones = new ArrayList<>();    
    private Usuario dueño;

    public Publicacion(String texto, Usuario dueño) {
        this.texto = texto;
        this.dueño = dueño;
        this.reacciones=new ArrayList();
    }
    
    public void Reaccionar(String op, Usuario reacciono)
    {
        if (op.equals("1")) {
                                                    
         reacciones.add(new Reaccion("Me gusta", reacciono));
         } else if (op.equals("2")) {
                                                    
         reacciones.add(new Reaccion("Me encanta", reacciono));
         } else if (op.equals("3")) {
                                                    
         reacciones.add(new Reaccion("Me divierte", reacciono));
         } else if (op.equals("4")) {
                                                    
         reacciones.add(new Reaccion("Me enoja", reacciono));
         } else if (op.equals("5")) {
                                                    
         reacciones.add(new Reaccion("Me entristece", reacciono));
         }
    
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

    public ArrayList<Reaccion> getReacciones() {
        return reacciones;
    }

    public void setReacciones(ArrayList<Reaccion> reacciones) {
        this.reacciones = reacciones;
    }

    @Override
    public String toString() {
        return "\n*************************************************\n------Publicación:-------\n"+ texto + "\nReacciones=" + reacciones + "\nPublicada por=" + dueño.getNombre() + "\n******************************************";
    }

    
    
    
    
    
}
