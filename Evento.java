
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
public class Evento implements Serializable {
    private String titulo;
    private String hora;
    private String fecha;
    private String lugar;
    private String descripcion;
    private ArrayList<Usuario>interesados;
    private ArrayList<Usuario>asistiran;

    
    

    public Evento() {
      titulo="";
      hora="";
      fecha="";
      lugar="";
      descripcion="";
      interesados=new ArrayList();
      asistiran= new ArrayList();
    }
    
    public void AddAssit(Usuario assit)
    {
        if(!asistiran.contains(assit))
        {
            asistiran.add(assit);
            System.out.println("<<< Confirmado >>>>");
        }
        else
        {
            System.out.println("<<< Usted ya asistirá al evento >>>>");
        }
    }
    
    public void AddInteres(Usuario interest)
    {
        if(!interesados.contains(interest))
        {
            interesados.add(interest);
            System.out.println("<<< Confirmado >>>>");
        }
        else
        {
            System.out.println("<<< Usted ya se interesó en el evento >>>>");
       
        }
    }

    @Override
    public String toString() {
        String asistira="";
        String interest="";
        for(Usuario aux: asistiran)
        {
           asistira=asistira+"\t"+aux.getNombre()+" ,"; 
        }
        for(Usuario aux: interesados)
        {
           interest=interest+"\t"+aux.getNombre(); 
        }
        return "\nEVENTO" + "\nTitulo: " + titulo + "\nHora: " + hora + "\nFecha: " + fecha + "\nLugar: " + lugar + "\nDescripcion: " + descripcion +"\n\nAsistiran: "+asistira+"\nInteresados: "+interest;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Usuario> getInteresados() {
        return interesados;
    }

    public void setInteresados(ArrayList<Usuario> interesados) {
        this.interesados = interesados;
    }

    public ArrayList<Usuario> getAsistiran() {
        return asistiran;
    }

    public void setAsistiran(ArrayList<Usuario> asistiran) {
        this.asistiran = asistiran;
    }
    
    
}
