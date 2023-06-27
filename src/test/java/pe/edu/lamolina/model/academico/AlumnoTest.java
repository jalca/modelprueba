package pe.edu.lamolina.model.academico;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class AlumnoTest {

    @Test
    public void equals_null_test() {
        Alumno alu1 = new Alumno();
        Alumno alu2 = null;

        log.info("alu1 -> alu2(null) equals = {}", alu1.equals(alu2));
        assertFalse(alu1.equals(alu2));
    }

    @Test
    public void equals_ids_null_test() {
        Alumno alu1 = new Alumno();
        Alumno alu2 = new Alumno();

        log.info("alu1.id(null) -> alu2.id(null) equals = {}", alu1.equals(alu2));
        assertTrue(alu1.equals(alu2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        Alumno alu1 = new Alumno(1);
        Alumno alu2 = new Alumno(2);

        log.info("alu1.id(1) -> alu2.id(2) equals = {}", alu1.equals(alu2));
        assertFalse(alu1.equals(alu2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        Alumno alu1 = new Alumno(4);
        Alumno alu2 = new Alumno("4");

        log.info("alu1.id(4) -> alu2.id(4) equals = {}", alu1.equals(alu2));
        assertTrue(alu1.equals(alu2));
    }
    
    @Test
    public void equals_ids_notnull_test3() {
        Alumno alu1 = new Alumno(4);
        Alumno alu2 = new Alumno();

        log.info("alu1.id(4) -> alu2.id() equals = {}", alu1.equals(alu2));
        assertFalse(alu1.equals(alu2));
    }
}
