public class Dado {


    private int tipoDado;
    private int resultadoDado;

    protected int tiradas;
    protected int acumulacion;

    public Dado(int tipoDado) {
        this.tipoDado = tipoDado;
    }

    public void tirarDado(int tipoDado) {
        int numeroCaras = 0;

        switch (tipoDado) {
            case 1:
                numeroCaras = 4;
                tiradas++;
                break;
            case 2:
                numeroCaras = 6;
                tiradas++;
                break;
            case 3:
                numeroCaras = 8;
                tiradas++;
                break;
            case 4:
                numeroCaras = 10;
                tiradas++;
                break;
            case 5:
                numeroCaras = 12;
                tiradas++;
                break;
            case 6:
                numeroCaras = 20;
                tiradas++;
                break;
            case 7:
                numeroCaras = 100;
                tiradas++;
                break;
            default:
                break;
        }

        resultadoDado = (int) ((Math.random() * numeroCaras) + 1);

        acumulacion += resultadoDado;
    }

    public void reiniciarTiradas() {
        tiradas = 0;
    }

    public void reiniciarAcumulacion() {
        acumulacion = 0;
    }

    public int getResultadoDado() {
        return resultadoDado;
    }

    // Imprime todos los tipos de dados con sus respectivas cantidades de tiradas y acumulaciones dentro de un ciclo for.
    public String toString(int i) {
        return (i + 1) + ".- D" + tipoDado + "(" + tiradas + ") = " + acumulacion;
    }
}
