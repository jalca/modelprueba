package pe.edu.lamolina.model.general;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class PersonaTest {

    @Test
    public void equals_null_test() {
        Persona per1 = new Persona();
        Persona per2 = null;

        log.info("per1 -> per2(null) equals = {}", per1.equals(per2));
        assertFalse(per1.equals(per2));
    }

    @Test
    public void equals_ids_null_test() {
        Persona per1 = new Persona();
        Persona per2 = new Persona();

        log.info("per1.id(null) -> per2.id(null) equals = {}", per1.equals(per2));
        assertTrue(per1.equals(per2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        Persona per1 = new Persona(1);
        Persona per2 = new Persona(2);

        log.info("per1.id(1) -> per2.id(2) equals = {}", per1.equals(per2));
        assertFalse(per1.equals(per2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        Persona per1 = new Persona(4);
        Persona per2 = new Persona("4");

        log.info("per1.id(4) -> per2.id(4) equals = {}", per1.equals(per2));
        assertTrue(per1.equals(per2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        Persona per1 = new Persona(4);
        Persona per2 = new Persona();

        log.info("per1.id(4) -> per2.id() equals = {}", per1.equals(per2));
        assertFalse(per1.equals(per2));
    }
}
