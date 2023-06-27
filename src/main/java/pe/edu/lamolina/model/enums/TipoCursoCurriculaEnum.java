package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoCursoCurriculaEnum {

    OBL("Obligatorio"),
    GEN("General"),
    DEP("Deporte/Cultural"),
    ELC("Electivo Carrera"),
    ELE("Electivo Libre"),
    PROD("Curso Producción"),
    CULT("Curso Cultivos"),
    CULT_I("Curso Cultivos 1"),
    CULT_II("Curso Cultivos 2"),
    CULT_III("Curso Cultivos 3"),
    CULT_IV("Curso Cultivos 4"),
    TECIND("Curso Tecnología e Industrialización"),
    EEP("Electivo Extracurricular"),
    ECP("Electivo Campo Principal"),
    ECC("Electivo Campo Complementario"),
    EAD("Electivo Adicional"),
    CPRO("Curso Propedeutico"),
    CNG("Cursos No Graduados");

    private final String value;
    private static final Map<String, TipoCursoCurriculaEnum> lookup = new HashMap<>();

    static {
        for (TipoCursoCurriculaEnum d : TipoCursoCurriculaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoCursoCurriculaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TipoCursoCurriculaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoCursoCurriculaEnum d : TipoCursoCurriculaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

}
