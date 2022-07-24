import java.util.ArrayList;
import java.util.Scanner;

public class Tesoro {

    protected String nombre;
    protected String descripcion;

    public Tesoro() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void nombrarTesoro(Tesoro t, ArrayList<Tesoro> listaTesoros) {
        boolean flag;
        String nombreTesoro;

        do {
            flag = true;
            nombreTesoro = comprobarString();

            for (int i = 0; i < listaTesoros.size(); i++) {
                if (nombreTesoro.equalsIgnoreCase(listaTesoros.get(i).nombre)) {
                    System.out.println(".- El nombre '" + nombreTesoro + "' ya está registrado -." + "\n");
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        } while (flag == false);
        t.setNombre(nombreTesoro);
    }

    public void darDescripcion(Tesoro t) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escriba su Descripcion: ");
        String desc = teclado.nextLine();
        System.out.println();
        t.setDescripcion(desc);
    }

    public String comprobarString() {
        Scanner teclado = new Scanner(System.in);
        String nombreTesoro;
        boolean flag;

        do {
            System.out.println("Ingrese el nombre del tesoro:");
            nombreTesoro = teclado.nextLine();
            char[] palabra = nombreTesoro.toCharArray();
            System.out.println();

            String charInicial = String.valueOf(palabra[0]);
            String charFinal = String.valueOf(palabra[nombreTesoro.length() - 1]);
            if (" ".equals(charInicial) || " ".equals(charFinal)) {
                System.out.println(".- El nombre no puede comenzar ni terminar con espacio -." + "\n");
                flag = false;
            } else {
                flag = true;
            }
        } while (flag == false);
        return nombreTesoro;
    }

    public String toString() {
        return "Nombre: " + nombre
                + "\n" + descripcion;
    }
}