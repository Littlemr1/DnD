

public class Jugador extends Personaje {

    protected String clase = "";

    public Jugador() {

    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void ajustarFuerza(int positNegat) {
        fuerza = fuerza + positNegat;
    }

    public void ajustarDestreza(int positNegat) {
        destreza = destreza + positNegat;
    }

    public void ajustarConstitucion(int positNegat) {
        constitucion = constitucion + positNegat;
    }

    public void ajustarInteligencia(int positNegat) {
        inteligencia = inteligencia + positNegat;
    }

    public void ajustarSabiduria(int positNegat) {
        sabiduria = sabiduria + positNegat;
    }

    public void ajustarCarisma(int positNegat) {
        carisma = carisma + positNegat;
    }

    public void nombrarJugador(Jugador p) {
        String nombreJugador;
        System.out.println("Ingrese el nombre del jugador");
        nombreJugador = teclado.next();
        p.setNombre(nombreJugador);
    }
    public void escogerClase(Jugador j) {
        int menuClases;
        boolean flag;
        String[] clases = new String[]{"Bárbaro",
                "Bardo",
                "Brujo",
                "Cazador",
                "Clérigo",
                "Druida",
                "Guerrero",
                "Hechicero",
                "Mago",
                "Monje",
                "Paladín",
                "Pícaro"};

        do {
            System.out.println("[]============O============[]");
            System.out.println(" - Clases - ");

            for (int i = 0; i < clases.length; i++) {
                System.out.println((i + 1) + ".- " + clases[i] + ".");
            }
            System.out.println("[]============O============[]" + "\n");

            System.out.println("Escoja una clase:");
            menuClases = teclado.nextInt();

            if (menuClases > 0 && menuClases <= clases.length) {
                j.setClase(clases[menuClases - 1]);
                System.out.println("\n" + "-*- ¡Has escogido la clase '" + j.getClase() + "'! -*-" + "\n");
                flag = true;
            } else {
                System.out.println("\n" + ".- Introduzca un número para escoger una opción -." + "\n");
                flag = false;
            }
        } while (flag == false);
    }

    public void modificarJugador() {
        int menu;
        boolean flag = false;

        do {
            System.out.println("¿Qué desea hacer con '" + getNombre() + "'?");
            System.out.println("1.- Modificar Vida.");
            System.out.println("2.- Modificar Atributo.");
            System.out.println("0.- Volver.");
            menu = teclado.nextInt();
            System.out.println();

            switch (menu) {
                case 1:
                    modificarVida();
                    break;
                case 2:
                    modificarAtributo();
                    break;
                case 0:
                    flag = true;
                    break;
                default:
                    System.out.println(".- Introduzca un número del menú para escoger una opción -." + "\n");
                    break;
            }
        } while (flag == false);
    }



    public void modificarAtributo() {
        int ajuste;
        int menuAtributos;
        boolean flag1;
        boolean flag2 = false;

        do {
            flag1 = true;
            System.out.println("¿Qué desea hacer con los atributos?");
            System.out.println("1.- Aumentar.");
            System.out.println("2.- Reducir.");
            ajuste = teclado.nextInt();
            System.out.println();

            switch (ajuste) {
                case 1:
                    ajuste = 1;
                    break;
                case 2:
                    ajuste = -1;
                    break;
                default:
                    System.out.println(".- Introduzca un número del menú para escoger una opción -." + "\n");
                    flag1 = false;
                    break;
            }
        } while (flag1 == false);

        do {
            System.out.println("[]============O============[]");
            System.out.println("1.- Fuerza       +/- 1 (" + getFuerza() + ")");
            System.out.println("2.- Destreza     +/- 1 (" + getDestreza() + ")");
            System.out.println("3.- Constitución +/- 1 (" + getConstitucion() + ")");
            System.out.println("4.- Inteligencia +/- 1 (" + getInteligencia() + ")");
            System.out.println("5.- Sabiduría    +/- 1 (" + getSabiduria() + ")");
            System.out.println("6.- Carisma      +/- 1 (" + getCarisma() + ")");
            System.out.println("0.- Terminar.");
            System.out.println("[]============O============[]" + "\n");
            System.out.println("Escoja una opción:");
            menuAtributos = teclado.nextInt();
            System.out.println();

            switch (menuAtributos) {
                case 1:
                    ajustarFuerza(ajuste);
                    break;
                case 2:
                    ajustarDestreza(ajuste);
                    break;
                case 3:
                    ajustarConstitucion(ajuste);
                    break;
                case 4:
                    ajustarInteligencia(ajuste);
                    break;
                case 5:
                    ajustarSabiduria(ajuste);
                    break;
                case 6:
                    ajustarCarisma(ajuste);
                    break;
                case 0:
                    flag2 = true;
                    break;
                default:
                    System.out.println(".- Introduzca un número del menú para escoger una opción -." + "\n");
                    break;
            }
        } while (flag2 == false);
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\n" + "Clase: " + clase
                + "\n" + "Vida: " + vida
                + "\n" + "Fuerza: " + fuerza
                + "\n" + "Destreza: " + destreza
                + "\n" + "Constitución: " + constitucion
                + "\n" + "Inteligencia: " + inteligencia
                + "\n" + "Sabiduría: " + sabiduria
                + "\n" + "Carisma: " + carisma;
    }

}

/*
Player nombre jugador

Entidad nombre personaje nombre enemigo

Allyes toma el nombre

character atributos nombre
characters array de character
 */

