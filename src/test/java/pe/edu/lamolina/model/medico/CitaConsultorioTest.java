package pe.edu.lamolina.model.medico;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class CitaConsultorioTest {

    @Test
    public void equals_null_test() {
        CitaConsultorio cc1 = new CitaConsultorio();
        CitaConsultorio cc2 = null;

        log.info("cc1 -> cc2(null) equals = {}", cc1.equals(cc2));
        assertFalse(cc1.equals(cc2));
    }

    @Test
    public void equals_ids_null_test() {
        CitaConsultorio cc1 = new CitaConsultorio();
        CitaConsultorio cc2 = new CitaConsultorio();

        log.info("cc1.id(null) -> cc2.id(null) equals = {}", cc1.equals(cc2));
        assertTrue(cc1.equals(cc2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        CitaConsultorio cc1 = new CitaConsultorio(1);
        CitaConsultorio cc2 = new CitaConsultorio(2);

        log.info("cc1.id(1) -> cc2.id(2) equals = {}", cc1.equals(cc2));
        assertFalse(cc1.equals(cc2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        CitaConsultorio cc1 = new CitaConsultorio(4);
        CitaConsultorio cc2 = new CitaConsultorio("4");

        log.info("cc1.id(4) -> cc2.id(4) equals = {}", cc1.equals(cc2));
        assertTrue(cc1.equals(cc2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        CitaConsultorio cc1 = new CitaConsultorio(4);
        CitaConsultorio cc2 = new CitaConsultorio();

        log.info("cc1.id(4) -> cc2.id() equals = {}", cc1.equals(cc2));
        assertFalse(cc1.equals(cc2));
    }
}
