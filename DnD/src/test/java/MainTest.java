import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainTest {

    private ArrayList<Partida> listaPartidas;
    @BeforeEach
    void setup(){
        listaPartidas = new ArrayList<>();

    }
    @Test
    public void Test_crearPartida(){
        String nombrePartida ="partidaPrueba";
        Partida p = new Partida(nombrePartida);
        listaPartidas.add(p);
    }
    @AfterEach
    void clearup(){
        listaPartidas = null;
    }
}
