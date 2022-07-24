import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PartidaTest {

    private final ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private final ArrayList<Tesoro> listaTesoros = new ArrayList<>();

    private final Jugador j1 = new Jugador();
    private final Tesoro t1 = new Tesoro();

    @Before
    public void setUp() {
        listaJugadores.add(j1);
        listaTesoros.add(t1);
    }

    /* ------- Tests ------- */
    @Test
    public void testCrearJugador() {
        Jugador j = new Jugador();
        j.setNombre("Camellosky");
        j.setClase("Paladín");
        j.setVida(15);
        j.setFuerza(7);
        j.setDestreza(2);
        j.setConstitucion(6);
        j.setInteligencia(4);
        j.setSabiduria(5);
        j.setCarisma(2);
        listaJugadores.add(j);

        int esperado = 2;
        int resultado = listaJugadores.size();

        assertEquals("Creando jugador... ", esperado, resultado);
    }

    @Test
    public void testBorrarJugador() {
        listaJugadores.remove(j1);

        int esperado = 0;
        int resultado = listaJugadores.size();

        assertEquals("Borrando jugador... ", esperado, resultado);
    }


    @Test
    public void testCrearTesoro() {
        Tesoro t = new Tesoro();
        t.setNombre("Collar maldito");
        t.setDescripcion("Mientras más tiempo lo sujetas, más rápido pierdes la cordura");
        listaTesoros.add(t);

        int esperado = 2;
        int resultado = listaTesoros.size();

        assertEquals("Creando tesoro... ", esperado, resultado);
    }

    @Test
    public void testBorrarTesoro() {
        listaTesoros.remove(t1);

        int esperado = 0;
        int resultado = listaTesoros.size();

        assertEquals("Borrando tesoro... ", esperado, resultado);
    }

    /* --------------------- */

    @After
    public void tearDown() {
        listaJugadores.clear();
    }

}

