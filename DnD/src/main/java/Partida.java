import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Partida  {

    public static Scanner teclado = new Scanner(System.in);
    public String nombrePartida;
    public ArrayList<Jugador> listaJugadores;
    public ArrayList<Tesoro> listaTesoros;
    public ArrayList<Personaje> listaEnemigos;

    public Partida(String nombrePartida) {
        this.nombrePartida = nombrePartida;
        listaJugadores   = new ArrayList<>();
        listaTesoros     = new ArrayList<>();
        listaEnemigos    = new ArrayList<>();
    }
    public void llamar() throws IOException {
        int menuLlamar;
        boolean exit = false;

        do {
            System.out.println("[]==================O==================[]");
            System.out.println("[Partida '" + nombrePartida + "']");
            System.out.println("1.- Crear Jugador:");
            System.out.println("2.- Ver Jugadores:");
            System.out.println("3.- Borrar Jugador:");
            System.out.println("4.- Crear Enemigo:");
            System.out.println("5.- Ver Enemigos:");
            System.out.println("6.- Borrar Enemigo:");
            System.out.println("7.- Crear Tesoro:");
            System.out.println("8.- Ver Tesoros:");
            System.out.println("9.- Borrar Tesoro:");
            System.out.println("10.- Tirar Dados:");
            System.out.println("0.- Guardar y Salir.");
            System.out.println("[]==================O==================[]" + "\n");
            System.out.println("Escoja una opción del menú.");
            menuLlamar = teclado.nextInt();
            System.out.println();

            switch (menuLlamar) {

                case 1:
                    crearJugador();
                    break;
                case 2:
                    menuJugadores();
                    break;
                case 3:
                    borrarJugador();
                    break;
                case 4:
                    crearEnemigo();
                    break;
                case 5:
                    menuEnemigos();
                    break;
                case 6:
                    borrarEnemigo();
                    break;
                case 7:
                    crearTesoro();
                    break;
                case 8:
                    verTesoro();
                    break;
                case 9:
                    borrarTesoro();
                    break;
                case 10:
                    tirarDado();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println(".- Introduzca un número del menú para escoger una opción -. " + "\n");
                    break;
            }

        } while (exit == false);
    }

    public void crearJugador() throws IOException {
        Jugador j = new Jugador();
        j.nombrarJugador(j);
        j.escogerClase(j);
        j.establecerVida(j);
        j.llenarAtributos(j);
        listaJugadores.add(j);
        System.out.println("-*- ¡Jugador creado correctamente! -*-" + "\n");
        crearLog(j.getNombre());
    }

    public void menuJugadores() {
        int numJugador;
        boolean flag;

        if (listaJugadores.isEmpty()) {
            System.out.println(".- No hay jugadores registrados -." + "\n");
        } else {
            do {
                for (int i = 0; i < listaJugadores.size(); i++) {
                    System.out.println("[]============(" + (i + 1) + ")============[]");
                    System.out.println(" - Jugador " + (i + 1) + " - ");
                    System.out.println(listaJugadores.get(i));
                    System.out.println("[]============(" + (i + 1) + ")============[]" + "\n");
                }
                System.out.println("[]============O============[]");
                System.out.println("Puede seleccionar a un jugador para modificar sus estadísticas:");
                for (int i = 0; i < listaJugadores.size(); i++) {
                    System.out.println((i + 1) + ".- '" + listaJugadores.get(i).getNombre() + "'");

                }
                System.out.println("0.- Volver.");
                System.out.println("[]============O============[]" + "\n");
                System.out.println("Escoja una opción:");
                numJugador = teclado.nextInt();
                System.out.println();

                if (numJugador == 0) {
                    flag = true;
                } else {
                    if (numJugador > 0 && numJugador <= listaJugadores.size()) {
                        listaJugadores.get(numJugador - 1).modificarJugador();
                        flag = true;
                    } else if (numJugador < 0 || numJugador > listaJugadores.size()) {
                        System.out.println(".- Introduzca un número del menú para escoger una opción -." + "\n");
                        flag = false;
                    } else {
                        flag = true;
                    }
                }

            } while (flag == false);
        }



    }

    public void borrarJugador() {
        int numJugador;
        String jugadorBorrado;
        boolean flag;

        if (listaJugadores.isEmpty()) {
            System.out.println(".- No hay jugadores registrados -." + "\n");
        } else {
            do {
                System.out.println("[]============O============[]");

                for (int i = 0; i < listaJugadores.size(); i++) {
                    System.out.println((i + 1) + ".- '" + listaJugadores.get(i).getNombre() + "'");
                }
                System.out.println("0.- Salir.");
                System.out.println("[]============O============[]" + "\n");
                System.out.println("Escoja a un jugador:");
                numJugador = teclado.nextInt();
                System.out.println();

                if (numJugador < 0 || numJugador > listaJugadores.size()) {
                    System.out.println(".- Introduzca un número del menú para escoger una opción -. " + "\n");
                    flag = false;
                } else if (numJugador > 0 && numJugador <= listaJugadores.size()) {
                    jugadorBorrado = listaJugadores.get(numJugador - 1).getNombre();
                    listaJugadores.remove(numJugador - 1);
                    System.out.println("-*- ¡Jugador '" + jugadorBorrado + "' eliminado correctamente! -*-" + "\n");
                    flag = false;
                } else {
                    flag = true;
                }

                if (listaJugadores.isEmpty()) {
                    flag = true;
                }

            } while (flag == false);
        }
    }

    public void crearEnemigo() {
        Personaje e = new Personaje();
        e.nombrarEnemigo(e, listaEnemigos);
        e.establecerVida(e);
        e.establecerAc(e);
        e.establecerCr(e);
        e.llenarAtributos(e);
        listaEnemigos.add(e);
        System.out.println("-*- ¡Enemigo creado correctamente! -*-" + "\n");
    }

    public void menuEnemigos() {
        int numEnemigo;
        boolean flag;

        if (listaEnemigos.isEmpty()) {
            System.out.println(".- No hay enemigos registrados -." + "\n");
        } else {
            do {

                for (int i = 0; i < listaEnemigos.size(); i++) {
                    System.out.println("[]============(" + (i + 1) + ")============[]");
                    System.out.println(" - Enemigo " + (i + 1) + " - ");
                    System.out.println(listaEnemigos.get(i));
                    System.out.println("[]============(" + (i + 1) + ")============[]" + "\n");
                }
                System.out.println("[]============O============[]");
                System.out.println("Puede seleccionar a un enemigo para modificar sus Puntos de Golpe:");
                for (int i = 0; i < listaEnemigos.size(); i++) {
                    System.out.println((i + 1) + ".- '" + listaEnemigos.get(i).getNombre() + "'");
                }
                System.out.println("0.- Volver.");
                System.out.println("[]============O============[]" + "\n");
                System.out.println("Escoja a un enemigo:");
                numEnemigo = teclado.nextInt();
                System.out.println();

                if (numEnemigo == 0) {
                    flag = true;
                } else {
                    if (numEnemigo > 0 && numEnemigo <= listaEnemigos.size()) {
                        listaEnemigos.get(numEnemigo - 1).modificarVida();
                        flag = true;
                    } else if (numEnemigo < 0 || numEnemigo > listaEnemigos.size()) {
                        System.out.println(".- Introduzca un número del menú para escoger una opción -. " + "\n");
                        flag = false;
                    } else {
                        flag = true;
                    }
                }

            } while (flag == false);
        }
    }

    public void borrarEnemigo() {
        int numEnemigo;
        String enemigoBorrado;
        boolean flag;

        if (listaEnemigos.isEmpty()) {
            System.out.println(".- No hay enemigos registrados -." + "\n");
        } else {
            do {
                System.out.println("[]============O============[]");
                for (int i = 0; i < listaEnemigos.size(); i++) {
                    System.out.println((i + 1) + ".- '" + listaEnemigos.get(i).getNombre() + "'");
                }
                System.out.println("0.- Salir.");
                System.out.println("[]============O============[]" + "\n");
                System.out.println("Escoja a un enemigo:");
                numEnemigo = teclado.nextInt();
                System.out.println();

                if (numEnemigo < 0 || numEnemigo > listaEnemigos.size()) {
                    System.out.println(".- Introduzca un número del menú para escoger una opción -. " + "\n");
                    flag = false;
                } else if (numEnemigo > 0 && numEnemigo <= listaEnemigos.size()) {
                    enemigoBorrado = listaEnemigos.get(numEnemigo - 1).getNombre();
                    listaEnemigos.remove(numEnemigo - 1);
                    System.out.println("-*- ¡Enemigo '" + enemigoBorrado + "' eliminado correctamente! -*-" + "\n");
                    flag = false;
                } else {
                    flag = true;
                }

                if (listaEnemigos.isEmpty()) {
                    flag = true;
                }

            } while (flag == false);
        }
    }

    public void crearTesoro() {
        Tesoro t = new Tesoro();
        t.nombrarTesoro(t, listaTesoros);
        t.darDescripcion(t);
        listaTesoros.add(t);
        System.out.println("-*- ¡Tesoro creado correctamente! -*-" + "\n");
    }

    public void verTesoro() {

        if (listaTesoros.isEmpty()) {
            System.out.println(".- No hay tesoros registrados -." + "\n");
        } else {
            for (int i = 0; i < listaTesoros.size(); i++) {
                System.out.println("[]============(" + (i + 1) + ")============[]");
                System.out.println(" - Tesoro " + (i + 1) + " - ");
                System.out.println(listaTesoros.get(i));
                System.out.println("[]============(" + (i + 1) + ")============[]" + "\n");
            }
        }
    }

    public void borrarTesoro() {
        int numTesoro;
        String tesoroBorrado;
        boolean flag;
        if (listaTesoros.isEmpty()) {
            System.out.println(".- No hay tesoros registrados -." + "\n");
        } else {
            do {
                System.out.println("[]============O============[]");
                for (int i = 0; i < listaTesoros.size(); i++) {
                    System.out.println((i + 1) + ".- '" + listaTesoros.get(i).getNombre() + "'");
                }
                System.out.println("0.- Salir.");
                System.out.println("[]============O============[]" + "\n");
                System.out.println("Escoja un Tesoro:");
                numTesoro = teclado.nextInt();
                System.out.println();

                if (numTesoro < 0 || numTesoro > listaTesoros.size()) {
                    System.out.println(".- Introduzca un número del menú para escoger una opción -. " + "\n");
                    flag = false;
                } else if (numTesoro > 0 && numTesoro <= listaTesoros.size()) {
                    tesoroBorrado = listaTesoros.get(numTesoro - 1).getNombre();
                    listaTesoros.remove(numTesoro - 1);
                    System.out.println("-*- ¡Tesoro '" + tesoroBorrado + "' eliminado correctamente! -*-" + "\n");
                    flag = false;
                } else {
                    flag = true;
                }

                if (listaTesoros.isEmpty()) {
                    flag = true;
                }

            } while (flag == false);
        }
    }

    public void tirarDado(){
        ArrayList<Dado> dado = new ArrayList<>();
        int menuDados;
        boolean flag = false;

        dado.add(new Dado(4));
        dado.add(new Dado(6));
        dado.add(new Dado(8));
        dado.add(new Dado(10));
        dado.add(new Dado(12));
        dado.add(new Dado(20));
        dado.add(new Dado(100));

        do {
            System.out.println("[]============O============[]");
            for (int i = 0; i < dado.size(); i++) {
                System.out.println(dado.get(i).toString(i));
            }
            System.out.println("8.- Reiniciar datos.");
            System.out.println("0.- Volver.");
            System.out.println("[]============O============[]" + "\n");
            System.out.println("Seleccione el dado que desee lanzar:");

            menuDados = teclado.nextInt();
            System.out.println();

            switch (menuDados) {
                case 1:
                    dado.get(0).tirarDado(1);
                    System.out.println("-*- ¡Has conseguido un " + dado.get(0).getResultadoDado() + "! -*-" + "\n");
                    break;
                case 2:
                    dado.get(1).tirarDado(2);
                    System.out.println("-*- ¡Has conseguido un " + dado.get(1).getResultadoDado() + "! -*-" + "\n");
                    break;
                case 3:
                    dado.get(2).tirarDado(3);
                    System.out.println("-*- ¡Has conseguido un " + dado.get(2).getResultadoDado() + "! -*-" + "\n");
                    break;
                case 4:
                    dado.get(3).tirarDado(4);
                    System.out.println("-*- ¡Has conseguido un " + dado.get(3).getResultadoDado() + "! -*-" + "\n");
                    break;
                case 5:
                    dado.get(4).tirarDado(5);
                    System.out.println("-*- ¡Has conseguido un " + dado.get(4).getResultadoDado() + "! -*-" + "\n");
                    break;
                case 6:
                    dado.get(5).tirarDado(6);
                    System.out.println("-*- ¡Has conseguido un " + dado.get(5).getResultadoDado() + "! -*-" + "\n");
                    break;
                case 7:
                    dado.get(6).tirarDado(7);
                    System.out.println("-*- ¡Has conseguido un " + dado.get(6).getResultadoDado() + "! -*-" + "\n");
                    break;
                case 8:
                    for (int i = 0; i < dado.size(); i++) {
                        dado.get(i).reiniciarTiradas();
                        dado.get(i).reiniciarAcumulacion();
                    }
                    System.out.println("-*- ¡Datos reiniciados correctamente! -*-" + "\n");
                    break;
                case 0:
                    flag = true;
                    break;
                default:
                    System.out.println(".- Introduzca un número del menú para escoger una opción -. " + "\n");
                    break;
            }

        } while (flag == false);
    }

    public void crearLog(String nombre) throws IOException {
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fileLog = new FileHandler("registroJugadores.log");
        logger.addHandler(fileLog);
        SimpleFormatter formatter = new SimpleFormatter();
        fileLog.setFormatter(formatter);
        logger.info("se registro a jugador "+nombre);
    }



    @Override
    public String toString() {
        return nombrePartida;
    }


}

