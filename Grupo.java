
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
public class Grupo implements Serializable{
    public String nombre;
    public String descripcion;
    public ArrayList<Publicación> publicaciones;
    
    public Grupo()
    {
        nombre="";
        descripcion="";
        publicaciones= new ArrayList();
    }
    

    @Override
    public String toString() {
        return "\nGRUPO" + "\nNombre: " + nombre + "\nDescripcion: " + descripcion ;
    }
    
    
}
