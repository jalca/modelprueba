package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ConceptoPosgradoEnum {

    MAT("Derecho de Matrícula", 1L),
    ENZ("Derecho de Enseñanza", 2L),
    XTM("Matrícula Extemporánea", 6L),
    ADMP_MAE("Admision Soles Maestria", 3L),
    ADME("Admision Dolares", 4L),
    ADMP_DOC("Admision Soles Doctorado", 5L),
    RET_CUR("Retiro Curso Posgrado", 7L),
    RET_CIC("Retiro Ciclo Posgrado", 8L),
    CERT_IDIOMA("Certificado Centro de Idiomas", 19L),
    EXM_IDIOMA("Examen de Idioma", 10L),
    EXM_GRADO("Retiro Ciclo Posgrado", 11L),
    SUST_TESIS("Retiro Ciclo Posgrado", 12L),
    REI_EPG("Reincorporación Posgrado", 13L),
    DEU_ANT("Pagar Deuda Antigua EPG", 14L),
    RSRV_MAT("Reserva de matrícula", 15L),
    NOTA_BAJA("Anulación Nota más Baja", 18L),;

    private final String value;
    private final Long id;
    private static final Map<String, ConceptoPosgradoEnum> lookup = new HashMap<>();

    static {
        for (ConceptoPosgradoEnum d : ConceptoPosgradoEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ConceptoPosgradoEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }

    public static ConceptoPosgradoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (ConceptoPosgradoEnum d : ConceptoPosgradoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

    public static boolean existValue(String looked) {
        boolean exist = false;

        for (ConceptoPosgradoEnum e : ConceptoPosgradoEnum.values()) {
            if (e.name().equals(looked)) {
                exist = true;
                break;
            }
        }

        return exist;
    }
}
