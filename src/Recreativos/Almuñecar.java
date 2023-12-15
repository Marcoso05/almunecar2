package Recreativos;

import java.util.Scanner;
import Objetos.*;
import Diseño.Colores;
import java.util.Arrays;
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author developer
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
        //Esta variable sustituye a la accion de introducir las tarjetas intruduciendo su posicion en el array
        int premioSeleccionado;

        //Arrays para el almacen de los objetos que va a disponer nuestro recreativo
        Tarjeta tarjetas[] = new Tarjeta[100];
        Juego juegos[] = new Juego[20];
        Terminal terminales[] = new Terminal[10];
        Premio premios[] = new Premio[50];

        //Creacion de los pobjetos
        //Juegos
        juegos[contadorJuegos] = new Juego("Numero", 2);
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

        System.out.print("\nEstas son las opciones: ");
        do {
            System.out.println("\n1: Crear tarjeta. \n2: Introducir creditos. \n3: Ver los datos de su tarjeta.\n4: Opciones de juego. \n5: Informacion de los premios. \n6: Salir del terminal.");
            System.out.print("Que opcion desea: ");
            try {
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        //Dinero a cargar
                        System.out.print("Con cuanto dinero quieres cargar la nueva tarjeta: ");

                        dineroCargar = teclado.nextInt();

                        //Crear una nueva tarjeta
                        tarjetas[contadorTarjetas] = terminales[0].crearTarjeta(dineroCargar);
                        contadorTarjetas++;

                        break;
                    case 2:

                        System.out.print("Introduzca su tarjeta: ");

                        tarjetaSeleccionada = teclado.nextInt()-1;

                        if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                            System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                        } else {
                            if (tarjetas[tarjetaSeleccionada] == null) {
                                System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                            } else {
                                System.out.print("Cuánto dinero desea cargar en su tarjeta: ");
                                dineroCargar = teclado.nextInt();

                                if (dineroCargar <= 0) {
                                    System.out.println(Colores.RED + "La cantidad de dinero a cargar debe ser positiva" + Colores.RESET);
                                } else {
                                    terminales[0].cargarTarjeta(tarjetas[tarjetaSeleccionada], dineroCargar);
                                    System.out.println("¡Carga exitosa!");
                                }
                            }
                        }

                        break;
                    case 3:

                        System.out.print("Introduzca su tarjeta: ");
                        tarjetaSeleccionada = teclado.nextInt()-1;
                        if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                            System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                        } else {
                            if (tarjetas[tarjetaSeleccionada] == null) {
                                System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);

                            } else {
                                System.out.println();
                                System.out.println("\t"+Colores.BLUE + tarjetas[tarjetaSeleccionada].toString().replace("\n", Colores.BLUE + "\n\t") + Colores.RESET);
                            }
                        }

                        break;
                    case 4:
                        int seleccion = -1;
                        do {
                            System.out.println("\nEstas son las opciones de los juegos");
                            System.out.println("1: Ver los juegos\n2: Comprobar si puedo jugar\n3: Jugar\n4: Salir");

                            System.out.print("Que opcion desea: ");

                            seleccion = teclado.nextInt();

                            switch (seleccion) {
                                case 1:
                                    System.out.println();
                                    System.out.println("Estos son los juegos disponibles");
                                    System.out.println(mostrarJuegosDisponibles(juegos));
                                    break;
                                case 2:

                                    System.out.print("Introduce tu tarjeta: ");

                                    tarjetaSeleccionada = teclado.nextInt()-1;
                                    if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                                        System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                                    } else {
                                        if (tarjetas[tarjetaSeleccionada] == null) {
                                            System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                                        } else {
                                            System.out.println();
                                            System.out.println("Estos son los juegos disponibles");
                                            System.out.println(mostrarJuegosDisponibles(juegos));
                                            System.out.print("Cual es el juego que quieres comprobar: ");
                                            seleccion = teclado.nextInt() - 1;
                                            if (seleccion < 0 || seleccion >= juegos.length) {
                                                System.out.println(Colores.RED + "El juego seleccionada no es válida" + Colores.RESET);
                                            } else {
                                                if (juegos[seleccion] == null) {
                                                    System.out.println(Colores.RED + "El juego seleccionada no es válida" + Colores.RESET);
                                                } else {
                                                    if (juegos[seleccion].comprobarCreditosNecesarios(tarjetas[tarjetaSeleccionada])) {
                                                        System.out.println("Puede jugar y le quedaran: " + (tarjetas[tarjetaSeleccionada].getCreditos() - juegos[seleccion].getCreditosNecesarios()));
                                                    } else {
                                                        System.out.println("No dispone de los creditos necesarios");
                                                    }

                                                }
                                            }
                                        }
                                    }

                                    break;
                                case 3:
                                    System.out.print("Introduce tu tarjeta: ");

                                    tarjetaSeleccionada = teclado.nextInt()-1;
                                    if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                                        System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                                    } else {
                                        if (tarjetas[tarjetaSeleccionada] == null) {
                                            System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                                        } else {
                                            System.out.println();
                                            System.out.println("Estos son los juegos disponibles");
                                            System.out.println(mostrarJuegosDisponibles(juegos));
                                            System.out.print("Cual es el juego que quieres jugar: ");
                                            seleccion = teclado.nextInt() - 1;
                                            if (seleccion < 0 || seleccion >= juegos.length) {
                                                System.out.println(Colores.RED + "El jeugo seleccionada no es válida" + Colores.RESET);
                                            } else {
                                                if (juegos[seleccion] == null) {
                                                    System.out.println(Colores.RED + "El juego seleccionada no es válida" + Colores.RESET);
                                                } else {
                                                    if (juegos[seleccion].comprobarCreditosNecesarios(tarjetas[tarjetaSeleccionada])) {
                                                        juegos[seleccion].jugar(tarjetas[tarjetaSeleccionada]);
                                                    } else {
                                                        System.out.println("No dispone de los creditos necesarios");
                                                    }

                                                }
                                            }
                                        }
                                    }
                                case 4:
                                    break;
                                default:
                                    System.out.println(Colores.RED + "Opcion no valida" + Colores.RESET);

                            }

                        } while (seleccion != 4);
                        break;

                    case 5:
                        do {
                            System.out.println("\n\tEstas son las opciones de los premios: \n\t1: Ver premios \n\t2: Canjear premios. \n\t3: Volver.");
                            System.out.print("\tQue accion desea realizar: ");
                            opcion = teclado.nextInt();
                            switch (opcion) {
                                case 1:
                                    System.out.println("Estos son los premios disponibles");
                                    System.out.println(mostrarNombrePremios(terminales, premios));
                                    break;
                                case 2:
                                    System.out.print("Introduce tu tarjeta: ");

                                    tarjetaSeleccionada = teclado.nextInt()-1;
                                    if (tarjetaSeleccionada < 0 || tarjetaSeleccionada >= tarjetas.length) {
                                        System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                                    } else {
                                        if (tarjetas[tarjetaSeleccionada] == null) {
                                            System.out.println(Colores.RED + "La tarjeta seleccionada no es válida" + Colores.RESET);
                                        } else {
                                            System.out.println("Estos son los premios disponibles");
                                            System.out.println(terminales[0].verPremios());
                                            System.out.print("Que premio desea obtener: ");

                                            premioSeleccionado = teclado.nextInt() - 1;
                                            if (premioSeleccionado > 3 || premioSeleccionado < 0) {
                                                System.out.println(Colores.RED + "El premio seleccionada no es válida" + Colores.RESET);
                                            } else {
                                                terminales[0].canjearPremios(premios[premioSeleccionado], tarjetas[tarjetaSeleccionada]);

                                            }
                                        }
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println(Colores.RED+"Opcion seleccionada no valida" + Colores.RESET);
                            }

                        } while (opcion != 3);
                    case 6:
                        break;
                    default:
                        System.out.println(Colores.RED + "Opcion seleccionada no valida" + Colores.RESET);

                }
            } catch (InputMismatchException ex) {
                System.out.println(Colores.RED + "El valor introducido no es valido, porfavot introduzca un numero entero" + Colores.RESET);
                teclado.nextLine();
            }
        } while (opcion != 6);
    }

    public static String mostrarJuegosDisponibles(Juego juegos[]) {
        int contador = 0;
        String juegosDisponibles = "";
        while (juegos[contador] != null) {
            juegosDisponibles += "\t" + (contador + 1) + ": " + juegos[contador].getNombre() + "\n";
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
                resultado += "\n\t" + (contador + 1) + ": " + premios[contador].getNombre() + ", tickets necesarios" + premios[contador].getTicketsNecesarios();
            }
            contador++;
        }
        return resultado;
    }

}
