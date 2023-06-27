package pe.edu.lamolina.model.general;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class OficinaTest {

    @Test
    public void equals_null_test() {
        Oficina ofi1 = new Oficina();
        Oficina ofi2 = null;

        log.info("ofi1 -> ofi2(null) equals = {}", ofi1.equals(ofi2));
        assertFalse(ofi1.equals(ofi2));
    }

    @Test
    public void equals_ids_null_test() {
        Oficina ofi1 = new Oficina();
        Oficina ofi2 = new Oficina();

        log.info("ofi1.id(null) -> ofi2.id(null) equals = {}", ofi1.equals(ofi2));
        assertTrue(ofi1.equals(ofi2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        Oficina ofi1 = new Oficina(1);
        Oficina ofi2 = new Oficina(2);

        log.info("ofi1.id(1) -> ofi2.id(2) equals = {}", ofi1.equals(ofi2));
        assertFalse(ofi1.equals(ofi2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        Oficina ofi1 = new Oficina(4);
        Oficina ofi2 = new Oficina("4");

        log.info("ofi1.id(4) -> ofi2.id(4) equals = {}", ofi1.equals(ofi2));
        assertTrue(ofi1.equals(ofi2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        Oficina ofi1 = new Oficina(4);
        Oficina ofi2 = new Oficina();

        log.info("ofi1.id(4) -> ofi2.id() equals = {}", ofi1.equals(ofi2));
        assertFalse(ofi1.equals(ofi2));
    }
}
