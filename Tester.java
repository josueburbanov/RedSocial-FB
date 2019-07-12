
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, chreadDatae License Headers in Project Properties.
 * To change this template file, chreadDatae Tools | Templates
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
        //Lista que carga todos los usuarios del fichero
        ArrayList <Usuario> Usuarios= new ArrayList();
        
        Usuario user = new Usuario();
        user.nombre="Jimmy";
        user.correo="jimmy.pardo@epn.edu.ec";
        user.genero="Masculino";
        user.fecha_nacimiento="6 de septiembre de 1994";
        user.info_adicional="Me gusta la música ecuatoriana";
        //System.out.println(user);
        
        Usuario user2 = new Usuario();
        user2.nombre="Andrés";
        user2.correo="andres.ramos@epn.edu.ec";
        user2.genero="Masculine";
        user2.fecha_nacimiento="9 de septiembre de 1999";
        user2.info_adicional="Me gusta la música gitana";
        //System.out.println(user2);
        
        
        String path_fichero="C:\\Users\\316\\Documents\\NetBeansProjects\\RedFacebookSocial\\Fichero.dat";
        
        try ( //Escribir en el fichero
            ObjectOutputStream readData = new ObjectOutputStream(new FileOutputStream(path_fichero))) {
            readData.writeObject(user);
            readData.writeObject(user2);
            System.out.println("Guardado");
            readData.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
        try ( //Leer del fichero
                ObjectInputStream writeData = new ObjectInputStream(new FileInputStream(path_fichero))) {
            Object userfichero = writeData.readObject();
                        
            while(userfichero!=null)
            {
                if(userfichero instanceof Usuario)
                {
                    Usuarios.add((Usuario)userfichero);
                    
                }
                userfichero=writeData.readObject();
            }
        
           writeData.close();
        }
        catch (EOFException e1)
        {
            System.out.println ("Leído.....Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        
        //Imprimir Lista
            for(Usuario aux:Usuarios)
            System.out.println(aux);
    }
    
}
