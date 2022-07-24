import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonajeTest {

    private Personaje p;

    @Before
    public void setUp() {
        p = new Personaje();
    }

    /* ------- Tests ------- */
    @Test
    public void testEstablecerVida() {
        p.setVida(20);

        int esperado = 20;
        int resultado = p.getVida();

        assertEquals("Estableciendo vida... ", esperado, resultado);
    }

    @Test
    public void testLlenarAtributos() {
        p.setFuerza(5);
        p.setDestreza(7);
        p.setConstitucion(3);
        p.setInteligencia(5);
        p.setSabiduria(5);
        p.setCarisma(8);

        int[] esperado = new int[]{5, 7, 3, 5, 5, 8};
        int[] resultado = new int[]{p.getFuerza(), p.getDestreza(), p.getConstitucion(),
                p.getInteligencia(), p.getSabiduria(), p.getCarisma()};

        assertArrayEquals("Revisando atributos... ", esperado, resultado);
    }

    @Test
    public void testModificarVida() {
        int vidaInicial = p.getVida();

        p.setVida(p.getVida() + 5);

        int esperado = p.getVida();
        int resultado = vidaInicial + 5;

        assertEquals("Revisando modificación de vida... ", esperado, resultado);
    }

    /* --------------------- */
}

