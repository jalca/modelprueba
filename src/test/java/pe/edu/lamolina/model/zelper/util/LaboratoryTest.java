package pe.edu.lamolina.model.zelper.util;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class LaboratoryTest {

    @Test
    public void esNumerico_test() {

        String s1 = "wefwe";
        String s2 = "34345234";
        String s3 = "34345.234";
        String s4 = "34345.234ww";

        boolean esNumero = isNumeric(s1);
        log.debug("s1={} esNumero={}", s1, esNumero);
        assertFalse(esNumero);

        esNumero = isNumeric(s2);
        log.debug("s2={} esNumero={}", s2, esNumero);
        assertTrue(esNumero);

        esNumero = isNumeric(s3);
        log.debug("s3={} esNumero={}", s3, esNumero);
        assertTrue(esNumero);

        esNumero = isNumeric(s4);
        log.debug("s4={} esNumero={}", s4, esNumero);
        assertFalse(esNumero);
    }

    @Test
    public void partirEmail_test() {
        String name = "pepe.lucho";
        String dominio = "gmail.com";
        String emailCia = name + "@" + dominio;
        log.debug("emailCia={}", emailCia);
        
        String name2 = emailCia.substring(0, emailCia.indexOf("@"));
        String dominio2 = emailCia.substring(emailCia.indexOf("@") + 1);

        boolean sonIguales = name.equals(name2);
        log.debug("name1={} name2={}", name, name2);
        assertTrue(sonIguales);

        sonIguales = dominio.equals(dominio2);
        log.debug("dominio1={} dominio2={}", dominio, dominio2);
        assertTrue(sonIguales);
    }

    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("") == false);
    }
}
