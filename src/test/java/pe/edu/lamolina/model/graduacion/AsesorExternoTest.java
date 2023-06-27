package pe.edu.lamolina.model.graduacion;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class AsesorExternoTest {

    @Test
    public void equals_null_test() {
        AsesorExterno ae1 = new AsesorExterno();
        AsesorExterno ae2 = null;

        log.info("ae1 -> ae2(null) equals = {}", ae1.equals(ae2));
        assertFalse(ae1.equals(ae2));
    }

    @Test
    public void equals_ids_null_test() {
        AsesorExterno ae1 = new AsesorExterno();
        AsesorExterno ae2 = new AsesorExterno();

        log.info("ae1.id(null) -> ae2.id(null) equals = {}", ae1.equals(ae2));
        assertTrue(ae1.equals(ae2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        AsesorExterno ae1 = new AsesorExterno(1);
        AsesorExterno ae2 = new AsesorExterno(2);

        log.info("ae1.id(1) -> ae2.id(2) equals = {}", ae1.equals(ae2));
        assertFalse(ae1.equals(ae2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        AsesorExterno ae1 = new AsesorExterno(4);
        AsesorExterno ae2 = new AsesorExterno("4");

        log.info("ae1.id(4) -> ae2.id(4) equals = {}", ae1.equals(ae2));
        assertTrue(ae1.equals(ae2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        AsesorExterno ae1 = new AsesorExterno(4);
        AsesorExterno ae2 = new AsesorExterno();

        log.info("ae1.id(4) -> ae2.id() equals = {}", ae1.equals(ae2));
        assertFalse(ae1.equals(ae2));
    }
}
