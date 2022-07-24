import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class JugadorTest {

    private Jugador j;

    @BeforeEach
    public void setUp() {
        j = new Jugador();
    }

    /* ------- Tests ------- */
    @Test
    public void testNombrarJugador() {
        j.setNombre("El gran Paladín");

        String esperado = "El gran Paladín";
        String resultado = j.getNombre();

        assertEquals("Revisando nombre del jugador... ", esperado, resultado);
    }

    @Test
    public void testEscogerClase() {
        j.setClase("Druida");

        String esperado = "Druida";
        String resultado = j.getClase();

        assertEquals("Revisando clase... ", esperado, resultado);
    }

    @Test
    public void testModificarAtributo() {
        int fuerzaInicial = j.getFuerza();

        j.setFuerza(j.getFuerza() + 1);

        int esperado = j.getFuerza();
        int resultado = ++fuerzaInicial;

        assertEquals("Modificando atributos... ",esperado, resultado);
    }
    /* --------------------- */

}

