package pe.edu.lamolina.model.tramite;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class ObservacionProyectoTesisTest {

    @Test
    public void equals_null_test() {
        ObservacionProyectoTesis obs1 = new ObservacionProyectoTesis();
        ObservacionProyectoTesis obs2 = null;

        log.info("obs1 -> obs2(null) equals = {}", obs1.equals(obs2));
        assertFalse(obs1.equals(obs2));
    }

    @Test
    public void equals_ids_null_test() {
        ObservacionProyectoTesis obs1 = new ObservacionProyectoTesis();
        ObservacionProyectoTesis obs2 = new ObservacionProyectoTesis();

        log.info("obs1.id(null) -> obs2.id(null) equals = {}", obs1.equals(obs2));
        assertTrue(obs1.equals(obs2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        ObservacionProyectoTesis obs1 = new ObservacionProyectoTesis(1);
        ObservacionProyectoTesis obs2 = new ObservacionProyectoTesis(2);

        log.info("obs1.id(1) -> obs2.id(2) equals = {}", obs1.equals(obs2));
        assertFalse(obs1.equals(obs2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        ObservacionProyectoTesis obs1 = new ObservacionProyectoTesis(4);
        ObservacionProyectoTesis obs2 = new ObservacionProyectoTesis("4");

        log.info("obs1.id(4) -> obs2.id(4) equals = {}", obs1.equals(obs2));
        assertTrue(obs1.equals(obs2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        ObservacionProyectoTesis obs1 = new ObservacionProyectoTesis(4);
        ObservacionProyectoTesis obs2 = new ObservacionProyectoTesis();

        log.info("obs1.id(4) -> obs2.id() equals = {}", obs1.equals(obs2));
        assertFalse(obs1.equals(obs2));
    }
}
