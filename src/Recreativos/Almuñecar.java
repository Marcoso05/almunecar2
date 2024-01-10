package Recreativos;

import java.util.Scanner;
import Objetos.*;
import Diseño.Colores;
import Juegos.*;
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marcos Bermejo Salamanca
 * Menu del recreativo
 */
public class Almuñecar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables y objetos para el uso programa
        //Objeto para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
        //Variable para la seleccion de funciones del programa
        int opcion = -1;
        //Variable para almacenar las tarjetas creadas en el array de tarjetas
        int contadorTarjetas = 0;
        //Variable para almacenar los juegos creados en el array de juegos
        int contadorJuegos = 0;
        //Variable para almacenar los premios creados en el array de premios
        int contadorPremios = 0;
        //Variable para almacenar los termianles creados en el array de terminales
        int contadorTerminales = 0;
        //Cantidad de dinero que se desea cargar en las tarjetas
        int dineroCargar = 0;
        //Esta variable sustituye a la accion de introducir las tarjetas intruduciendo su posicion en el array
        int tarjetaSeleccionada;
        //Esta variable se utiliza para seleccionar la tarjeta a la cual se le van a transferir los tickets de la tarjeta seleccionada
        int tarjetaATransferir;
        //Esta variable sustituye a la accion de introducir las tarjetas intruduciendo su posicion en el array
        int premioSeleccionado;
        //Variable para almacenar los tickets ganados en cada partida y a transferir
        int tickets;
        //Creditos a transferir
        int creditos;

        //Arrays para el almacen de los objetos que va a disponer nuestro recreativo
        Tarjeta tarjetas[] = new Tarjeta[100];
        Juego juegos[] = new Juego[20];
        Terminal terminales[] = new Terminal[10];
        Premio premios[] = new Premio[50];

        //Creacion de los pobjetos
        //Juegos
        juegos[contadorJuegos] = new AdivinaOrden("AdivinaOrden",5);
        contadorJuegos++;
        juegos[contadorJuegos] = new Piedra("Piedra Papel Tijera",5);
        contadorJuegos++;
        juegos[contadorJuegos] = new EncuentraElNumero("Adivina el numero",5);
        contadorJuegos++;
        

        //Premios
        premios[contadorPremios] = new Premio("Osito", 100, 50);
        contadorPremios++;
        premios[contadorPremios] = new Premio("Pelota", 50, 100);
        contadorPremios++;
        premios[contadorPremios] = new Premio("Gominolas", 10, 200);
        contadorPremios++;
        //Terminales
        terminales[contadorTerminales] = new Terminal(premios[0], premios[1], premios[2]);

        System.out.println(Colores.FONDO_MORADO + Colores.WHITE + "Bienvenido a las recreativas ALMUÑECAR!!!" + Colores.RESET);

        //Este sera el menú que utilizara el usuario cliente para realizar las acciones
        System.out.print("\nEstas son las opciones: ");
        do {
            System.out.println("\n1: Crear tarjeta. \n2: Introducir creditos. \n3: Ver los datos de su tarjeta.\n4: Opciones de juego. \n5: Informacion de los premios. \n6: Realizar una transferencia.\n7: Salir del terminal.");
            System.out.print("Que opcion desea: ");
            try {
                opcion = teclado.nextInt();

                switch (opcion) {
                    //Carjar dinero
                    case 1:
                        //Preguntara con cuanto dinero quieres inicializar la tarjeta
                        System.out.print("Con cuanto dinero quieres cargar la nueva tarjeta: ");
                        dineroCargar = teclado.nextInt();

                        //Crear una nueva tarjeta
                        tarjetas[contadorTarjetas] = terminales[0].crearTarjeta(dineroCargar);
                        //Si la tarjeta se crea correctamente te mostrara un mensaje indicando que se creo correctamente y mostrara la informacion de esta
                        if (tarjetas[contadorTarjetas] != null) {
                            System.out.println("\n\t" + Colores.BLUE + "Tarjeta creada correctamente" + "\n\t" + Colores.BLUE + tarjetas[contadorTarjetas].toString().replace("\n", Colores.BLUE + "\n\t") + Colores.RESET);
                        }else{
                            System.out.println("\n\t"+Colores.RED+"No se puedo crear su tarjeta"+Colores.RESET);
                        }
                        contadorTarjetas++;
                        break;
                       
                    //Cargar la tarjeta con nuevos creditos
                    case 2:
                        System.out.print("Introduzca su tarjeta: ");
                        //Al valor introducido por el usuario hay que restarle uno ya que el array empieza en 0 pero el contador de tarjetas en 1
                        tarjetaSeleccionada = teclado.nextInt() - 1;

                        //Comprueba que la tarjeta se encuentra dentro del trango de tarjetas que se pueden crear
                        if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                            System.out.println(Colores.RED + "\n\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                        } else {
                            //Comprueba que la tarjeta existe y que no se ha introducido una con un valor no existente
                            if (tarjetas[tarjetaSeleccionada] == null) { //
                                System.out.println(Colores.RED + "\n\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                            } else {
                                //pregunta la cantidad de dinero a cargar
                                System.out.print("Cuánto dinero desea cargar en su tarjeta: ");
                                dineroCargar = teclado.nextInt();

                                //Comprueba que el dinero no sea un numero negativo
                                if (dineroCargar <= 0) {
                                    System.out.println(Colores.RED + "\n\tLa cantidad de dinero a cargar debe ser positiva" + Colores.RESET);
                                } else {
                                    //Carga el dinero
                                    terminales[0].cargarTarjeta(tarjetas[tarjetaSeleccionada], dineroCargar);
                                    System.out.println(Colores.BLUE + "\n\t¡Carga exitosa!" + Colores.RESET);
                                }
                            }
                        }

                        break;
                    //Mostrar la informacion a cerca de una tarjeta
                    case 3:
                        //Pregunta por la tarjeta de la cual queremos obtener la informacion
                        System.out.print("Introduzca su tarjeta: ");
                        //Al valor introducido por el usuario hay que restarle uno ya que el array empieza en 0 y el contador de tarjetas en 1
                        tarjetaSeleccionada = teclado.nextInt() - 1;
                        //Comprueba que el valor introducido este dentro de los limites de tarjetas disponibles
                        if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                            System.out.println(Colores.RED + "\n\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                        } else {
                            //Comprueba que la tarjeta esta creada
                            if (tarjetas[tarjetaSeleccionada] == null) {
                                System.out.println(Colores.RED + "\n\tLa tarjeta seleccionada no es válida" + Colores.RESET);

                            } else {
                                //Muestra la informacion de la tarjeta
                                System.out.println();
                                System.out.println("\t" + Colores.BLUE + tarjetas[tarjetaSeleccionada].toString().replace("\n", Colores.BLUE + "\n\t") + Colores.RESET);
                            }
                        }

                        break;
                    //Mostrar opciones de juego
                    case 4:
                        int seleccion = -1;
                        do {
                            System.out.println("\n\tEstas son las opciones de los juegos");
                            System.out.println("\t1: Ver los juegos\n\t2: Comprobar si puedo jugar\n\t3: Jugar\n\t4: Salir");

                            System.out.print("\tQue opcion desea: ");
                            seleccion = teclado.nextInt();

                            switch (seleccion) {
                                //Mostrar los juegos
                                case 1:
                                    System.out.println();
                                    System.out.println("\t\t" + Colores.BLUE + "Estos son los juegos disponibles" + Colores.RESET);
                                    //El replace se utiliza para que cambie en el codigo los \n por lo de dentras de la coma para cambiar el formato
                                    System.out.println("\t\t" + Colores.BLUE + mostrarJuegosDisponibles(juegos).replace("\n", "\n\t\t" + Colores.BLUE) + Colores.RESET);

                                    break;
                                //Comprobar si se puede jugar a un juego
                                case 2:
                                    //Solizita la tarjeta
                                    System.out.print("\tIntroduce tu tarjeta: ");
                                    tarjetaSeleccionada = teclado.nextInt() - 1;
                                    //Comprueba que existe
                                    if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                                        System.out.println(Colores.RED + "\n\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                    } else {
                                        if (tarjetas[tarjetaSeleccionada] == null) {
                                            System.out.println(Colores.RED + "\n\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                        } else {
                                            //Muestra los jeugos disponibles y pregunta por cual quieres utilizar
                                            System.out.println();
                                            System.out.println("\tEstos son los juegos disponibles");
                                            System.out.println("\t" + mostrarJuegosDisponibles(juegos).replace("\n", "\n\t"));
                                            System.out.print("\tCual es el juego que quieres comprobar: ");
                                            seleccion = teclado.nextInt() - 1;
                                            
                                            //Comprueba que el juego existe
                                            if (seleccion < 0 || seleccion >= juegos.length) {
                                                System.out.println(Colores.RED + "\n\tEl juego seleccionada no es válida" + Colores.RESET);
                                            } else {
                                                if (juegos[seleccion] == null) {
                                                    System.out.println(Colores.RED + "\n\tEl juego seleccionada no es válida" + Colores.RESET);
                                                } else {
                                                    //Informa si se puede jugar o no
                                                    if (juegos[seleccion].comprobarCreditosNecesarios(tarjetas[tarjetaSeleccionada])) {
                                                        System.out.println(Colores.BLUE + "\n\t\tPuede jugar y le quedaran: " + (tarjetas[tarjetaSeleccionada].getCreditos() - juegos[seleccion].getCreditosNecesarios()) + Colores.RESET);
                                                    } else {
                                                        System.out.println(Colores.RED + "\n\t\tNo dispone de los creditos necesarios" + Colores.RESET);
                                                    }

                                                }
                                            }
                                        }
                                    }

                                    break;
                                //Jugar a un juego
                                case 3:
                                    //Pregunta por la tarjeta
                                    System.out.print("\tIntroduce tu tarjeta: ");
                                    tarjetaSeleccionada = teclado.nextInt() - 1;
                                    
                                    //Comprueba que la tarjeta existe
                                    if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                                        System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                    } else {
                                        if (tarjetas[tarjetaSeleccionada] == null) {
                                            System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                        } else {
                                            //Muestra los juegos disponibles y a cual se quiere jugar
                                            System.out.println();
                                            System.out.println("\n\tEstos son los juegos disponibles");
                                            System.out.println("\t" + mostrarJuegosDisponibles(juegos).replace("\n", "\n\t"));
                                            System.out.print("\tCual es el juego que quieres jugar: ");
                                            seleccion = teclado.nextInt() - 1;
                                            
                                            //Comprueba que el juego existe
                                            if (seleccion < 0 || seleccion >= juegos.length) {
                                                System.out.println(Colores.RED + "\n\t\tEl jeugo seleccionada no es válida" + Colores.RESET);
                                            } else {
                                                if (juegos[seleccion] == null) {
                                                    System.out.println(Colores.RED + "\n\t\tEl juego seleccionada no es válida" + Colores.RESET);
                                                } else {
                                                    //Comprueba que dispone de los creditos necesarios
                                                    if (juegos[seleccion].comprobarCreditosNecesarios(tarjetas[tarjetaSeleccionada])) {
                                                        //Llama a la funcion jugar
                                                        tickets = juegos[seleccion].jugar(tarjetas[tarjetaSeleccionada]);
                                                        System.out.println("\n\t\t" + Colores.BLUE + "Ganaste: " + tickets + Colores.RESET);
                                                    } else {
                                                        System.out.println("\n\t\t" + Colores.RED + "No dispone de los creditos necesarios" + Colores.RESET);
                                                    }

                                                }
                                            }
                                        }
                                    }
                                //Salir
                                case 4:
                                    break;
                               //En caso de que introduzca un valor no valido
                                default:
                                    System.out.println("\n" + Colores.RED + "\tOpcion no valida" + Colores.RESET);

                            }

                        } while (seleccion != 4);
                        break;

                    //Opciones de los premios
                    case 5:
                        do {
                            //Muestra las distintas opciones de los premios
                            System.out.println("\n\tEstas son las opciones de los premios: \n\t1: Ver premios \n\t2: Canjear premios. \n\t3: Volver.");
                            System.out.print("\tQue accion desea realizar: ");
                            opcion = teclado.nextInt();
                            
                            switch (opcion) {
                                //Muestra los premios disponibles
                                case 1:
                                    System.out.print("\n\t\t" + Colores.BLUE + "Estos son los premios disponibles" + Colores.RESET);
                                    System.out.println("\t\t" + Colores.BLUE + mostrarNombrePremios(terminales, premios).replace("\n", "\n\t\t" + Colores.BLUE) + Colores.RESET);
                                    break;
                                //Canjear premios
                                case 2:
                                    //Solicita la tarjeta
                                    System.out.print("\tIntroduce tu tarjeta: ");
                                    tarjetaSeleccionada = teclado.nextInt() - 1;
                                    //Comprueba que la tarjeta existe
                                    if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                                        System.out.println("\n" + Colores.RED + "\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                    } else {
                                        if (tarjetas[tarjetaSeleccionada] == null) {
                                            System.out.println("\n" + Colores.RED + "\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                        } else {
                                            //Muestra los premios disponibles y pregunta por cual quieres
                                            System.out.println("\tEstos son los premios disponibles");
                                            System.out.println("\t\t" + mostrarNombrePremios(terminales, premios).replace("\n", "\n\t"));
                                            System.out.print("\tQue premio desea obtener: ");
                                            premioSeleccionado = teclado.nextInt() - 1;
                                            
                                            //Comprueba que el premio existe
                                            if (premioSeleccionado > 3 || premioSeleccionado < 0) {
                                                System.out.println("\n" + Colores.RED + "\t\tEl premio seleccionada no es válida" + Colores.RESET);
                                            } else {
                                                //Cangea el premio
                                                terminales[0].canjearPremios(premios[premioSeleccionado], tarjetas[tarjetaSeleccionada]);

                                            }
                                        }
                                    }
                                    System.out.println();
                                    break;
                                //Salir
                                case 3:
                                    break;
                                //En caso de que se introduzca un valor no valido
                                default:
                                    System.out.println(Colores.RED + "Opcion seleccionada no valida" + Colores.RESET);
                            }

                        } while (opcion != 3);
                        break;
                    //Transferencias
                    case 6:
                        //Muestra las opciones de transferencia que existen
                        System.out.println("\n\tOpciones de transferencia:");
                        System.out.println("\t1: Tickets\n\t2: Creditos");
                        System.out.print("\tDe que desea realizar la transferencia: ");
                        seleccion = teclado.nextInt();
                        switch (seleccion) {
                            //Transferencia de tickets
                            case 1:
                                //Pregunta por la tarjeta de la cual se van a extraer los tickets
                                System.out.print("\n\tSeleccione la tarjeta de la cual va a transferir los tickets: ");
                                tarjetaSeleccionada = teclado.nextInt() - 1;
                                
                                //Comprueba que la tarjeta existe
                                if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                                    System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                } else {
                                    if (tarjetas[tarjetaSeleccionada] == null) {
                                        System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                    } else {
                                        //Pregunta cuantos tickets se van a transferir
                                        System.out.print("\tCuantos tickets desea transferir: ");
                                        tickets = teclado.nextInt();
                                        //Comprueba que disponga de los tiecktes necesarios
                                        if (tickets > 0 && tarjetas[tarjetaSeleccionada].getTickets() >= tickets) {
                                            //Pregunta por la tarjeta a la que se el van a agregar los tickets
                                            System.out.print("\tA que tarjeta le quieres transferir los tickets: ");
                                            tarjetaATransferir = teclado.nextInt() - 1;
                                            //Comprueba que la tarjeta existe
                                            if (tarjetaATransferir < 0 || tarjetaATransferir >= tarjetas.length) {
                                                System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                            } else {
                                                if (tarjetas[tarjetaATransferir] == null) {
                                                    System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                                } else {
                                                    //Realiza la transferencia de tickets
                                                    terminales[0].transferirTickets(tarjetas[tarjetaSeleccionada], tarjetas[tarjetaATransferir], tickets);
                                                    System.out.println("\n\t\t"+ Colores.BLUE+"Transferencia realizada con exito"+Colores.RESET);
                                                }
                                            }
                                        }else{
                                            System.out.println("\n\t\t"+ Colores.RESET+"Numero de tickets induficientes"+Colores.RESET);
                                        }
                                    }
                                }
                                break;
                            //Transferencia de creditos
                            case 2:
                                //Pregunta por la tarjeta de la que se van a extraer los creditos
                                System.out.print("\n\tSeleccione la tarjeta de la cual va a transferir los creditos: ");
                                tarjetaSeleccionada = teclado.nextInt() - 1;
                                //Comprueba que la tarjeta existe
                                if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                                    System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                } else {
                                    if (tarjetas[tarjetaSeleccionada] == null) {
                                        System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                    } else {
                                        //Pregunta por la cantidad de creditos que se van a transferir
                                        System.out.print("\tCuantos creditos desea transferir: ");
                                        creditos = teclado.nextInt();
                                        //Comprueba que la tarjeta disponga de los creditos necesarios
                                        if (creditos > 0 && tarjetas[tarjetaSeleccionada].getCreditos()>= creditos) {
                                            //Pregunta por la tarjeta a la que se le van a agregar los creditos
                                            System.out.print("\tA que tarjeta le quieres transferir los creditos: ");
                                            tarjetaATransferir = teclado.nextInt() - 1;
                                            //Comprueba que la tarjeta existe
                                            if (tarjetaATransferir < 0 || tarjetaATransferir >= tarjetas.length) {
                                                System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                            } else {
                                                if (tarjetas[tarjetaATransferir] == null) {
                                                    System.out.println(Colores.RED + "\n\t\tLa tarjeta seleccionada no es válida" + Colores.RESET);
                                                } else {
                                                    //Realiza la transferencia
                                                    terminales[0].transferirCreditos(tarjetas[tarjetaSeleccionada], tarjetas[tarjetaATransferir], creditos);
                                                    System.out.println("\n\t\t"+ Colores.BLUE+"Transferencia realizada con exito"+Colores.RESET);
                                                }
                                            }
                                        }else{
                                            System.out.println("\n\t\t"+Colores.RED+ "Numero de creditos induficientes"+Colores.RESET);
                                        }
                                    }
                                }
                        }
                    //Salir del programa
                    case 7:
                        break;
                    //En caso de introducir un valor no valido
                    default:
                        System.out.println(Colores.RED + "Opcion seleccionada no valida" + Colores.RESET);

                }
            //Recoger si el usuario introduce un valor no valido 
            } catch (InputMismatchException ex) {
                System.out.println(Colores.RED + "El valor introducido no es valido, porfavot introduzca un numero entero" + Colores.RESET);
                teclado.nextLine();
            }
        } while (opcion != 7);
        System.out.println("\n" + Colores.BLUE + "Gracias por venir\n" + Colores.RESET);
        
    }

    //Metodo para mostrar los nombres de los diferentes jeugos
    public static String mostrarJuegosDisponibles(Juego juegos[]) {
        int contador = 0;
        String juegosDisponibles = "";
        //Va a comprobar si el juego no es null y en caso de que lo sea se finaliza el programa
        while (juegos[contador] != null) {
            //Si el jeugo existe añadira el nombre de este
            juegosDisponibles += "\t" + (contador + 1) + ": " + juegos[contador].getNombre() + "\n";
            //Aumenta el contador
            contador++;
        } 
        return juegosDisponibles;
        
    }

    
    public static String mostrarNombrePremios(Terminal terminales[], Premio premios[]) {
        String resultado = "";
        Premio prem[] = terminales[0].getPremioArray();
        int contador = 0;
        while (contador < premios.length && premios[contador] != null) {
            if (prem[contador] == premios[contador]) {
                resultado += "\n\t" + (contador + 1) + ": " + premios[contador].getNombre() + ", tickets necesarios: " + premios[contador].getTicketsNecesarios();
            }
            contador++;
        }
        return resultado;
    }
}
