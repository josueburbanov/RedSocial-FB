
import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
public class Solicitud implements Serializable {

    private Usuario de;
    private boolean aceptada;
    private Usuario para;
    private Date fecha_enviada;

    public Date getFecha_enviada() {
        return fecha_enviada;
    }

    public void setFecha_enviada(Date fecha_enviada) {
        this.fecha_enviada = fecha_enviada;
    }

    public Usuario getPara() {
        return para;
    }

    public void setPara(Usuario para) {
        this.para = para;
    }

    public Solicitud(Usuario de, Usuario para, boolean aceptada, Date fecha_enviada) {
        this.de = de;
        this.aceptada = aceptada;
        this.fecha_enviada = fecha_enviada;
    }

    public Usuario getDe() {
        return de;
    }

    public void setDe(Usuario de) {
        this.de = de;
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }

    @Override
    public String toString() {
        if (para == null) {
            return "\nSolicitud enviada a: " + para.nombre
                    + "\nFecha: " + fecha_enviada;
        } else if (de == null) {
            return "\nSolicitud de: " + de.nombre
                    + "\nFecha: " + fecha_enviada;
        }
        return null;
    }

}
