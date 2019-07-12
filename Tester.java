
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jimmy
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        // TODO code application logic here
        
        Usuario user = new Usuario();
        user.nombre="Jimmy";
        user.correo="jimmy.pardo@epn.edu.ec";
        user.genero="Masculino";
        user.fecha_nacimiento="6 de septiembre de 1994";
        user.info_adicional="Me gusta la música ecuatoriana";
        System.out.println(user);
        
        String path_fichero="C:\\Users\\316\\Documents\\NetBeansProjects\\RedFacebookSocial\\Fichero.txt";
        try ( //Escribir en el fichero
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path_fichero))) {
            oos.writeObject(user);
            System.out.println("Guardado");
        }
        
        try ( //Leer del fichero
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path_fichero))) {
            Usuario userfichero = (Usuario)ois.readObject();
            System.out.println(userfichero);
        }
    }
    
}
