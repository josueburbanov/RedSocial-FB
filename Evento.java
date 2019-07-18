
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
    public String titulo;
    public String hora;
    public String fecha;
    public String lugar;
    public String descripcion;
    public ArrayList<Usuario>interesados;
    public ArrayList<Usuario>asistiran;

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
        }
    }
    
    public void AddInteres(Usuario interest)
    {
        if(!interesados.contains(interest))
        {
            interesados.add(interest);
        }
    }

    @Override
    public String toString() {
        String asistira="";
        String interest="";
        for(Usuario aux: asistiran)
        {
           asistira=asistira+"\t"+aux.nombre+" ,"; 
        }
        for(Usuario aux: interesados)
        {
           interest=interest+"\t"+aux.nombre; 
        }
        return "\nEVENTO" + "\nTitulo: " + titulo + "\nHora: " + hora + "\nFecha: " + fecha + "\nLugar: " + lugar + "\nDescripcion: " + descripcion +"\n\nAsistiran: "+asistira+"\nInteresados: "+interest;
    }
    
    
}
