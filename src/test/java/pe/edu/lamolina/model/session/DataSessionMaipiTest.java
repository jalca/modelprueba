package pe.edu.lamolina.model.session;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DataSessionMaipiTest {

    @Test
    public void rutaInicioIntranet_test() {
        String url = "FICHA_ING";
        DataSessionMaipi ds = new DataSessionMaipi();
        ds.setRutaInicioIntranet(url);

        log.info("inicioEnum={}", ds.getRutaInicioIntranetEnum());
    }
}
