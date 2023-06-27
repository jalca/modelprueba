package pe.edu.lamolina.model.misc;

import org.apache.commons.lang3.StringUtils;

public class FotoHelper {

    public static String getRutaFoto(String foto, String sexo) {
        if (!StringUtils.isEmpty(foto)) {
            return foto;
        }

        if (!StringUtils.isEmpty(sexo)) {
            switch (sexo) {
                case "M":
                    return "/phobos/images/unalm/male.png";
                case "F":
                    return "/phobos/images/unalm/female.png";
            }
        }

        return "/phobos/images/unalm/unknown-person.gif";
    }

}
