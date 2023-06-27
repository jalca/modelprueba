package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AportesEnum {

    A01("Aporte Semestral", 1L),
    A02("Observación Académica", 1L),
    A03("Deuda Académica", 1L),
    A04("Por No Votar", 1L),
    A05("Carné Universitario", 1L),
    A06("Matrícula Extemporánea", 1L),
    A07("Otros Academicos", 1L),
    A08("Seguro + Fobeu", 1L),
    A09("Essalud", 1L),
    A10("Debe Materiales", 1L),
    A11("Debe Préstamo", 1L),
    A12("Aportaciones No Pagadas", 1L),//*no BD*/
    A13("Exceso De Autoseguro", 1L),//*no BD*/
    A14("Aporte Voluntario", 1L),
    A15("Otros Bienestar", 1L),
    A16("Seguro Contra Accidentes", 1L),
    A17("Debe Química", 1L),
    A18("Debe Biblioteca", 1L),
    A19("Boletín", 1L),//*no BD*/
    A20("Observacion Academica Anulado", 1L),
    A21("Debe Aprov. Forestal", 1L),
    A22("Autoseguro Estudiantil", 1L),
    A23("Fondo de Bienestara Estudiantil", 1L),
    A24("Debe Horticultura", 1L),
    A25("Debe Edafologia", 1L),
    A26("Pago Por Trika", 1L),
    A27("Debe Semestre De Campo", 1L),
    A28("Pago Materiales", 1L),
    A29("Debe Facultad Forestales", 1L),//*no BD*/
    A30("Debe Lab. Analisis Fisico Quimico De Alimentos", 1L),
    A31("Debe Lab. Fisicoquimico 6147800 Anexo 247.", 1L),
    A32("Debe Lab.Microbiologia 6147800 Anexo 247.", 1L),
    A33("Debe Lab.Biotecnologia 6147800 Anexo 247 ", 1L),
    A34("Debe Lab.Invest.E Instrumentacion 6147800 Anexo 247", 1L),
    A35("Debe Planta Piloto De Alimentos", 1L),
    A36("Debe Consejería", 1L),
    A37("Reincorporación", 1L),
    A38("Retiro de Ciclo", 1L),
    A39("Trabajo Universitario - Oera", 1L),
    A40("Seguro Contra Accidentes EPG", 1L),
    A41("Tutoría Pendiente", 1L),
    A42("Aporte Segunda Carrera", 1L),
    A43("Suspensión", 1L),
    A44("Deudas Por Préstamo de Materiales", 1L),//*no BD*/
    A45("Separación", 1L),
    A46("Examen Médico", 1L),
    A51("Duplicado Carné", 1L),
    A52("Extemporáneo Examen Médico", 1L),
    A53("Curso Propedéutico", 1L),
    A54("Carnet Universitario pregrado", 1L),
    A55("Aporte Segunda Carrera Deuda", 1L),
    A56("Subvención No Justificada", 1L),
    XXX("Otros XXX", 1L);

    private final String value;
    private final Long modalidad;

    private static final Map<String, AportesEnum> lookup = new HashMap();

    static {
        for (AportesEnum d : AportesEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private AportesEnum(String value, Long modalidad) {
        this.value = value;
        this.modalidad = modalidad;
    }

    public String getValue() {
        return value;
    }

    public Long getModalidad() {
        return modalidad;
    }

    public String getCodigoAporte() {
        return name().substring(1);
    }

    public static AportesEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (AportesEnum d : AportesEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }
        return nombre;
    }
}
