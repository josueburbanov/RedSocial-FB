
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
    private String nombre;
    private String descripcion;
    private ArrayList<Publicacion> publicaciones;

    
    
    
    public Grupo()
    {
        nombre="";
        descripcion="";
        publicaciones= new ArrayList();
    }
    
    public void AgregarPublicacion(Publicacion nueva)
    {
        if(!publicaciones.contains(nueva))
        {
            publicaciones.add(nueva);
            
        }
    }

    @Override
    public String toString() {
        String publi="";
        for(Publicacion aux : publicaciones)
        {
            publi += aux.getDueño().getNombre() +":\t\t"+ aux.getTexto()+"\n" ;
        }
        return "\nGRUPO" + "\nNombre: " + nombre + "\nDescripcion: " + descripcion +"\nPublicaciones:\n" + publi ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
    
}
