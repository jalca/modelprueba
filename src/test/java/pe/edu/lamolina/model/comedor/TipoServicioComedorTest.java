package pe.edu.lamolina.model.comedor;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class TipoServicioComedorTest {

    @Test
    public void equals_null_test() {
        TipoServicioComedor tipo1 = new TipoServicioComedor();
        TipoServicioComedor tipo2 = null;

        log.info("tsc1 -> tsc2(null) equals = {}", tipo1.equals(tipo2));
        assertFalse(tipo1.equals(tipo2));
    }

    @Test
    public void equals_ids_null_test() {
        TipoServicioComedor tipo1 = new TipoServicioComedor();
        TipoServicioComedor tipo2 = new TipoServicioComedor();

        log.info("tsc1.id(null) -> tsc2.id(null) equals = {}", tipo1.equals(tipo2));
        assertTrue(tipo1.equals(tipo2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        TipoServicioComedor tipo1 = new TipoServicioComedor(1);
        TipoServicioComedor tipo2 = new TipoServicioComedor(2);

        log.info("tsc1.id(1) -> tsc2.id(2) equals = {}", tipo1.equals(tipo2));
        assertFalse(tipo1.equals(tipo2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        TipoServicioComedor tipo1 = new TipoServicioComedor(4);
        TipoServicioComedor tipo2 = new TipoServicioComedor("4");

        log.info("tsc1.id(4) -> tsc2.id(4) equals = {}", tipo1.equals(tipo2));
        assertTrue(tipo1.equals(tipo2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        TipoServicioComedor tipo1 = new TipoServicioComedor(4);
        TipoServicioComedor tipo2 = new TipoServicioComedor();

        log.info("tipo1.id(4) -> tipo2.id() equals = {}", tipo1.equals(tipo2));
        assertFalse(tipo1.equals(tipo2));
    }
}
