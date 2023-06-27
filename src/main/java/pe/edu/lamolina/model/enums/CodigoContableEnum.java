package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CodigoContableEnum {

    DIC_CLA("DICTADO DE CLASES", "DICTADO CLASES"),
    HON_COOR("HONORARIO DE COORDINADOR", "HONORARIO COORDINADOR"),
    HON_DIR_DUPG("HONORARIOS DIRECTOR UNIDAD POSGRADO", "DIRECTOR UNIDAD POSGRADO"),
    INC_EXA_GRA("INCENTIVOS EXAMEN DE GRADO", "JURADO EXAMEN GRADO"),
    INC_EXA_ING("INCENTIVOS EXAMEN DE INGLES", "JURADO EXAMEN IDIOMA"),
    INC_PAT_TE("INCENTIVOS PATROCINADOR TESIS", "PATROCINADOR TESIS"),
    INC_SUS_TE("INCENTIVOS SUSTENTACION TESIS", "JURADO SUSTENTACION TESIS"),
    JUR_ADMISION("JURADO DE ADMISION", "JURADO ADMISION"),
    PUB_ARTICULO("INCENTIVOS PUBLICACION ARTICULO", "PUBLICACION ARTICULO CIENTIFICO");

    private final String value;
    private final String nombreCorto;

    private static final Map<String, CodigoContableEnum> lookup = new HashMap<>();

    static {
        for (CodigoContableEnum d : CodigoContableEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private CodigoContableEnum(String value, String nombreCorto) {
        this.value = value;
        this.nombreCorto = nombreCorto;
    }

    public String getValue() {
        return value;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public static CodigoContableEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (CodigoContableEnum d : CodigoContableEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
