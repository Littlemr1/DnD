import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesoroTest {


    private Tesoro t;

    @Before
    public void setUp() {
        t = new Tesoro();
    }

    /* ------- Tests ------- */
    @Test
    public void testNombrarTesoro() {
        t.setNombre("Espada dorada incrustada de gemas");

        String esperado = "Espada dorada incrustada de gemas";
        String resultado = t.getNombre();

        assertEquals("Revisando nombre del tesoro... ", esperado, resultado);
    }

    @Test
    public void darDescripcion() {
        t.setDescripcion("Se ve algo desgastada. Es probable que le haya pertenecido a algún rey antiguo.");

        String esperado = "Se ve algo desgastada. Es probable que le haya pertenecido a algún rey antiguo.";
        String resultado = t.getDescripcion();

        assertEquals("Revisando descripción... ", esperado, resultado);
    }
    /* --------------------- */
}

