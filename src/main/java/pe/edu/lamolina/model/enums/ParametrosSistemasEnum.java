package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ParametrosSistemasEnum {
    BASE_LINK_PAGAR_APORTE_ALUMNO("BASE_LINK_PAGAR_APORTE_ALUMNO", "BASE_LINK_PAGAR_APORTE_ALUMNO"),
    //nnews
    SALTO_HACIA_AMAUTA("SALTO_HACIA_AMAUTA", "URL_DESTINO"),
    SALTO_HACIA_INTRANET("SALTO_HACIA_INTRANET", "URL_DESTINO"),
    SALTO_HACIA_MATRICULA("SALTO_HACIA_MATRICULA", "URL_DESTINO"),
    SALTO_HACIA_ADMISION_EPG("SALTO_HACIA_ADMISION_EPG", "URL_DESTINO"),
    SALTO_HACIA_ADMISION_PRE("SALTO_HACIA_ADMISION_PRE", "URL_DESTINO"),
    //Rest
    REST_BIENESTAR("REST_BIENESTAR", "URL_DESTINO"),
    REST_GESTION_EPG("REST_GESTION_EPG", "URL_DESTINO"),
    REST_MATRICULA("REST_MATRICULA", "URL_DESTINO"),
    REST_INTRANET("REST_INTRANET", "URL_DESTINO"),
    REST_AMAUTA("REST_AMAUTA", "URL_DESTINO"),
    REST_SIP("REST_SIP", "URL_DESTINO"),
    //plantillas para posgrado
    PLANTILLA_PROY_TESIS("PROYECTO_TESIS", "PLANTILLA"),
    PLANTILLA_TESIS("TESIS", "PLANTILLA"),
    ENCUESTA_PRE("ENCUESTA_PRE", "URL_DESTINO"),
    ENCUESTA_EPG("ENCUESTA_EPG", "URL_DESTINO"),
    ENCUESTA_DOC("ENCUESTA_DOC", "URL_DESTINO"),
    
    ;

    private final String contexto;
    private final String parametro;

    private static final Map<String, ParametrosSistemasEnum> lookup = new HashMap<>();

    static {
        for (ParametrosSistemasEnum d : ParametrosSistemasEnum.values()) {
            lookup.put(d.getContexto() + d.getParametro(), d);
        }
    }

    private ParametrosSistemasEnum(String contexto, String parametro) {
        this.contexto = contexto;
        this.parametro = parametro;
    }

    public String getContexto() {
        return contexto;
    }

    public String getParametro() {
        return parametro;
    }

    public static ParametrosSistemasEnum get(String contexto, String parametro) {
        return lookup.get(contexto + parametro);
    }

    public static String getContexto(String nombre) {

        for (ParametrosSistemasEnum d : ParametrosSistemasEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getContexto();
            }
        }

        return nombre;
    }

    public static String getParametro(String nombre) {

        for (ParametrosSistemasEnum d : ParametrosSistemasEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getParametro();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (ParametrosSistemasEnum e : ParametrosSistemasEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
