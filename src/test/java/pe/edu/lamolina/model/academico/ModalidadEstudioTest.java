package pe.edu.lamolina.model.academico;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class ModalidadEstudioTest {

    @Test
    public void equals_null_test() {
        ModalidadEstudio me1 = new ModalidadEstudio();
        ModalidadEstudio me2 = null;

        log.info("me1 -> me2(null) equals = {}", me1.equals(me2));
        assertFalse(me1.equals(me2));
    }

    @Test
    public void equals_ids_null_test() {
        ModalidadEstudio me1 = new ModalidadEstudio();
        ModalidadEstudio me2 = new ModalidadEstudio();

        log.info("me1.id(null) -> me2.id(null) equals = {}", me1.equals(me2));
        assertTrue(me1.equals(me2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        ModalidadEstudio me1 = new ModalidadEstudio(1);
        ModalidadEstudio me2 = new ModalidadEstudio(2);

        log.info("me1.id(1) -> me2.id(2) equals = {}", me1.equals(me2));
        assertFalse(me1.equals(me2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        ModalidadEstudio me1 = new ModalidadEstudio(4);
        ModalidadEstudio me2 = new ModalidadEstudio("4");

        log.info("me1.id(4) -> me2.id(4) equals = {}", me1.equals(me2));
        assertTrue(me1.equals(me2));
    }
    
    @Test
    public void equals_ids_notnull_test3() {
        ModalidadEstudio me1 = new ModalidadEstudio(4);
        ModalidadEstudio me2 = new ModalidadEstudio();

        log.info("me1.id(4) -> me2.id() equals = {}", me1.equals(me2));
        assertFalse(me1.equals(me2));
    }
}
