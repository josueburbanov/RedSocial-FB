
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
    
    private String nombre;
    private String correo;
    private String clave;
    private String genero;
    private String fecha_nacimiento;
    private String info_adicional;
    private ArrayList<Grupo>grupos;
    private ArrayList<Usuario>amigos;
    private ArrayList<Evento>eventos;
    private ArrayList<Solicitud>solicitudes;
    private ArrayList<Publicacion>publicaciones;

    
    
    
    
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
    
    public void limpiarAmigosRepetidos(){
        amigos.stream().distinct().collect(Collectors.toList());
    }
    
    public void AgregarGrupo(Grupo nuevo)
    {
        if(!grupos.contains(nuevo))
        {
            grupos.add(nuevo);
            System.out.println("<<<< Usted se ha unido al grupo >>>>> ");
        }
        else
        {
            System.out.println("<<<< Usted ya pertenece a este grupo >>>>> ");
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
    
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
    { 
  
        // Create a new ArrayList 
        ArrayList<T> newList = new ArrayList<T>(); 
  
        // Traverse through the first list 
        for (T element : list) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) { 
  
                newList.add(element); 
            } 
        } 
  
        // return the new list 
        return newList; 
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getInfo_adicional() {
        return info_adicional;
    }

    public void setInfo_adicional(String info_adicional) {
        this.info_adicional = info_adicional;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

}


