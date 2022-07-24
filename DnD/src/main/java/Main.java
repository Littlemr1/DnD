import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main  {
    public static Scanner teclado = new Scanner(System.in);
    public static ArrayList<Partida> listaPartidas;

    public static void main(String[] args) throws IOException {

        int menu;
        boolean exit = false;
        ArrayList<Partida> listaPartidas = new ArrayList<>();

        do {
            System.out.println("[]==================O==================[]");
            System.out.println("¡Bienvenido a DnD Companion!");
            System.out.println("Puede escoger las opciones de los menús introduciendo el número de la opción que usted desee.");
            System.out.println("1.- Crear Nueva Partida.");
            System.out.println("2.- Cargar Partida.");
            System.out.println("3.- Borrar Partida.");
            System.out.println("0.- Salir.");
            System.out.println("[]==================O==================[]" + "\n");
            System.out.println("Escoja una opción:");
            menu = teclado.nextInt();
            System.out.println();

            switch (menu) {
                case 1:
                    crearPartida();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println(".- Introduzca un número para escoger una opción -." + "\n");
                    break;
            }
        } while (exit == false);

    }
    public static void crearPartida() throws IOException {
        String nombrePartida;
        System.out.println("Ingrese el nombre de la partida:");
        nombrePartida = teclado.next();
        Partida p = new Partida(nombrePartida);
        p.llamar();
        listaPartidas.add(p);


    }



}

