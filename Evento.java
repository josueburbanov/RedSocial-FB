
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

    @Override
    public String toString() {
        return "\nEVENTO" + "\nTitulo: " + titulo + "\nHora: " + hora + "\nFecha: " + fecha + "\nLugar: " + lugar + "\nDescripcion: " + descripcion ;
    }
    
    
}
