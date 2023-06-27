package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.aporte.ResumenAporteAlumno;
import pe.edu.lamolina.model.enums.EstadoMatriculaEnum;
import static pe.edu.lamolina.model.enums.EstadoMatriculaEnum.NMAT;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "aca_matricula_resumen")
public class MatriculaResumen implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cursos_matriculados")
    private Integer cursosMatriculados;

    @Column(name = "cursos_retirados")
    private Integer cursosRetirados;

    @Column(name = "creditos_matriculados")
    private Integer creditosMatriculados;

    @Column(name = "creditos_retirados")
    private Integer creditosRetirados;

    @Column(name = "creditos_trika_pagados")
    private Integer creditosTrikaPagados;

    @Column(name = "creditos_pagados")
    private Integer creditosPagados;

    @Column(name = "creditos_consumidos")
    private Integer creditosConsumidos;

    @Column(name = "creditos_trika_separados")
    private Integer creditosTrikaSeparados;

    @Column(name = "nota_avance")
    private String notaAvance;

    @Column(name = "nota_acumulada")
    private String notaAcumulada;

    @Column(name = "nota_final")
    private String notaFinal;

    @Column(name = "motivo_matriculable")
    private String motivoMatriculable;

    @Column(name = "aportes_desactivados")
    private String aportesDesactivados;

    @Column(name = "porcentaje_avance")
    private Integer porcentajeAvance;

    @Column(name = "prioridad")
    private BigDecimal prioridad;

    @Column(name = "prioridad_anterior")
    private BigDecimal prioridadAnterior;

    @Column(name = "puntaje_prioridad")
    private BigDecimal puntajePrioridad;

    @Column(name = "creditos_cursados_ciclo")
    private Integer creditosCursadosCiclo;

    @Column(name = "creditos_acumulados")
    private Integer creditosAcumulados;

    @Column(name = "creditos_aprobados_ciclo")
    private Integer creditosAprobadosCiclo;

    @Column(name = "creditos_aprobados_acumulados")
    private Integer creditosAprobadosAcumulados;

    @Column(name = "creditos_matriculados_posgrado")
    private Integer creditosMatriculadosPosgrado;

    @Column(name = "tipo_condicional")
    private String tipoCondicional;

    @Column(name = "es_condicional", columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.BooleanType")
    private Boolean esCondicional;

    @Column(name = "promedio_semestral")
    private BigDecimal promedioSemestral;

    @Column(name = "autorizacion_matricula")
    private Boolean autorizacionMatricula;

    @Column(name = "fecha_condicional")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCondicional;

    @Column(name = "es_ultimo_ciclo", columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.BooleanType")
    private Boolean esUltimoCiclo;

    @Column(name = "es_beneficiado_ult_ciclo", columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.BooleanType")
    private Boolean esBeneficiadoUltimoCiclo;

    @Column(name = "fecha_autorizacion_matricula")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAutorizacionMatricula;

    @Column(name = "fecha_beneficiado_ult_ciclo")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaBeneficiadoUtlCiclo;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_primera_matricula")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaPrimeraMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico_info")
    private CicloAcademico cicloAcademicoInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_inicio")
    private SituacionAcademica situacionInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_situacion_final")
    private SituacionAcademica situacionFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turno_atencion")
    private TurnoAtencion turnoAtencion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_consejero")
    private Usuario userConsejero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_registro")
    private Usuario userRegistro;

    @OneToMany(mappedBy = "matriculaResumen", fetch = FetchType.LAZY)
    private List<MatriculaCurso> matriculaCurso;

    @OneToMany(mappedBy = "matriculaResumen", fetch = FetchType.LAZY)
    private List<MatriculaSeccion> matriculaSeccion;

    @Transient
    private Integer procesado;
    @Transient
    private Integer cargado;
    @Transient
    private Integer creditosPrematriculados;
    @Transient
    private Integer creditosMatriculadosPregrado;
    @Transient
    private Date fechaInicioProceso;
    @Transient
    private Date fechaFinProceso;
    @Transient
    private Boolean aporteCarnet;
    @Transient
    private Boolean aporteAutoseguro;
    @Transient
    private String aporteExamenMedico;
    @Transient
    private List<ResumenAporteAlumno> resumenesAportes;
    @Transient
    private Boolean boletaPendiente;
    @Transient
    private Boolean aporteDuplicadoCarnet;

    public MatriculaResumen() {
        this.procesado = 0;
        this.cargado = 0;
        this.esCondicional = false;
    }

    public MatriculaResumen(Object id) {
        this.id = TypesUtil.getLong(id);
        this.procesado = 0;
        this.cargado = 0;
    }

    public EstadoMatriculaEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoMatriculaEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoMatriculaEnum estado) {
        this.estado = estado.name();
    }

    public Integer getCreditosTrikaSeparados() {
        if (creditosTrikaSeparados == null) {
            return 0;
        }
        return creditosTrikaSeparados;
    }

    public void setCreditosTrikaSeparados(Integer creditosTrikaSeparados) {
        if (creditosTrikaSeparados == null) {
            this.creditosTrikaSeparados = 0;
        } else {
            this.creditosTrikaSeparados = creditosTrikaSeparados;
        }
    }

    public Integer getCreditosTrikaPagados() {
        if (creditosTrikaPagados == null) {
            return 0;
        }
        return creditosTrikaPagados;
    }

    public void setCreditosTrikaPagados(Integer creditosTrikaPagados) {
        if (creditosTrikaPagados == null) {
            this.creditosTrikaPagados = 0;
        } else {
            this.creditosTrikaPagados = creditosTrikaPagados;
        }
    }

    public boolean isEstadoRCI() {
        if (EstadoMatriculaEnum.RCI.name().equals(this.estado)) {
            return true;
        }
        return false;
    }

    public boolean isEstadoMAT() {
        if (EstadoMatriculaEnum.MAT.name().equals(this.estado)) {
            return true;
        }
        return false;
    }

    public boolean isMatriculable() {
        if (EstadoMatriculaEnum.MAT.name().equals(this.estado)) {
            return true;
        }
        if (EstadoMatriculaEnum.PMAT.name().equals(this.estado)) {
            return true;
        }
        if (EstadoMatriculaEnum.NMAT.name().equals(this.estado)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MatriculaResumen)) {
            return false;
        }
        MatriculaResumen other = (MatriculaResumen) obj;
        if (id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

    public Boolean getEsUltimoCiclo() {
        if (esUltimoCiclo == null) {
            return false;
        }
        return esUltimoCiclo;
    }

    public Boolean getEsCondicional() {
        if (esCondicional == null) {
            esCondicional = false;
        }
        return esCondicional;
    }

    public Boolean getEsBeneficiadoUltimoCiclo() {
        if (esBeneficiadoUltimoCiclo == null) {
            return false;
        }
        return esBeneficiadoUltimoCiclo;
    }

    public Integer getCreditosPagados() {
        if (creditosPagados == null) {
            return 0;
        }
        return creditosPagados;
    }

    public Integer getCreditosConsumidos() {
        if (creditosConsumidos == null) {
            return 0;
        }
        return creditosConsumidos;
    }

    public Integer getCreditosDisponibles() {
        return this.getCreditosPagados() - this.getCreditosConsumidos();
    }

    public Boolean getAporteCarnet() {
        if (aporteCarnet == null) {
            return false;
        }
        return aporteCarnet;
    }

    public Boolean getBoletaPendiente() {
        if (this.boletaPendiente == null) {
            return false;
        }
        return boletaPendiente;
    }

    public Boolean getAporteDuplicadoCarnet() {
        if (aporteDuplicadoCarnet == null) {
            return false;
        }
        return aporteDuplicadoCarnet;
    }

    public void settingValoresDefecto() {
        this.estado = NMAT.name();
        this.cursosMatriculados = 0;
        this.cursosRetirados = 0;
        this.creditosMatriculados = 0;
        this.creditosMatriculadosPregrado = 0;
        this.creditosPrematriculados = 0;
        this.creditosRetirados = 0;
        this.creditosTrikaPagados = 0;
        this.creditosTrikaSeparados = 0;
    }

    public static class ComparePuntajeCapa implements Comparator<MatriculaResumen> {

        @Override
        public int compare(MatriculaResumen p1, MatriculaResumen p2) {

            if (p2.getPuntajePrioridad() == null && p1.getPuntajePrioridad() == null) {
                return 0;
            }
            if (p2.getPuntajePrioridad() == null && p1.getPuntajePrioridad() != null) {
                return -1;
            }
            if (p2.getPuntajePrioridad() != null && p1.getPuntajePrioridad() == null) {
                return 1;
            }

            Alumno a1 = p1.getAlumno();
            Alumno a2 = p2.getAlumno();

            if (p2.getPuntajePrioridad().compareTo(p1.getPuntajePrioridad()) == 0) {
                return a2.getCreditosAprobadosConvalidados().compareTo(a1.getCreditosAprobadosConvalidados());
            }
            return p2.getPuntajePrioridad().compareTo(p1.getPuntajePrioridad());
        }
    }

    public static class CompareCapaDesc implements Comparator<MatriculaResumen> {

        @Override
        public int compare(MatriculaResumen p1, MatriculaResumen p2) {
            Alumno a1 = p1.getAlumno();
            Alumno a2 = p2.getAlumno();
            return a2.getCreditosAprobadosConvalidados().compareTo(a1.getCreditosAprobadosConvalidados());
        }
    }

    public static class CompareCapaAsc implements Comparator<MatriculaResumen> {

        @Override
        public int compare(MatriculaResumen p1, MatriculaResumen p2) {
            Alumno a1 = p1.getAlumno();
            Alumno a2 = p2.getAlumno();
            return a1.getCreditosAprobadosConvalidados().compareTo(a2.getCreditosAprobadosConvalidados());
        }
    }

    public static class ComparePuntajeDescPrioridadAsc implements Comparator<MatriculaResumen> {

        @Override
        public int compare(MatriculaResumen p1, MatriculaResumen p2) {
            if (p2.getPuntajePrioridad() == null && p1.getPuntajePrioridad() == null) {
                return 0;
            }
            if (p2.getPuntajePrioridad() == null && p1.getPuntajePrioridad() != null) {
                return -1;
            }
            if (p2.getPuntajePrioridad() != null && p1.getPuntajePrioridad() == null) {
                return 1;
            }
            //
            if (p2.getPuntajePrioridad().compareTo(p1.getPuntajePrioridad()) == 0) {
                if (p2.getPrioridad() == null || p1.getPrioridad() == null) {
                    return 0;
                }
                return p1.getPrioridad().compareTo(p2.getPrioridad());
            }
            return p2.getPuntajePrioridad().compareTo(p1.getPuntajePrioridad());
        }
    }

    public static class ComparePuntajeAscPrioridadDesc implements Comparator<MatriculaResumen> {

        @Override
        public int compare(MatriculaResumen p1, MatriculaResumen p2) {
            if (p1.getPuntajePrioridad() == null && p2.getPuntajePrioridad() == null) {
                return 0;
            }
            if (p1.getPuntajePrioridad() == null && p2.getPuntajePrioridad() != null) {
                return -1;
            }
            if (p1.getPuntajePrioridad() != null && p2.getPuntajePrioridad() == null) {
                return 1;
            }
            //
            if (p1.getPuntajePrioridad().compareTo(p2.getPuntajePrioridad()) == 0) {
                if (p2.getPrioridad() == null || p1.getPrioridad() == null) {
                    return 0;
                }
                return p2.getPrioridad().compareTo(p1.getPrioridad());
            }
            return p1.getPuntajePrioridad().compareTo(p2.getPuntajePrioridad());
        }
    }

    public static class ComparePrioridadAsc implements Comparator<MatriculaResumen> {

        @Override
        public int compare(MatriculaResumen p1, MatriculaResumen p2) {
            if (p1.getPrioridad() == null && p2.getPrioridad() == null) {
                return 0;
            }
            if (p1.getPrioridad() == null && p2.getPrioridad() != null) {
                return -1;
            }
            if (p1.getPrioridad() != null && p2.getPrioridad() == null) {
                return 1;
            }
            //
            return p1.getPrioridad().compareTo(p2.getPrioridad());
        }
    }

    public static class ComparePrioridadDesc implements Comparator<MatriculaResumen> {

        @Override
        public int compare(MatriculaResumen p1, MatriculaResumen p2) {
            if (p2.getPrioridad() == null && p1.getPrioridad() == null) {
                return 0;
            }
            if (p2.getPrioridad() == null && p1.getPrioridad() != null) {
                return -1;
            }
            if (p2.getPrioridad() != null && p1.getPrioridad() == null) {
                return 1;
            }
            //
            return p2.getPrioridad().compareTo(p1.getPrioridad());
        }
    }

    public synchronized MatriculaCurso getMatriculaCursoByCurso(Curso curso) {
        if (this.getMatriculaCurso() == null) {
            return null;
        }
        for (MatriculaCurso matCurso : this.matriculaCurso) {
            Curso cur = matCurso.getCurso();
            if (cur.getId().longValue() == curso.getId()) {
                return matCurso;
            }
        }
        MatriculaCurso matCurso = new MatriculaCurso();
        matCurso.setCurso(curso);
        matCurso.setMatriculaResumen(this);
        this.matriculaCurso.add(matCurso);
        return matCurso;
    }

    @Override
    public MatriculaResumen clone() {
        MatriculaResumen clone = null;
        try {
            clone = (MatriculaResumen) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
