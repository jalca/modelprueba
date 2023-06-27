package pe.edu.lamolina.model.zelper.util;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.seguridad.Usuario;

@Slf4j
public class ModelUtilsTest {

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void toString_test() {
        Facultad fac = new Facultad(23L);
        fac.setCodigo("010");
        fac.setNombre("Agronomía");
        fac.setUserRegistro(new Usuario(123L));
        fac.setEstado(null);
        fac.setSimbolo(null);
        fac.getUserRegistro().setGoogle("lyon@lamolina.edu.pe");

        String facString = ModelUtils.toString(fac, "id", "codigo", "nombre", "userRegistro");

        log.info("facultad={}", facString);
        log.info("facultad={}", fac);
    }

    @Test
    public void esNoLeible_test() {

        String clazz = Usuario.class.getSimpleName();
        boolean noLeible = ModelUtils.noPuedeLeerse(clazz);
        log.info("clazz={} noLeible={}", clazz, noLeible);
        assertFalse(noLeible);

        String clazz2 = clazz + "$HibernateProxy$zRMBVkHU";
        noLeible = ModelUtils.noPuedeLeerse(clazz2);
        log.info("clazz2={} noLeible={}", clazz2, noLeible);
        assertTrue(noLeible);

        String clazz3 = clazz + "$$zRMBVkHU";
        noLeible = ModelUtils.noPuedeLeerse(clazz3);
        log.info("clazz3={} noLeible={}", clazz3, noLeible);
        assertTrue(noLeible);

    }
}
