
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, chreadDatae License Headers in Project Properties.
 * To change this template file, chreadDatae Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */
public class Tester {

    //Lista que carga todos los usuarios del fichero
    public static ArrayList<Usuario> Usuarios = new ArrayList();
    public static Usuario usuario_en_sesion = new Usuario();
    public static String path_fichero = "C:\\Users\\josue.burbano\\Documents\\NetBeansProjects\\RedFacebookSocial\\Fichero.dat";
    public static boolean sesion = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here

        LeerArchivo();
        Scanner entradaEscaner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\nFACEBOOK\n\n1.-Login \n2.-Registrarse\n3.-Salir\n");
            String op = entradaEscaner.nextLine();
            opcion = Integer.parseInt(op);
            switch (opcion) {
                case 1:
                    System.out.println("\nLOGIN\nIngrese nombre de usuario:");
                    String auxnombre = entradaEscaner.nextLine();
                    System.out.println("Ingrese contraseña:");
                    String auxclave = entradaEscaner.nextLine();
                    usuario_en_sesion = Login(auxnombre, auxclave);
                    while (sesion == true) {
                        System.out.println("\nMENU\n1.-Ver perfil\n2.-Ver publicaciones\n3.-Grupos\n4.-Eventos\n5.-Amigos\n6.-Cerrar sesión");
                        String opcion2 = entradaEscaner.nextLine();
                        switch (Integer.parseInt(opcion2)) {
                            case 1:
                                System.out.println(usuario_en_sesion);
                                String espera = entradaEscaner.nextLine();
                                break;

                            case 2:
                                //PUBLICACIONES
                                break;

                            case 3:
                                System.out.println("\nGRUPOS\n1.-Ver grupos\n2.-Crear grupo");
                                String opcion4 = entradaEscaner.nextLine();
                                switch (Integer.parseInt(opcion4)) {
                                    case 1:
                                        for (Grupo aux : usuario_en_sesion.grupos) {
                                            System.out.println(aux);
                                            System.out.println("\n1.-Unirse\t2.-Publicar\t3.-Continuar viendo");
                                            String espera2 = entradaEscaner.nextLine();
                                        }
                                        for (Usuario aux : usuario_en_sesion.amigos) {
                                            for (Grupo gv : aux.grupos) {
                                                System.out.println(gv);
                                                System.out.println("\n1.-Unirse\t2.-Publicar\t3.-Continuar viendo");
                                                String espera2 = entradaEscaner.nextLine();

                                            }
                                        }
                                        break;

                                    case 2:
                                        Grupo aux = new Grupo();
                                        System.out.println("Ingrese el titulo:");
                                        aux.nombre = entradaEscaner.nextLine();
                                        System.out.println("Ingrese una descripción:");
                                        aux.descripcion = entradaEscaner.nextLine();
                                        usuario_en_sesion.grupos.add(aux);
                                        break;
                                }
                                break;

                            case 4:
                                System.out.println("\nEVENTOS\n1.-Ver eventos\n2.-Crear evento");
                                String opcion3 = entradaEscaner.nextLine();
                                switch (Integer.parseInt(opcion3)) {
                                    case 1:
                                        for (Evento aux1 : usuario_en_sesion.eventos) {
                                            System.out.println(aux1);
                                            System.out.println("\n1.-Asistire\t2.-Me interesa\t3.-Continuar viendo");
                                            String espera2 = entradaEscaner.nextLine();

                                            if (espera2 == "1") {
                                                aux1.asistiran.add(usuario_en_sesion);
                                            } else if (espera2 == "2") {
                                                aux1.interesados.add(usuario_en_sesion);
                                            }
                                        }

                                        for (Usuario aux2 : usuario_en_sesion.amigos) {
                                            for (Evento ev : aux2.eventos) {
                                                System.out.println(ev);
                                                System.out.println("\n1.-Asistire\t2.-Me interesa\t3.-Continuar viendo");
                                                String espera2 = entradaEscaner.nextLine();
                                                if (espera2 == "1") {
                                                    ev.asistiran.add(usuario_en_sesion);
                                                } else if (espera2 == "2") {
                                                    ev.interesados.add(usuario_en_sesion);
                                                }
                                            }
                                        }

                                        break;

                                    case 2:
                                        Evento aux3 = new Evento();
                                        System.out.println("Ingrese el titulo:");
                                        aux3.titulo = entradaEscaner.nextLine();
                                        System.out.println("Ingrese el lugar:");
                                        aux3.lugar = entradaEscaner.nextLine();
                                        System.out.println("Ingrese la fecha:");
                                        aux3.fecha = entradaEscaner.nextLine();
                                        System.out.println("Ingrese la hora:");
                                        aux3.hora = entradaEscaner.nextLine();
                                        System.out.println("Ingrese una descripción:");
                                        aux3.descripcion = entradaEscaner.nextLine();
                                        usuario_en_sesion.eventos.add(aux3);
                                        break;

                                    default:
                                        break;
                                }
                                break;

                            case 5:
                                //AMIGOS
                                System.out.println("\nAMIGOS\n1.-Ver mis amigos\n2.-Agregar amigo\n3.-Ver solicitudes\n4.-Volver a menú");
                                String opcionAmigos = entradaEscaner.nextLine();
                                switch (Integer.parseInt(opcionAmigos)) {
                                    case 1:
                                        if (usuario_en_sesion.amigos.size() == 0) {
                                            System.out.println("\n<<<<<<Sin amigos por mostrar>>>>>");
                                        } else {
                                            for (Usuario usuarioAux : usuario_en_sesion.amigos) {
                                                System.out.println(usuarioAux);
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("\nAGREGAR AMIGOS\n(Enter para ver siguiente sugerencia)\n1.-Enviar solicitud\n2.-Regresar");
                                        opcionAmigos = "";
                                        int i = 0;
                                        while (opcionAmigos.equals("")) {
                                            if (!Usuarios.get(i).equals(usuario_en_sesion)) {
                                                System.out.println("\n" + Usuarios.get(i));
                                                opcionAmigos = entradaEscaner.nextLine();
                                            }
                                            if (i == Usuarios.size()) {
                                                System.out.println("\n<<<<<<Fin lista de amigos>>>>>");
                                                opcionAmigos = "2";
                                            }
                                            i++;
                                        }
                                        i--;
                                        if (opcionAmigos.equals("1")) {
                                            if (Usuarios.get(i).solicitudes == null) {
                                                Usuarios.get(i).solicitudes = new ArrayList<>();
                                            }
                                            if (usuario_en_sesion.solicitudes == null) {
                                                usuario_en_sesion.solicitudes = new ArrayList<>();
                                            }
                                            Usuarios.get(i).solicitudes.add(new Solicitud(usuario_en_sesion, null, false, new Date()));
                                            usuario_en_sesion.solicitudes.add(new Solicitud(null, usuario_en_sesion, false, new Date()));
                                            System.out.println("\nSolicitud de amistad enviada a " + Usuarios.get(i).nombre);
                                        }
                                        break;
                                    case 3:
                                        System.out.println("\nVER SOLICITUDES DE AMISTAD\n1.-Enviadas\n2.-Recibidas\n3.-Regresar menú");
                                        String opcionSolicitudes = entradaEscaner.nextLine();

                                        switch (Integer.parseInt(opcionSolicitudes)) {
                                            case 1:
                                                System.out.println("\nSolicitudes enviadas");
                                                if (usuario_en_sesion.solicitudes == null) {
                                                    usuario_en_sesion.solicitudes = new ArrayList<>();
                                                }
                                                for (Solicitud solicitudAux : usuario_en_sesion.solicitudes) {
                                                    if (solicitudAux.getPara() != null) {
                                                        System.out.println(solicitudAux);
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("\nSolicitudes recibidas");
                                                if (usuario_en_sesion.solicitudes == null) {
                                                    usuario_en_sesion.solicitudes = new ArrayList<>();
                                                }
                                                for (Solicitud solicitudAux : usuario_en_sesion.solicitudes) {
                                                    if (solicitudAux.getDe() != null) {
                                                        System.out.println(solicitudAux);
                                                    }
                                                }
                                                break;
                                        }
                                        if (usuario_en_sesion.solicitudes != null) {
                                            for (Solicitud aux1 : usuario_en_sesion.solicitudes) {
                                                if (!(aux1.isAceptada()) && aux1.getDe() != null) {
                                                    System.out.println(aux1);
                                                    System.out.println("\n1.-Aceptar solicitud\t2.-Cancelar solicitud\t3.-Continuar viendo");
                                                    String espera2 = entradaEscaner.nextLine();

                                                    if (espera2.equals("1")) {
                                                        aux1.setAceptada(true);
                                                        usuario_en_sesion.aceptarSolicitud(aux1);
                                                    } else if (espera2.equals("2")) {
                                                        aux1.setAceptada(false);
                                                    }
                                                }

                                            }
                                        } else {
                                            System.out.println("\n<<<<<<Sin solicitudes por mostrar>>>>>");
                                        }
                                }
                                break;

                            case 6:
                                sesion = false;
                                break;

                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    //Aqui va el registro de un nuevo usuario COMPLETAR
                    Usuario nuevo = new Usuario();
                    System.out.println("Ingresar su nombre:");
                    String nom = entradaEscaner.nextLine();
                    System.out.println("Ingresar su clave:");
                    String clav = entradaEscaner.nextLine();
                    nuevo.nombre = nom;
                    nuevo.clave = clav;
                    Usuarios.add(nuevo);
                    break;
                case 3:
                    break;
                default:
                    break;
            }

        }

        EscribirArchivo();
    }

    public static Usuario Login(String auxnombre, String auxclave) {
        //throw new UnsupportedOperationException("Not supported yet.");
        Usuario retorno = new Usuario();
        for (Usuario aux : Usuarios) {
            if (aux.nombre.equals(auxnombre) && aux.clave.equals(auxclave)) {
                retorno = aux;
                System.out.println("Login correcto");
                sesion = true;
                break;
            } else {
                System.out.println("Usuario no encontrado");
                sesion = false;
            }
        }
        return retorno;
    }

    public static void LeerArchivo() {
        try ( //Leer del fichero
                ObjectInputStream writeData = new ObjectInputStream(new FileInputStream(path_fichero))) {
            Object userfichero = writeData.readObject();

            while (userfichero != null) {
                if (userfichero instanceof Usuario) {
                    Usuarios.add((Usuario) userfichero);

                }
                userfichero = writeData.readObject();
            }

            writeData.close();
        } catch (EOFException e1) {
            System.out.println("Leído.....Fin de fichero");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void EscribirArchivo() {

        Usuario user = new Usuario();
        user.nombre = "Jimmy";
        user.clave = "12345";
        user.correo = "jimmy.pardo@epn.edu.ec";
        user.genero = "Masculino";
        user.fecha_nacimiento = "6 de septiembre de 1994";
        user.info_adicional = "Me gusta la música ecuatoriana";
        //System.out.println(user);

        Evento evento1 = new Evento();
        evento1.titulo = "Fiesta destructiva por el fin del mundo";
        evento1.lugar = "Casa de Guillo";
        evento1.hora = "19:00";
        evento1.fecha = "17 de Julio de 2019";
        evento1.descripcion = "Evento por el fin de todo";

        user.eventos.add(evento1);

        Usuario user2 = new Usuario();
        user2.nombre = "Andres";
        user2.clave = "54321";
        user2.correo = "andres.ramos@epn.edu.ec";
        user2.genero = "Masculino";
        user2.fecha_nacimiento = "9 de septiembre de 1999";
        user2.info_adicional = "Me gusta la música gitana";
        //System.out.println(user2);
        user2.amigos.add(user);

        try ( //Escribir en el fichero
                ObjectOutputStream readData = new ObjectOutputStream(new FileOutputStream(path_fichero))) {
            for (Usuario aux : Usuarios) {
                readData.writeObject(aux);
                //readData.writeObject(user);
                //readData.writeObject(user2);
            }
            System.out.println("Guardado");
            readData.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
