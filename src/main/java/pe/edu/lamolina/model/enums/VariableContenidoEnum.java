package pe.edu.lamolina.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum VariableContenidoEnum {

    CICLO_ACADEMICO("@(CICLO-ACADEMICO)", 9L),
    CODIGO_POSTULANTE("@(CODIGO-POSTULANTE)", 10L),
    CORREO_NUEVO("@(CORREO-NUEVO)", 3L),
    CUENTA_BANCARIA("@(CUENTA-BANCARIA)", 7L),
    CURSO_TALLER("@(CURSO-TALLER)", 8L),
    DECANO("@(DECANO)", 4L),
    ESTIMADO("@(ESTIMADO)", 1L),
    PROFESOR("@(PROFESOR)", 1L),
    CLAVE_PROFESOR_TALLER("@(CLAVE-PROFESOR-TALLER)", 1L),
    DPTO_ACADEMICO("@(DPTO-ACADEMICO)", 1L),
    FACULTAD("@(FACULTAD)", 5L),
    IDENTIFICADO("@(IDENTIFICADO)", 17L),
    NOMBRE_PERSONA("@(NOMBRE-PERSONA)", 2L),
    NRO_DOCUMENTO("@(NRO-DOCUMENTO)", 16L),
    POSTULANTE("@(POSTULANTE)", 6L),
    ROL_APOYO_FECHA("@(ROL-APOYO-FECHA)", 14L),
    ROL_APOYO_GUIAS("@(ROL-APOYO-GUIAS)", 13L),
    ROL_APOYO_NOMBRE("@(ROL-APOYO-NOMBRE)", 12L),
    ROL_APOYO_UBICACION("@(ROL-APOYO-UBICACION)", 11L),
    CORREO_CREADO("@(CORREO-CREADO)", 37L),
    TIPO_DOCUMENTO("@(TIPO-DOCUMENTO)", 15L),
    EPG_LINK_VALIDADOR("@(EPG-LINK-VALIDADO)", 11L),
    EPG_TIPO_ESCUELA_POSGRADO("@(EPG-TIPO-ESCUELA-POSGRADO)", 11L),
    EPG_CODIGO_POSTULANTE_POSGRADO("@(EPG-CODIGO-POSTULANTE-POSGRADO)", 11L),
    EPG_LISTA_INGRESANTE_POSGRADO("@(EPG-LISTA-INGRESANTE-POSGRADO)", 11L),
    EPG_LISTA_REQUISITOS("@(EPG-LISTA-REQUISITOS)", 11L),
    EPG_RECURSO_IMG_UNALM("@(EPG-RECURSO-IMG-UNALM)", 11L),
    EPG_RECURSO_IMG_EPG("@(EPG-RECURSO-IMG-EPGS)", 11L),
    EPG_NOMBRE_ESPECIALIDAD("@(EPG-NOMBRE-ESPECIALIDAD)", 11L),
    EPG_TIPO_CARRERA("@(EPG-TIPO-CARRERA)", 11L),
    USUARIO_PASSWORD("@(USUARIO-PASSWORD)", 11L),
    EPG_CICLO_ESCUELA("@(EPG-CICLO-ESCUELA)", 11L),
    EPG_NOMBRE_PRESIDENTE("@(EPG-NOMBRE-PRESIDENTE)", 11L),
    EPG_NOMBRES_COMITE("@(EPG-NOMBRES-COMITE)", 11L),
    EPG_DIA_EVALUACION_EXPEDIENTE("@(EPG-DIA-EVALUACION-EXPEDIENTE)", 11L),
    EPG_DIA_ENTREVISTA("@(EPG-DIA-ENTREVISTA)", 11L),
    EPG_HORA_EVALUACION_EXPEDIENTE("@(EPG-HORA-EVALUACION-EXPEDIENTE)", 11L),
    EPG_HORA_ENTREVISTA("@(EPG-HORA-ENTREVISTA)", 11L),
    EPG_LUGAR_ENTREVISTA("@(EPG-LUGAR-ENTREVISTA)", 11L),
    HORA_REUNION_CONSEJERO("@(HORA_REUNION_CONSEJERO)", 11L),
    FECHA_REUNION_CONSEJERO("@(FECHA_REUNION_CONSEJERO)", 11L),
    CUERPO_MENSAJE("@(CUERPO-MENSAJE)", 11L);

    private final String value;
    private final Long idVariable;
    private static final Map<String, VariableContenidoEnum> lookname = new HashMap<>();
    private static final Map<Long, VariableContenidoEnum> lookup = new HashMap<>();

    static {
        for (VariableContenidoEnum d : VariableContenidoEnum.values()) {
            lookname.put(d.getValue(), d);
            lookup.put(d.getIdVariable(), d);
        }
    }

    private VariableContenidoEnum(String value, Long id) {
        this.value = value;
        this.idVariable = id;
    }

    public String getValue() {
        return value;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public static VariableContenidoEnum get(String abbreviation) {
        return lookup.get(abbreviation);
    }

    public static String getNombre(String nombre) {

        for (VariableContenidoEnum d : VariableContenidoEnum.values()) {
            if (d.name().equalsIgnoreCase(nombre)) {
                return d.getValue();
            }
        }

        return nombre;
    }
}
