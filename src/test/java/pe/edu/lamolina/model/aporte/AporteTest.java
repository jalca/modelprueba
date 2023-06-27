package pe.edu.lamolina.model.aporte;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class AporteTest {

    @Test
    public void equals_null_test() {
        Aporte apo1 = new Aporte();
        Aporte apo2 = null;

        log.info("apo1 -> apo2(null) equals = {}", apo1.equals(apo2));
        assertFalse(apo1.equals(apo2));
    }

    @Test
    public void equals_ids_null_test() {
        Aporte apo1 = new Aporte();
        Aporte apo2 = new Aporte();

        log.info("apo1.id(null) -> apo2.id(null) equals = {}", apo1.equals(apo2));
        assertTrue(apo1.equals(apo2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        Aporte apo1 = new Aporte(1);
        Aporte apo2 = new Aporte(2);

        log.info("apo1.id(1) -> apo2.id(2) equals = {}", apo1.equals(apo2));
        assertFalse(apo1.equals(apo2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        Aporte apo1 = new Aporte(4);
        Aporte apo2 = new Aporte("4");

        log.info("apo1.id(4) -> apo2.id(4) equals = {}", apo1.equals(apo2));
        assertTrue(apo1.equals(apo2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        Aporte apo1 = new Aporte(4);
        Aporte apo2 = new Aporte();

        log.info("apo1.id(4) -> apo2.id() equals = {}", apo1.equals(apo2));
        assertFalse(apo1.equals(apo2));
    }
}
