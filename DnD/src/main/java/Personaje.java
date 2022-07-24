import java.util.Scanner;
import java.util.ArrayList;

public class Personaje {

    protected String nombre;
    protected int vida;
    protected int fuerza;
    protected int destreza;
    protected int constitucion;
    protected int inteligencia;
    protected int sabiduria;
    protected int carisma;
    public static Scanner teclado = new Scanner(System.in);
    protected int ac;
    protected double cr;

    public Personaje() {

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getAc() {
        return ac;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }

    public double getCr() {
        return cr;
    }

    public void nombrarEnemigo(Personaje p, ArrayList<Personaje> listaEnemigos) {
        boolean flag;
        String nombreEnemigo;

        do {
            flag = true;
            nombreEnemigo = teclado.next();

            for (int i = 0; i < listaEnemigos.size(); i++) {
                if (nombreEnemigo.equalsIgnoreCase(listaEnemigos.get(i).nombre)) {
                    System.out.println(".- El nombre '" + nombreEnemigo + "' ya está registrado -." + "\n");
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        } while (flag == false);
        p.setNombre(nombreEnemigo);
    }
    public void establecerAc(Personaje e) {
        System.out.println("Ingrese su AC (Armor Class):");
        e.ac = teclado.nextInt();
        System.out.println();
    }

    public void establecerCr(Personaje e) {
        System.out.println("Ingrese su CR (Challenge Rate):");
        e.cr = teclado.nextDouble();
        System.out.println();
    }

    public void establecerVida(Personaje p) {
        System.out.println("Ingrese los Puntos de Golpe para designar a su personaje:");
        System.out.print("HP: ");

        p.setVida(teclado.nextInt());
        System.out.println();
    }

    public void llenarAtributos(Personaje p) {
        System.out.println("Ingrese los valores de sus Atributos:");
        System.out.print("\n" + "Fuerza: ");
        p.setFuerza(teclado.nextInt());
        System.out.print("Destreza: ");
        p.setDestreza(teclado.nextInt());
        System.out.print("Constitucion: ");
        p.setConstitucion(teclado.nextInt());
        System.out.print("Inteligencia: ");
        p.setInteligencia(teclado.nextInt());
        System.out.print("Sabiduria: ");
        p.setSabiduria(teclado.nextInt());
        System.out.print("Carisma: ");
        p.setCarisma(teclado.nextInt());
        System.out.println();
    }

    public void modificarVida() {
        System.out.println("Ingrese la cantidad de Puntos de Golpe a modificar:");
        System.out.println("(Si quiere restar, coloque un signo ( - ) antes del número.)");
        vida += teclado.nextInt();
        System.out.println("\n" + "-*- ¡Puntos de Golpe modificados correctamente! -*-" + "\n");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\n" + "Vida: " + vida
                + "\n" + "AC: " + ac
                + "\n" + "CR: " + cr
                + "\n" + "Fuerza: " + fuerza
                + "\n" + "Destreza: " + destreza
                + "\n" + "Constritucion: " + constitucion
                + "\n" + "Inteligencia: " + inteligencia
                + "\n" + "Sabiduría: " + sabiduria
                + "\n" + "Carisma: " + carisma;
    }
}
