package pe.edu.lamolina.model.academico;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class TipoActividadIngresanteTest {

    @Test
    public void equals_null_test() {
        TipoActividadIngresante tai1 = new TipoActividadIngresante();
        TipoActividadIngresante tai2 = null;

        log.info("tai1 -> tai2(null) equals = {}", tai1.equals(tai2));
        assertFalse(tai1.equals(tai2));
    }

    @Test
    public void equals_ids_null_test() {
        TipoActividadIngresante tai1 = new TipoActividadIngresante();
        TipoActividadIngresante tai2 = new TipoActividadIngresante();

        log.info("tai1.id(null) -> tai2.id(null) equals = {}", tai1.equals(tai2));
        assertTrue(tai1.equals(tai2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        TipoActividadIngresante tai1 = new TipoActividadIngresante(1);
        TipoActividadIngresante tai2 = new TipoActividadIngresante(2);

        log.info("tai1.id(1) -> tai2.id(2) equals = {}", tai1.equals(tai2));
        assertFalse(tai1.equals(tai2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        TipoActividadIngresante tai1 = new TipoActividadIngresante(4);
        TipoActividadIngresante tai2 = new TipoActividadIngresante("4");

        log.info("tai1.id(4) -> tai2.id(4) equals = {}", tai1.equals(tai2));
        assertTrue(tai1.equals(tai2));
    }
    
    @Test
    public void equals_ids_notnull_test3() {
        TipoActividadIngresante tai1 = new TipoActividadIngresante(4);
        TipoActividadIngresante tai2 = new TipoActividadIngresante();

        log.info("tai1.id(4) -> tai2.id() equals = {}", tai1.equals(tai2));
        assertFalse(tai1.equals(tai2));
    }
}
