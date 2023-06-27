package pe.edu.lamolina.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import pe.edu.lamolina.model.academico.ModalidadEstudio;

public enum TipoTallerOficinaEnum {

    CUL_VER("Taller Cultural Verano", 9l, 53l),
    DEP_VER("Curso Deporte Verano", 9l, 53l),
    DEP("Curso Deporte", 6l, 64l),
    TCU("Taller Cultural", 7l, 65l);

    private final String value;
    private final Long modalidad;
    private final Long oficina;

    private static final Map<String, TipoTallerOficinaEnum> lookup = new HashMap<>();

    static {
        for (TipoTallerOficinaEnum d : TipoTallerOficinaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoTallerOficinaEnum(String value, Long modalidad, Long oficina) {
        this.value = value;
        this.oficina = oficina;
        this.modalidad = modalidad;
    }

    public String getValue() {
        return value;
    }

    public Long getOficina() {
        return oficina;
    }

    public Long getModalidad() {
        return modalidad;
    }

    public static TipoTallerOficinaEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getValue(String nombre) {
        for (TipoTallerOficinaEnum d : TipoTallerOficinaEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }

    public static String getName(String value) {

        for (TipoTallerOficinaEnum d : TipoTallerOficinaEnum.values()) {
            if (d.value.equalsIgnoreCase(value)) {
                return d.name();
            }
        }

        return value;
    }

    public static List<String> getNameByOficina(Long oficinaId) {
        List<String> lsi = new ArrayList<>();
        for (TipoTallerOficinaEnum d : TipoTallerOficinaEnum.values()) {
            if (Objects.equals(d.oficina, oficinaId)) {
                lsi.add(d.name());
            }
        }
        return lsi;
    }

    public static Long getModalidadTallerByOficina(Long oficinaId) {
        Long valor = null;
        for (TipoTallerOficinaEnum d : TipoTallerOficinaEnum.values()) {
            if (Objects.equals(d.oficina, oficinaId) && Arrays.asList(TCU.name()).contains(d.name())) {
                valor = d.modalidad;
            }
        }
        return valor;
    }

    public static List<ModalidadEstudio> getModalidadesByOficina(Long oficinaId) {
        List<ModalidadEstudio> valor = new ArrayList();
        for (TipoTallerOficinaEnum d : TipoTallerOficinaEnum.values()) {
            if (Objects.equals(d.oficina, oficinaId)) {
                valor.add(new ModalidadEstudio(d.modalidad));
            }
        }
        return valor;
    }

}
