package pe.edu.lamolina.model.comedor;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class BloqueoAlumnoComedorTest {

    @Test
    public void equals_null_test() {
        BloqueoAlumnoComedor blq1 = new BloqueoAlumnoComedor();
        BloqueoAlumnoComedor blq2 = null;

        log.info("blq1 -> blq2(null) equals = {}", blq1.equals(blq2));
        assertFalse(blq1.equals(blq2));
    }

    @Test
    public void equals_ids_null_test() {
        BloqueoAlumnoComedor blq1 = new BloqueoAlumnoComedor();
        BloqueoAlumnoComedor blq2 = new BloqueoAlumnoComedor();

        log.info("blq1.id(null) -> blq2.id(null) equals = {}", blq1.equals(blq2));
        assertTrue(blq1.equals(blq2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        BloqueoAlumnoComedor blq1 = new BloqueoAlumnoComedor(1);
        BloqueoAlumnoComedor blq2 = new BloqueoAlumnoComedor(2);

        log.info("blq1.id(1) -> blq2.id(2) equals = {}", blq1.equals(blq2));
        assertFalse(blq1.equals(blq2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        BloqueoAlumnoComedor blq1 = new BloqueoAlumnoComedor(4);
        BloqueoAlumnoComedor blq2 = new BloqueoAlumnoComedor("4");

        log.info("blq1.id(4) -> blq2.id(4) equals = {}", blq1.equals(blq2));
        assertTrue(blq1.equals(blq2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        BloqueoAlumnoComedor blq1 = new BloqueoAlumnoComedor(4);
        BloqueoAlumnoComedor blq2 = new BloqueoAlumnoComedor();

        log.info("blq1.id(4) -> blq2.id() equals = {}", blq1.equals(blq2));
        assertFalse(blq1.equals(blq2));
    }
}
