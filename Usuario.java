
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jimmy
 */
public class Usuario implements Serializable{
    public String nombre;
    public String correo;
    public String clave;
    public String genero;
    public String fecha_nacimiento;
    public String info_adicional;
    
    public Usuario(){
    nombre="";
    clave= "";
    genero="";
    fecha_nacimiento="";
    info_adicional="";
     }

    @Override
    public String toString() {
        String aux="\n\n********************************************\n\n";
        return aux+"MI PERFIL\n\n" + "Nombre: " + nombre +"\nCorreo: " + correo +  "\nGenero: " + genero + "\nFecha de nacimiento: " + fecha_nacimiento + "\nSobre mí: " + info_adicional +aux; 
    }

public static void main(String args){
        Usuario user = new Usuario();
        user.nombre="Jimmy";
        user.correo="jimmy.pardo@epn.edu.ec";
        user.genero="Masculino";
        user.fecha_nacimiento="6 de septiembre de 1994";
        user.info_adicional="Me gusta la música ecuatoriana";
        System.out.println(user);
    }

}


