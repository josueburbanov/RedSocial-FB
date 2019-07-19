
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
public class Usuario implements Serializable{
    private static final long serialVersionUID = 2653714788738911068L;
    
    public String nombre;
    public String correo;
    public String clave;
    public String genero;
    public String fecha_nacimiento;
    public String info_adicional;
    public ArrayList<Grupo>grupos;
    public ArrayList<Usuario>amigos;
    public ArrayList<Evento>eventos;
    public ArrayList<Solicitud>solicitudes;
    public ArrayList<Publicación>publicaciones;
    
    
    public Usuario(){
    nombre="";
    clave= "";
    genero="";
    fecha_nacimiento="";
    info_adicional="";
    grupos= new ArrayList();
    amigos = new ArrayList();
    eventos = new ArrayList();
    solicitudes = new ArrayList();
    publicaciones = new ArrayList<>();
     }

    public void aceptarSolicitud(Solicitud solicitud, Usuario amigo){
        if(solicitud.isAceptada()){
            amigos.add(solicitud.getDe());   
            solicitudes.remove(solicitud);
            amigo.amigos.add(this);
        }
        
    }
    

    
    @Override
    public String toString() {
        
        /*String evento ="";
        for(Evento aux: eventos)
        {
            evento= evento+aux.toString();
        }*/
        String aux="********************************************";
        return aux+"\nMI PERFIL\n\n" + "Nombre: " + nombre +"\nCorreo: " + correo +  "\nGenero: " + genero + "\nFecha de nacimiento: " + fecha_nacimiento + "\nSobre mí: " + info_adicional + "\n"+aux ; 
    }

}


