package pe.edu.lamolina.model.aporte;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pe.edu.lamolina.model.academico.ModalidadEstudio;

@Slf4j
public class AporteCicloTest {

    @Test
    public void equals_null_test() {
        AporteCiclo apc1 = new AporteCiclo();
        AporteCiclo apc2 = null;

        log.info("apc1 -> apc2(null) equals = {}", apc1.equals(apc2));
        assertFalse(apc1.equals(apc2));
    }

    @Test
    public void equals_ids_null_test() {
        AporteCiclo apc1 = new AporteCiclo();
        AporteCiclo apc2 = new AporteCiclo();

        log.info("apc1.id(null) -> apc2.id(null) equals = {}", apc1.equals(apc2));
        assertTrue(apc1.equals(apc2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        AporteCiclo apc1 = new AporteCiclo(1);
        AporteCiclo apc2 = new AporteCiclo(2);

        log.info("apc1.id(1) -> apc2.id(2) equals = {}", apc1.equals(apc2));
        assertFalse(apc1.equals(apc2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        AporteCiclo apc1 = new AporteCiclo(4);
        AporteCiclo apc2 = new AporteCiclo("4");

        log.info("apc1.id(4) -> apc2.id(4) equals = {}", apc1.equals(apc2));
        assertTrue(apc1.equals(apc2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        AporteCiclo apc1 = new AporteCiclo(4);
        AporteCiclo apc2 = new AporteCiclo();

        log.info("apc1.id(4) -> apc2.id() equals = {}", apc1.equals(apc2));
        assertFalse(apc1.equals(apc2));
    }
}
