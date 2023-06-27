package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum EtiquetaEmpresaEnum {

    CENTRO_IDIOMA("Centro de Idiomas", 1L);

    private final String value;
    private final Long idEtiquetaEmpresa;

    private static final Map<String, EtiquetaEmpresaEnum> lookup = new HashMap();

    static {
        for (EtiquetaEmpresaEnum d : EtiquetaEmpresaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EtiquetaEmpresaEnum(String value, Long modalidad) {
        this.value = value;
        this.idEtiquetaEmpresa = modalidad;
    }

    public String getValue() {
        return value;
    }

    public Long getIdEtiquetaEmpresa() {
        return idEtiquetaEmpresa;
    }

    public String getCodigoAporte() {
        return name().substring(1);
    }

    public static EtiquetaEmpresaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EtiquetaEmpresaEnum d : EtiquetaEmpresaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
