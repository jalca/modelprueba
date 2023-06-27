package pe.edu.lamolina.model.enums;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;

public enum EstadoMatriculaEnum {
    MAT("Matriculado"),
    ANMB("Anulado por nota mas baja"),
    NMAT("No matriculado"),
    PMAT("Inscrito"),
    NVAC("Sin Vacante"),
    NREQ("Sin curso requisito"),
    RET("Retirado"),
    RET_VEN("Retirado por vencimiento"),
    RCU("Curso Retirado"),
    RCI("Retiro de Ciclo"),
    ANCI("Anulación de Ciclo"),
    CIA("Ciclo Anulado"),
    RCA("Retirado por Cancelación"), //al cancelar la seccion
    RAN("Retirado por Anulación"), //al cancelar la seccion
    INH("Inhabilitado"),
    CDES("Curso inhabilitado"),
    NMOD("Nota Modificada"),
    NELI("Nota Eliminada"),
    TRAS("Trasladado"),
    SOL("Solicitud"),
    RHZ("Rechazado"),
    MAT_AMP_VAC("Matricula por ampliación de vacantes"),
    RMAT("Reserva de Matrícula");

    private final String value;
    private static final Map<String, EstadoMatriculaEnum> lookup = new HashMap<>();

    static {
        for (EstadoMatriculaEnum d : EstadoMatriculaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private EstadoMatriculaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EstadoMatriculaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (EstadoMatriculaEnum d : EstadoMatriculaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

    public static ObjectNode getNombreAndName(String nombre) {
        ObjectNode objNode = new ObjectNode(JsonNodeFactory.instance);
        for (EstadoMatriculaEnum d : EstadoMatriculaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                objNode.put("valor", d.getValue());
                objNode.put("nombre", d.name());
                return objNode;
            }
        }
        return objNode;
    }

}
