package pe.edu.lamolina.model.finanzas;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Slf4j
public class CuentaBancariaTest {

    @Test
    public void equals_null_test() {
        CuentaBancaria ctaBco1 = new CuentaBancaria();
        CuentaBancaria ctaBco2 = null;

        log.info("ctaBco1(null) -> ctaBco2-null equals = {}", ctaBco1.equals(ctaBco2));
        assertFalse(ctaBco1.equals(ctaBco2));
    }

    @Test
    public void equals_ids_null_test() {
        CuentaBancaria ctaBco1 = new CuentaBancaria();
        CuentaBancaria ctaBco2 = new CuentaBancaria();

        log.info("ctaBco1.id(null) -> ctaBco2.id(null) equals = {}", ctaBco1.equals(ctaBco2));
        assertTrue(ctaBco1.equals(ctaBco2));
    }

    @Test
    public void equals_ids_notnull_test1() {
        CuentaBancaria ctaBco1 = new CuentaBancaria(1);
        CuentaBancaria ctaBco2 = new CuentaBancaria(2);

        log.info("ctaBco1.id(1) -> ctaBco2.id(2) equals = {}", ctaBco1.equals(ctaBco2));
        assertFalse(ctaBco1.equals(ctaBco2));
    }

    @Test
    public void equals_ids_notnull_test2() {
        CuentaBancaria ctaBco1 = new CuentaBancaria(4);
        CuentaBancaria ctaBco2 = new CuentaBancaria("4");

        log.info("ctaBco1.id(4) -> ctaBco2.id(4) equals = {}", ctaBco1.equals(ctaBco2));
        assertTrue(ctaBco1.equals(ctaBco2));
    }

    @Test
    public void equals_ids_notnull_test3() {
        CuentaBancaria ctaBco1 = new CuentaBancaria(4);
        CuentaBancaria ctaBco2 = new CuentaBancaria();

        log.info("ctaBco1.id(4) -> ctaBco2.id() equals = {}", ctaBco1.equals(ctaBco2));
        assertFalse(ctaBco1.equals(ctaBco2));
    }
}
