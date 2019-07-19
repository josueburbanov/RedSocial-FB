
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
    
    public void AgregarPublicacion(Publicación nueva)
    {
        if(!publicaciones.contains(nueva))
        {
            publicaciones.add(nueva);
            
        }
    }

    @Override
    public String toString() {
        String publi="";
        for(Publicación aux : publicaciones)
        {
            publi += aux.getDueño().nombre +":\t\t"+ aux.getTexto()+"\n" ;
        }
        return "\nGRUPO" + "\nNombre: " + nombre + "\nDescripcion: " + descripcion +"\nPublicaciones:\n" + publi ;
    }
    
    
}
