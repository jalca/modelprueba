package pe.edu.lamolina.model.cms.exceptions;

import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.cms.Sitio;

@Getter
@Setter
public class WebsiteException extends RuntimeException {

    private Sitio sitio;

    public WebsiteException(Sitio sitio, String string) {
        super(string);
        this.sitio = sitio;
    }

    public WebsiteException() {
    }

}
