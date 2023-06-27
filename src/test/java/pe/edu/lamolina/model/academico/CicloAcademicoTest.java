package pe.edu.lamolina.model.academico;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;

@Slf4j
public class CicloAcademicoTest {

    @Test
    public void equals_null_test() {
        CicloAcademico ciclo1 = new CicloAcademico();
        CicloAcademico ciclo2 = null;

        log.info("ciclo1 -> ciclo2(null) equals = {}", ciclo1.equals(ciclo2));
        assertFalse(ciclo1.equals(ciclo2));
    }

    @Test
    public void equals_ids_null_test() {
        CicloAcademico ciclo1 = new CicloAcademico();
        CicloAcademico ciclo2 = new CicloAcademico();

        log.info("ciclo1.id(null) -> ciclo2.id(null) equals = {}", ciclo1.equals(ciclo2));
        assertTrue(ciclo1.equals(ciclo2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        CicloAcademico ciclo1 = new CicloAcademico(1);
        CicloAcademico ciclo2 = new CicloAcademico(2);

        log.info("ciclo1.id(1) -> ciclo2.id(2) equals = {}", ciclo1.equals(ciclo2));
        assertFalse(ciclo1.equals(ciclo2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        CicloAcademico ciclo1 = new CicloAcademico(4);
        CicloAcademico ciclo2 = new CicloAcademico("4");

        log.info("ciclo1.id(4) -> ciclo2.id(4) equals = {}", ciclo1.equals(ciclo2));
        assertTrue(ciclo1.equals(ciclo2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        CicloAcademico ciclo1 = new CicloAcademico(4);
        CicloAcademico ciclo2 = new CicloAcademico();

        log.info("ciclo1.id(4) -> ciclo2.id() equals = {}", ciclo1.equals(ciclo2));
        assertFalse(ciclo1.equals(ciclo2));
    }
}
