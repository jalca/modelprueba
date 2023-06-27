package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoTramiteEnum {
    GENERAL(99999L, "Trámite General"),
    // Trámites Oficina Estudios
    BACHI(13L, "Bachiller"),
    CAMBIO_PLAN_CURRICULAR(39L, "Cambio de plan curricular"),
    CAM_NOTA(11L, "Cambio de nota"),
    CERT(34L, "Certificado"),
    CONS(7L, "Constancia"),
    CONV_INT(32L, "Convalidación Interna"),
    CORR_HISTO(19L, "Corrección historial"),
    CURDIR(15L, "Curso Dirigido"),
    ING_HIS(35L, "Ingreso al Historial"),
    INTES(18L, "Intercambio Estudiantil"),
    PRAC_PROF(37L, "Practicas Pre-profesionales"),
    RCI(6L, "Retiro de Ciclo"),
    RCU(5L, "Retiro de Curso"),
    READMISION(38L, "Readmisión"),
    REI(8L, "Reincorporación"),
    RSVAULA(9L, "Reservación de Aula"),
    TIT(14L, "Título"),
    TRAS(17L, "Traslado Externo"),
    // Trámites Oficina Bienestra
    EXON(4L, "Exoneración de Aportes"),
    FRACC(3L, "Fraccionamiento de Aportes"),
    RECAT(2L, "Recategorización"),
    SOCIOECONO(10L, "Entrevista Socio Económica"),
    LLENAR_FICHA(41L, "Llenar Ficha Socioeconómica"),
    SUBV(1L, "Subvención"),
    // Trámites Posgrado
    AING(33L, "Anulación de ingreso"),
    ANCI(30L, "Anulación de Ciclo"),
    COMITE(12L, "Comité Consejero"),
    CONS_EPG(40L, "Constancia Posgrado"),
    DEU_ADIC(36L, "Deuda Adicional EPG"),
    DEU_ANT(27L, "Pagar Deuda Antigua EPG"),
    REFINA_CUOTAS(42L, "Refinanciar Cuotas EPG"),
    EXM_GRADO(21L, "Examen de Grado"),
    EXM_IDIOMA(24L, "Examen de Idioma"),
    NOTA_BAJA(28L, "Nota más Baja"),
    OBTE_GRADO(23L, "Obtención de grado"),
    PLAN_EST(25L, "Plan de Estudios"),
    PROY_TESIS(20L, "Proyecto de Tesis"),
    REI_EPG(26L, "Reincorporación Posgrado"),
    RSRV_MAT(29L, "Reserva de matrícula"),
    SUST_TESIS(22L, "Sustentación de tesis"),
    TRAS_INT(31L, "Traslado Interno");

//    AING(33L, "Anulación de ingreso"),
//    ANCI(30L, "Anulación de Ciclo"),
//    BACHI(13L, "Bachiller"),
//    CAM_NOTA(11L, "Cambio de nota"),
//    COMITE(12L, "Comité Consejero"),
//    CONS(7L, "Constancia"),
//    CONV_INT(32L, "Convalidación Interna"),
//    CORR_HISTO(19L, "Corrección historial"),
//    CURDIR(15L, "Curso Dirigido"),
//    DEU_ANT(27L, "Pagar Deuda Antigua EPG"),
//    DEU_ADIC(36L, "Deuda Adicional EPG"),
//    EXM_GRADO(21L, "Examen de Grado"),
//    EXM_IDIOMA(24L, "Examen de Idioma"),
//    EXON(4L, "Exoneración de Aportes"),
//    FRACC(3L, "Fraccionamiento de Aportes"),
//    INTES(18L, "Intercambio Estudiantil"),
//    NOTA_BAJA(28L, "Nota más Baja"),
//    OBTE_GRADO(23L, "Obtención de grado"),
//    PLAN_EST(25L, "Plan de Estudios"),
//    PROY_TESIS(20L, "Proyecto de Tesis"),
//    RCI(6L, "Retiro de Ciclo"),
//    RCU(5L, "Retiro de Curso"),
//    RECAT(2L, "Recategorización"),
//    REI(8L, "Reincorporación"),
//    REI_EPG(26L, "Reincorporación Posgrado"),
//    RSRV_MAT(29L, "Reserva de matrícula"),
//    RSVAULA(9L, "Reservación de Aula"),
//    SOCIOECONO(10L, "Entrevista Socio Económica"),
//    SUBV(1L, "Subvención"),
//    SUST_TESIS(22L, "Sustentación de tesis"),
//    TIT(14L, "Título"),
//    TRAS(17L, "Traslado Externo"),
//    TRAS_INT(31L, "Traslado Interno"),
//    ING_HIS(34L, "Ingreso al Historial"),
//    CERT(35L, "Certificado"),
//    PRAC_PROF(35L, "Practicas Pre-profesionales"),
//    GENERAL(99999L, "Trámite General"),
//    CAMBIO_PLAN_CURRICULAR(8L, "Cambio Plan Curricular"),
//    READMISION(8L, "Readmisión");
    private Long id;
    private final String value;
    private static final Map<String, TipoTramiteEnum> lookup = new HashMap<>();

    static {
        for (TipoTramiteEnum d : TipoTramiteEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private TipoTramiteEnum(Long id, String value) {
        this.value = value;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public static TipoTramiteEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (TipoTramiteEnum d : TipoTramiteEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }

}
