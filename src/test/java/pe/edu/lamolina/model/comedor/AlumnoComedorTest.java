package pe.edu.lamolina.model.comedor;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class AlumnoComedorTest {

    @Test
    public void equals_null_test() {
        AlumnoComedor ac1 = new AlumnoComedor();
        AlumnoComedor ac2 = null;

        log.info("ac1 -> ac2(null) equals = {}", ac1.equals(ac2));
        assertFalse(ac1.equals(ac2));
    }

    @Test
    public void equals_ids_null_test() {
        AlumnoComedor ac1 = new AlumnoComedor();
        AlumnoComedor ac2 = new AlumnoComedor();

        log.info("ac1.id(null) -> ac2.id(null) equals = {}", ac1.equals(ac2));
        assertTrue(ac1.equals(ac2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        AlumnoComedor ac1 = new AlumnoComedor(1);
        AlumnoComedor ac2 = new AlumnoComedor(2);

        log.info("ac1.id(1) -> ac2.id(2) equals = {}", ac1.equals(ac2));
        assertFalse(ac1.equals(ac2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        AlumnoComedor ac1 = new AlumnoComedor(4);
        AlumnoComedor ac2 = new AlumnoComedor("4");

        log.info("ac1.id(4) -> ac2.id(4) equals = {}", ac1.equals(ac2));
        assertTrue(ac1.equals(ac2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        AlumnoComedor ac1 = new AlumnoComedor(4);
        AlumnoComedor ac2 = new AlumnoComedor();

        log.info("ac1.id(4) -> ac2.id() equals = {}", ac1.equals(ac2));
        assertFalse(ac1.equals(ac2));
    }
}
