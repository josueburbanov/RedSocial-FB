
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
    public static String path_fichero = "C:\\Fichero.txt";
    public static boolean sesion = false;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here

        LeerArchivo();
        Scanner entradaEscaner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\nFACEBOOK\n\n1.-Login \n2.-Registrarse\n3.-Salir\n");
            //String op = entradaEscaner.nextLine();
            //opcion = Integer.parseInt(op);
            opcion = ValidarOpcionMenu();
            switch (opcion) {
                case 1:
                    System.out.println("\nLOGIN\nIngrese nombre de usuario:");
                    String auxnombre = entradaEscaner.nextLine();
                    System.out.println("Ingrese contraseña:");
                    String auxclave = entradaEscaner.nextLine();
                    usuario_en_sesion = Login(auxnombre, auxclave);
                    while (sesion == true) {
                        System.out.println("\nUSUARIO EN LINEA: " + usuario_en_sesion.getNombre() + "\nMENU\n1.-Ver perfil\n2.-Ver publicaciones\n3.-Grupos\n4.-Eventos\n5.-Amigos\n6.-Cerrar sesión");
                        int opcion2 = ValidarOpcionMenu();
                        switch (opcion2) {
                            case 1:
                                System.out.println(usuario_en_sesion);
                                String espera = entradaEscaner.nextLine();
                                break;

                            case 2:
                                //PUBLICACIONES
                                System.out.println("\nPUBLICACIONES\n1.-Publicar en mi muro\n2.-Publicar en el muro de un amigo\n3.- Ver publicaciones");
                                String opcionPublicar = entradaEscaner.nextLine();
                                switch (opcionPublicar) {
                                    case "1":
                                        System.out.println("\nPublicar en mi muro\nEscriba aquí el texto de la publicación: ");
                                        String textoPublicacion = entradaEscaner.nextLine();
                                        if (usuario_en_sesion.getPublicaciones() == null) {
                                            usuario_en_sesion.setPublicaciones(new ArrayList<>());
                                        }
                                        usuario_en_sesion.getPublicaciones().add(new Publicación(textoPublicacion, usuario_en_sesion));

                                        break;
                                    case "2":
                                        System.out.println("\nPublicar en el muro de un amigo\n1.Seleccionar amigo\nOtra tecla.- Volver a menú");

                                        String seleccionAmigo = "";
                                        String texto_pub = "";
                                        Usuario amigoPublicar = null;
                                        if (usuario_en_sesion.getAmigos().size() == 0) {
                                            System.out.println("\n<<<<<<Sin amigos por mostrar>>>>>");
                                        } else {
                                            for (Usuario amigo : usuario_en_sesion.getAmigos()) {
                                                seleccionAmigo = entradaEscaner.nextLine();
                                                if (seleccionAmigo.equals("1")) {
                                                    amigoPublicar = amigo;
                                                    System.out.println("\nEscriba texto de publicación: ");
                                                    texto_pub = entradaEscaner.nextLine();
                                                    break;
                                                }
                                            }
                                        }

                                        if (amigoPublicar != null) {
                                            if (amigoPublicar.getPublicaciones() == null) {
                                                amigoPublicar.setPublicaciones(new ArrayList<>());
                                            }
                                            amigoPublicar.getPublicaciones().add(new Publicación(texto_pub, usuario_en_sesion));
                                        }

                                        break;
                                    case "3":
                                        System.out.println("\nMis Publicaciones:  \n");
                                        if (usuario_en_sesion.getPublicaciones() == null) {
                                            usuario_en_sesion.setPublicaciones(new ArrayList<>());
                                        }

                                        if (usuario_en_sesion.getPublicaciones().size() == 0) {
                                            System.out.println("\n<<<<<<Sin publicaciones por mostrar>>>>>");
                                        } else {
                                            for (Publicación iter : usuario_en_sesion.getPublicaciones()) {
                                                System.out.println(iter);
                                                System.out.println("\n1.Me gusta\t2.Me encanta\t3.Me divierte\t4.Me enoja\t5.Me entristese\tOtra tecla.-Seguir viendo");
                                                String seleccionPub = entradaEscaner.nextLine();
                                                if (seleccionPub.equals("1")) {
                                                    if (iter.getReacciones() == null) {
                                                        iter.setReacciones(new ArrayList<>());
                                                    }
                                                    iter.getReacciones().add(new Reacción("Me gusta", usuario_en_sesion));
                                                } else if (seleccionPub.equals("2")) {
                                                    if (iter.getReacciones() == null) {
                                                        iter.setReacciones(new ArrayList<>());
                                                    }
                                                    iter.getReacciones().add(new Reacción("Me encanta", usuario_en_sesion));
                                                } else if (seleccionPub.equals("3")) {
                                                    if (iter.getReacciones() == null) {
                                                        iter.setReacciones(new ArrayList<>());
                                                    }
                                                    iter.getReacciones().add(new Reacción("Me divierte", usuario_en_sesion));
                                                } else if (seleccionPub.equals("4")) {
                                                    if (iter.getReacciones() == null) {
                                                        iter.setReacciones(new ArrayList<>());
                                                    }
                                                    iter.getReacciones().add(new Reacción("Me enoja", usuario_en_sesion));
                                                } else if (seleccionPub.equals("5")) {
                                                    if (iter.getReacciones() == null) {
                                                        iter.setReacciones(new ArrayList<>());
                                                    }
                                                    iter.getReacciones().add(new Reacción("Me entristece", usuario_en_sesion));
                                                }
                                            }

                                            System.out.println("\nPublicaciones de amigos\n");
                                            for (Usuario amigo : usuario_en_sesion.getAmigos()) {
                                                System.out.println("\nPublicaciones de "+amigo.getNombre()+"\n");
                                                if (amigo.getPublicaciones() == null) {
                                                    amigo.setPublicaciones(new ArrayList<>());
                                                }

                                                if (amigo.getPublicaciones().size() == 0) {
                                                    System.out.println("\n<<<<<<Sin publicaciones por mostrar>>>>>\n");
                                                } else {
                                                    for (Publicación iter : amigo.getPublicaciones()) {
                                                        System.out.println(iter);
                                                        System.out.println("\n1.Me gusta\t2.Me encanta\t3.Me divierte\t4.Me enoja\t5.Me entristese\tOtra tecla.-Seguir viendo");
                                                        String seleccionPub = entradaEscaner.nextLine();
                                                        if (seleccionPub.equals("1")) {
                                                            if (iter.getReacciones() == null) {
                                                                iter.setReacciones(new ArrayList<>());
                                                            }
                                                            iter.getReacciones().add(new Reacción("Me gusta", usuario_en_sesion));
                                                        } else if (seleccionPub.equals("2")) {
                                                            if (iter.getReacciones() == null) {
                                                                iter.setReacciones(new ArrayList<>());
                                                            }
                                                            iter.getReacciones().add(new Reacción("Me encanta", usuario_en_sesion));
                                                        } else if (seleccionPub.equals("3")) {
                                                            if (iter.getReacciones() == null) {
                                                                iter.setReacciones(new ArrayList<>());
                                                            }
                                                            iter.getReacciones().add(new Reacción("Me divierte", usuario_en_sesion));
                                                        } else if (seleccionPub.equals("4")) {
                                                            if (iter.getReacciones() == null) {
                                                                iter.setReacciones(new ArrayList<>());
                                                            }
                                                            iter.getReacciones().add(new Reacción("Me enoja", usuario_en_sesion));
                                                        } else if (seleccionPub.equals("5")) {
                                                            if (iter.getReacciones() == null) {
                                                                iter.setReacciones(new ArrayList<>());
                                                            }
                                                            iter.getReacciones().add(new Reacción("Me entristece", usuario_en_sesion));
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                }

                                    case 3:
                                        System.out.println("\nGRUPOS\n1.-Ver mis grupos\n2.-Unirse a grupos\n3.-Crear grupo\nOtra tecla.-Volver al menú");

                                        int opcion4 = ValidarOpcionMenu();
                                        int espera2 = 9;
                                        switch (opcion4) {
                                            case 1:
                                                for (Grupo aux : usuario_en_sesion.getGrupos()) {
                                                    System.out.println(aux);
                                                    System.out.println("\n1.-Publicar\t2.-Siguiente grupo");
                                                    espera2 = ValidarOpcionMenu();
                                                    //Empieza UNIRSE/PUBLICAR/CONTINUAR EN GRUPO
                                                    switch (espera2) {
                                                        case 1:

                                                            //Publicar
                                                            System.out.println("\nPublicar en el grupo\nEscriba aquí el texto de la publicación: ");
                                                            String txtpubli = entradaEscaner.nextLine();
                                                            aux.AgregarPublicacion(new Publicación(txtpubli, usuario_en_sesion));

                                                            break;

                                                        default:

                                                            break;
                                                    }
                                                    //Finaliza PUBLICAR EN GRUPO        

                                                }
                                                System.out.println("<<<< Fin de grupos >>>>");
                                                break;

                                            case 2:

                                                //Unirme a grupos
                                                for (Usuario aux : usuario_en_sesion.getAmigos()) {
                                                    for (Grupo gv : aux.getGrupos()) {
                                                        System.out.println(gv);
                                                        System.out.println("\n1.-Unirme\t2.-Siguiente grupo");
                                                        espera2 = ValidarOpcionMenu();
                                                        //Empieza UNIRSE/PUBLICAR/CONTINUAR EN GRUPO
                                                        switch (espera2) {

                                                            case 1:
                                                                //Unirme
                                                                usuario_en_sesion.AgregarGrupo(gv);

                                                                break;

                                                            case 2:

                                                                break;
                                                            default:

                                                                break;
                                                        }
                                                        //Finaliza PUBLICAR EN GRUPO        
                                                    }
                                                }
                                                System.out.println("<<<< Fin de grupos >>>>");
                                                break;
                                            case 3:
                                                Grupo aux = new Grupo();
                                                System.out.println("Ingrese el titulo:");
                                                aux.setNombre(entradaEscaner.nextLine());
                                                System.out.println("Ingrese una descripción:");
                                                aux.setDescripcion(entradaEscaner.nextLine());
                                                usuario_en_sesion.AgregarGrupo(aux);
                                                break;
                                        }
                                        break;

                                    case 4:
                                        System.out.println("\nEVENTOS\n1.-Ver eventos\n2.-Crear evento");
                                        int opcion3 = ValidarOpcionMenu();
                                        switch (opcion3) {
                                            case 1:
                                                for (Evento aux1 : usuario_en_sesion.getEventos()) {
                                                    System.out.println(aux1);
                                                    System.out.println("\n1.-Asistiré\t2.-Me interesa\t3.-Continuar viendo");
                                                    String espera22 = entradaEscaner.nextLine();

                                                    if (espera22.equals("1")) {
                                                        aux1.AddAssit(usuario_en_sesion);
                                                        System.out.println("<<<< Confirmado >>>>>");
                                                        System.out.flush();
                                                    } else if (espera22.equals("2")) {
                                                        aux1.AddInteres(usuario_en_sesion);
                                                    }

                                                }

                                                for (Usuario aux2 : usuario_en_sesion.getAmigos()) {
                                                    for (Evento ev : aux2.getEventos()) {
                                                        System.out.println(ev);
                                                        System.out.println("\n1.-Asistiré\t2.-Me interesa\t3.-Siguiente evento");
                                                        String espera3 = entradaEscaner.nextLine();
                                                        if (espera3.equals("1")) {
                                                            ev.AddAssit(usuario_en_sesion);
                                                        } else if (espera3.equals("2")) {
                                                            ev.AddInteres(usuario_en_sesion);
                                                        }
                                                    }
                                                }

                                                break;

                                            case 2:
                                                Evento aux3 = new Evento();
                                                System.out.println("Ingrese el titulo:");
                                                aux3.setTitulo(entradaEscaner.nextLine());
                                                System.out.println("Ingrese el lugar:");
                                                aux3.setLugar(entradaEscaner.nextLine());
                                                System.out.println("Ingrese la fecha:");
                                                aux3.setFecha(entradaEscaner.nextLine());
                                                System.out.println("Ingrese la hora:");
                                                aux3.setHora(entradaEscaner.nextLine());
                                                System.out.println("Ingrese una descripción:");
                                                aux3.setDescripcion(entradaEscaner.nextLine());
                                                usuario_en_sesion.getEventos().add(aux3);
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
                                                if (usuario_en_sesion.getAmigos().size() == 0) {
                                                    System.out.println("\n<<<<<<Sin amigos por mostrar>>>>>");
                                                } else {
                                                    usuario_en_sesion.limpiarAmigosRepetidos();
                                                    for (Usuario usuarioAux : usuario_en_sesion.getAmigos()) {
                                                        System.out.println(usuarioAux);
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("\nAGREGAR AMIGOS\n(Enter para ver siguiente sugerencia)\n1.-Enviar solicitud\n2.-Regresar");
                                                opcionAmigos = "";
                                                int i = 0;
                                                if (Usuarios.size() != 1) {
                                                    while (opcionAmigos.equals("")) {
                                                        if (!Usuarios.get(i).equals(usuario_en_sesion) || !usuario_en_sesion.getAmigos().contains(Usuarios.get(i))) {
                                                            System.out.println("\n" + Usuarios.get(i));
                                                            opcionAmigos = entradaEscaner.nextLine();
                                                            if (opcionAmigos.equals("1")) {
                                                                break;
                                                            }
                                                        }
                                                        if (i + 1 == Usuarios.size()) {
                                                            System.out.println("\n<<<<<<Fin lista de amigos>>>>>");
                                                            opcionAmigos = "2";
                                                        }
                                                        i++;
                                                    }
                                                }
                                                if (opcionAmigos.equals("1")) {
                                                    if (Usuarios.get(i).getSolicitudes() == null) {
                                                        Usuarios.get(i).setSolicitudes(new ArrayList<>());
                                                    }
                                                    if (usuario_en_sesion.getSolicitudes() == null) {
                                                        usuario_en_sesion.setSolicitudes(new ArrayList<>());
                                                    }
                                                    Usuarios.get(i).getSolicitudes().add(new Solicitud(usuario_en_sesion, null, false, new Date()));
                                                    usuario_en_sesion.getSolicitudes().add(new Solicitud(null, Usuarios.get(i), false, new Date()));
                                                    System.out.println("\nSolicitud de amistad enviada a " + Usuarios.get(i).getNombre());
                                                }
                                                break;
                                            case 3:
                                                System.out.println("\nVER SOLICITUDES DE AMISTAD\n1.-Enviadas\n2.-Recibidas\n3.-Regresar menú");
                                                String opcionSolicitudes = entradaEscaner.nextLine();

                                                switch (Integer.parseInt(opcionSolicitudes)) {
                                                    case 1:
                                                        System.out.println("\nSolicitudes enviadas");
                                                        if (usuario_en_sesion.getSolicitudes() == null) {
                                                            usuario_en_sesion.setSolicitudes(new ArrayList<>());
                                                        }
                                                        for (Solicitud solicitudAux : usuario_en_sesion.getSolicitudes()) {
                                                            if (solicitudAux.getDe() == null) {
                                                                System.out.println(solicitudAux);
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("\nSolicitudes recibidas");

                                                        if (usuario_en_sesion.getSolicitudes() != null) {
                                                            for (Solicitud aux1 : usuario_en_sesion.getSolicitudes()) {
                                                                if (!(aux1.isAceptada()) && aux1.getDe() != null) {
                                                                    System.out.println(aux1);
                                                                    System.out.println("\n1.-Aceptar solicitud\t2.-Cancelar solicitud\t3.-Continuar viendo");
                                                                    String espera3 = entradaEscaner.nextLine();

                                                                    if (espera3.equals("1")) {
                                                                        aux1.setAceptada(true);
                                                                        usuario_en_sesion.aceptarSolicitud(aux1, aux1.getDe());
                                                                        break;
                                                                    } else if (espera3.equals("2")) {
                                                                        aux1.setAceptada(false);
                                                                        break;
                                                                    }
                                                                }

                                                            }
                                                        } else {
                                                            System.out.println("\n<<<<<<Sin solicitudes por mostrar>>>>>");
                                                        }
                                                        break;
                                                }
                                        }
                                        break;

                                    case 6:
                                        sesion = false;
                                        EscribirArchivo();
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
                    System.out.println("Correo:");
                    String correo = entradaEscaner.nextLine();
                    System.out.println("Genero:");
                    String genero = entradaEscaner.nextLine();
                    System.out.println("Fecha Nacimiento:");
                    String fechaNacimiento = entradaEscaner.nextLine();                    
                    System.out.println("Info adicional:");
                    String infoAd = entradaEscaner.nextLine();                    
                    nuevo.setNombre(nom);
                    nuevo.setClave(clav);
                    nuevo.setCorreo(correo);
                    nuevo.setGenero(genero);
                    nuevo.setFecha_nacimiento(fechaNacimiento);
                    nuevo.setInfo_adicional(infoAd);
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
            if (aux.getNombre().equals(auxnombre) && aux.getClave().equals(auxclave)) {
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
        do {
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
                break;
            } catch (EOFException e1) {
                System.out.println("Leído.....Fin de fichero");
                break;
            } catch (Exception e2) {
                //e2.printStackTrace();
                Scanner in = new Scanner(System.in);
                System.out.println(" <<< Es probable que haya cambiado la ruta de la fuente de datos >>> ");
                System.out.println(" <<< POR FAVOR INTRODUZCA LA NUEVA RUTA >>> ");
                path_fichero = in.nextLine();
            }
        } while (true);
    }

    public static void EscribirArchivo() {

        Usuario user = new Usuario();
        user.setNombre("Jimmy");
        user.setClave("12345");
        user.setCorreo("jimmy.pardo@epn.edu.ec");
        user.setGenero("Masculino");
        user.setFecha_nacimiento("6 de septiembre de 1994");
        user.setInfo_adicional("Me gusta la música ecuatoriana");
        //System.out.println(user);

        Evento evento1 = new Evento();
        evento1.setTitulo("Fiesta destructiva por el fin del mundo");
        evento1.setLugar("Casa de Guillo");
        evento1.setHora("19:00");
        evento1.setFecha("17 de Julio de 2019");
        evento1.setDescripcion("Evento por el fin de todo");

        user.getEventos().add(evento1);

        Usuario user2 = new Usuario();
        user2.setNombre("Andres");
        user2.setClave("54321");
        user2.setCorreo("andres.ramos@epn.edu.ec");
        user2.setGenero("Masculino");
        user2.setFecha_nacimiento("9 de septiembre de 1999");
        user2.setInfo_adicional("Me gusta la música gitana");
        //System.out.println(user2);
        user2.getAmigos().add(user);

        try ( //Escribir en el fichero
                ObjectOutputStream readData = new ObjectOutputStream(new FileOutputStream(path_fichero))) {
            for (Usuario aux : Usuarios) {
                readData.writeObject(aux);
                //readData.writeObject(user);
                //readData.writeObject(user2);
            }
            System.out.println("<<  Cerrando... >>");
            readData.close();
        } catch (Exception e) {
            System.out.println("<<  Hubo un problema guardando la información "
                    + "modificada en esta sesión. Por favor revise que posea"
                    + " los permisos adecuados para correr este programa. >>");
        }

    }

    public static int ValidarOpcionMenu() {
        int a = 0;
        Scanner capturar = new Scanner(System.in);
        do {
            try {
                a = capturar.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ingresar solo numeros");
                capturar.next();
            }
        } while (true);
        return a;
    }

}
