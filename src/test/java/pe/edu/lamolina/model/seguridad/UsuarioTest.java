package pe.edu.lamolina.model.seguridad;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class UsuarioTest {

    @Test
    public void equals_null_test() {
        Usuario user1 = new Usuario();
        Usuario user2 = null;

        log.info("user1 -> user2(null) equals = {}", user1.equals(user2));
        assertFalse(user1.equals(user2));
    }

    @Test
    public void equals_ids_null_test() {
        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();

        log.info("user1.id(null) -> user2.id(null) equals = {}", user1.equals(user2));
        assertTrue(user1.equals(user2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        Usuario user1 = new Usuario(1);
        Usuario user2 = new Usuario(2);

        log.info("user1.id(1) -> user2.id(2) equals = {}", user1.equals(user2));
        assertFalse(user1.equals(user2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        Usuario user1 = new Usuario(4);
        Usuario user2 = new Usuario("4");

        log.info("user1.id(4) -> user2.id(4) equals = {}", user1.equals(user2));
        assertTrue(user1.equals(user2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        Usuario user1 = new Usuario(4);
        Usuario user2 = new Usuario();

        log.info("user1.id(4) -> user2.id() equals = {}", user1.equals(user2));
        assertFalse(user1.equals(user2));
    }
}
