package pe.edu.lamolina.model.general;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class IdiomaTest {

    @Test
    public void equals_null_test() {
        Idioma idio1 = new Idioma();
        Idioma idio2 = null;

        log.info("idio1 -> idio2(null) equals = {}", idio1.equals(idio2));
        assertFalse(idio1.equals(idio2));
    }

    @Test
    public void equals_ids_null_test() {
        Idioma idio1 = new Idioma();
        Idioma idio2 = new Idioma();

        log.info("idio1.id(null) -> idio2.id(null) equals = {}", idio1.equals(idio2));
        assertTrue(idio1.equals(idio2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        Idioma idio1 = new Idioma(1);
        Idioma idio2 = new Idioma(2);

        log.info("idio1.id(1) -> idio2.id(2) equals = {}", idio1.equals(idio2));
        assertFalse(idio1.equals(idio2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        Idioma idio1 = new Idioma(4);
        Idioma idio2 = new Idioma("4");

        log.info("idio1.id(4) -> idio2.id(4) equals = {}", idio1.equals(idio2));
        assertTrue(idio1.equals(idio2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        Idioma idio1 = new Idioma(4);
        Idioma idio2 = new Idioma();

        log.info("idio1.id(4) -> idio2.id() equals = {}", idio1.equals(idio2));
        assertFalse(idio1.equals(idio2));
    }
}
