package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.ListsInspector;
import pe.albatross.zelpers.miscelanea.NumberFormat;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.ModoDictadoSeccionEnum;
import static pe.edu.lamolina.model.enums.ModoDictadoSeccionEnum.PRES;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.horario.GrupoHoras;
import pe.edu.lamolina.model.horario.HorarioSeccion;
import pe.edu.lamolina.model.tramite.RetiroCurso;
import pe.edu.lamolina.model.enums.SeccionEstadoEnum;
import static pe.edu.lamolina.model.enums.SeccionEstadoEnum.ACT;
import static pe.edu.lamolina.model.enums.SeccionEstadoEnum.BLO;
import static pe.edu.lamolina.model.enums.SeccionEstadoEnum.CRE;
import pe.edu.lamolina.model.enums.SituacionDocenteEnum;
import pe.edu.lamolina.model.enums.TipoSeccionEnum;
import pe.edu.lamolina.model.enums.TipoSeccionEvalEnum;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.general.TipoCarpeta;
import pe.edu.lamolina.model.horario.Hora;
import pe.edu.lamolina.model.horario.HorarioAula;
import pe.edu.lamolina.model.horario.SeccionHorarioCachimbos;
import pe.edu.lamolina.model.rolexamen.FechaHoraGrupoExamen;
import pe.edu.lamolina.model.rolexamen.GrupoHorasExamen;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.vacantes.VacanteAlumno;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@Table(name = "aca_seccion")
public class Seccion implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "codigo2")
    private String codigo2;

    @Column(name = "codigo3")
    private String codigo3;

    @Column(name = "tipo_seccion")
    private String tipoSeccion;

    @Column(name = "es_principal")
    private Integer esPrincipal;

    @Column(name = "devolucion")
    private Integer devolucion;

    @Column(name = "horas_semanales")
    private Integer horasSemanales;

    @Column(name = "horas_adicionales")
    private Integer horasAdicionales;

    @Column(name = "vacantes")
    private Integer vacantes;

    @Column(name = "matriculados")
    private Integer matriculados;

    @Column(name = "prematriculados")
    private Integer prematriculados;

    @Column(name = "retirados")
    private Integer retirados;

    @Column(name = "reservados")
    private Integer reservados;

    @Column(name = "ampliacion_vacante")
    private Integer ampliacionVacante;

    @Column(name = "restriccion_capa")
    private Integer restriccionCapa;

    @Column(name = "solicitudes_aceptadas")
    private Integer solicitudesAceptadas;

    @Column(name = "estado")
    private String estado;

    @Column(name = "motivo_cancelacion")
    private String motivoCancelacion;

    @Column(name = "situacion_docente")
    private String situacionDocente;

    @Column(name = "modo_dictado")
    private String modoDictado;

    @Column(name = "link_zoom")
    private String linkZoom;

    @Column(name = "id_zoom")
    private Long idZoom;

    @Column(name = "precio_personalizado")
    private Boolean precioPersonalizado;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "precio_base")
    private BigDecimal precioBase;

    @Column(name = "descuento_precio")
    private BigDecimal descuentoPrecio;

    @Column(name = "abono_verano")
    private BigDecimal abonoVerano;

    @Column(name = "aula_asignada_auto")
    private Boolean aulaAsignadaAuto;

    @Column(name = "aula_borrada_por_cruce")
    private Boolean aulaBorradaPorCruce;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @Column(name = "fecha_precio")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaPrecio;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_asignacion_auto")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaAsignacionAuto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seccion_superior")
    private Seccion seccionSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas")
    private GrupoHoras grupoHoras;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_seccion")
    private GrupoSeccion grupoSeccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_carpeta")
    private TipoCarpeta tipoCarpeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aula_borrada")
    private Aula aulaBorrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno_pagador")
    private Alumno alumnoPagador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_modificacion")
    private Usuario usuarioModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_precio")
    private Usuario userPrecio;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<DocenteSeccion> docenteSeccion;

    @OneToMany(mappedBy = "seccionResponsable", fetch = FetchType.LAZY)
    private List<Evaluacion> evaluacion;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<LoggerMatricula> loggerMatricula;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<MatriculaSeccion> matriculaSeccion;

    @OneToMany(mappedBy = "seccionSuperior", fetch = FetchType.LAZY)
    private List<Seccion> seccion;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<HorarioSeccion> horarioSeccion;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<HorarioAula> horariosAula;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<RetiroCurso> retiroCurso;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<SeccionHorarioCachimbos> seccionHorarioCachimbos;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<RestriccionModalidad> restriccionesModalidad;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<RestriccionFacultad> restriccionesFacultad;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<RestriccionCarrera> restriccionesCarrera;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<RestriccionRepitencia> restriccionesRepitencia;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<VacanteAlumno> vacantesAlumnos;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<AmpliacionVacantes> ampliacionesVacantes;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<CambioAulaGrupo> cambioAulaGrupos;

    @OneToMany(mappedBy = "seccion", fetch = FetchType.LAZY)
    private List<DescuentoSeccionVerano> descuentoSeccionVeranos;

    @Column(name = "solicitudes_matricula")
    private Integer solicitudesMatricula;

    @Transient
    private Integer solicitudesMatriculaAlt;

    @Transient
    @JsonIgnore
    private DocenteSeccion tDocenteSeccion;

    @Transient
    private String codigoGrupoHorario;
    @Transient
    private String codigoAula;
    @Transient
    private String codigoGrupoSeccion;
    @Transient
    private String codigoTipoSeccion;
    @Transient
    private Boolean verInformacion;
    @Transient
    private Integer suscritos;
    @Transient
    private String aleatorio;
    @Transient
    private Integer retiradosCurso;
    @Transient
    private Integer retiradosCiclo;
    @Transient
    private Integer idAlumno;
    @Transient
    private Integer sizeDocente;
    @Transient
    private Docente docentePrincipal;
    @Transient
    private boolean docentePrincipalLogeado;
    @Transient
    private boolean docentePrincipaTcurLogeado;
    @Transient
    private boolean incrementado;
    @Transient
    private Integer cantidadIncrementada;
    @Transient
    private String letraExamen;

    public Seccion() {
        this.verInformacion = false;
        this.vacantes = BigDecimal.ZERO.intValue();
        this.matriculados = BigDecimal.ZERO.intValue();
        this.reservados = BigDecimal.ZERO.intValue();
        this.retirados = BigDecimal.ZERO.intValue();
        this.ampliacionVacante = BigDecimal.ZERO.intValue();
        this.prematriculados = BigDecimal.ZERO.intValue();
        this.solicitudesMatricula = BigDecimal.ZERO.intValue();
        this.solicitudesAceptadas = BigDecimal.ZERO.intValue();
        this.devolucion = 1;
        this.modoDictado = PRES.name();
    }

    public Seccion(String codigo, String codigo2, String codigoGrupoHorario, String codigoAula, String codigoGrupoSeccion, String codigoTipoSeccion,
            Integer vacantes, Integer matriculados, Integer restriccionCapa) {
        this.codigo3 = codigo;
        this.codigo2 = codigo2;
        this.codigoGrupoHorario = codigoGrupoHorario;
        this.codigoAula = codigoAula;
        this.codigoGrupoSeccion = codigoGrupoSeccion;
        this.codigoTipoSeccion = codigoTipoSeccion;
        this.verInformacion = false;
        this.vacantes = vacantes;
        this.matriculados = matriculados;
        this.restriccionCapa = restriccionCapa;
    }

    public Seccion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Seccion(Long matriculados, Long retiradosCurso, Long retiradosCiclo) {
        this.matriculados = matriculados.intValue();
        this.retiradosCurso = retiradosCurso.intValue();
        this.retiradosCiclo = retiradosCiclo.intValue();
        this.retirados = retiradosCurso.intValue() + retiradosCiclo.intValue();
    }

    public TipoSeccionEnum getTipoSeccionEnum() {
        if (tipoSeccion == null) {
            return null;
        }
        return TipoSeccionEnum.valueOf(tipoSeccion);
    }

    @JsonIgnore
    public void setTipoSeccionEnum(TipoSeccionEnum tipoSeccion) {
        if (tipoSeccion == null) {
            return;
        }
        this.tipoSeccion = tipoSeccion.name();
    }

    public Integer getVacantes() {
        if (vacantes == null) {
            return 0;
        }
        return vacantes;
    }

    public Integer getMatriculados() {
        if (matriculados == null) {
            return 0;
        }
        return matriculados;
    }

    public synchronized void setMatriculados(Integer matriculados) {
        this.matriculados = matriculados;
    }

    public SeccionEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return SeccionEstadoEnum.valueOf(this.getEstado());
    }

    @JsonIgnore
    public void setEstadoEnum(SeccionEstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public Integer getDisponiblesCachimbos() {
        return this.vacantes - this.matriculados - this.reservados;
    }

    public Integer getVacantesDisponibles() {
        if (solicitudesMatricula == null) {
            solicitudesMatricula = 0;
        }
        return this.vacantes - this.matriculados - this.reservados - this.solicitudesMatricula - this.ampliacionVacante;
    }

    public Integer getVacantesOcupadas() {
        if (solicitudesMatricula == null) {
            solicitudesMatricula = 0;
        }
        return this.matriculados + this.reservados + this.solicitudesMatricula;
    }

    public SituacionDocenteEnum getSituacionDocenteEnum() {
        if (StringUtils.isNotBlank(this.situacionDocente)) {
            return SituacionDocenteEnum.valueOf(this.situacionDocente);
        }
        return null;
    }

    @JsonIgnore
    public void setSituacionDocenteEnum(SituacionDocenteEnum situacionDocente) {
        if (situacionDocente == null) {
            return;
        }
        this.situacionDocente = situacionDocente.name();
    }

    public synchronized void setPrematriculados(Integer prematriculados) {
        this.prematriculados = prematriculados;
    }

    public BigDecimal getPrecio() {
        if (precio == null) {
            return BigDecimal.ZERO;
        }
        return precio;
    }

    public String getPrecioFormato() {
        if (precio == null) {
            return null;
        }
        return NumberFormat.precio(precio);
    }

    public Boolean getPrecioPersonalizado() {
        if (precioPersonalizado == null) {
            return false;
        }
        return precioPersonalizado;
    }

    public BigDecimal getAbonoVerano() {
        if (abonoVerano == null) {
            return BigDecimal.ZERO;
        }
        return abonoVerano;
    }

    public String getAbonoVeranoFormato() {
        if (this.abonoVerano == null) {
            return null;
        }
        return NumberFormat.precio(this.abonoVerano);
    }

    public String getPrecioBaseFormato() {
        if (this.precioBase == null) {
            return null;
        }
        return NumberFormat.precio(this.precioBase);
    }

    public Integer getHorasAdicionales() {
        if (this.horasAdicionales != null) {
            return horasAdicionales;
        }
        return 0;
    }

    public Integer getTotalHorasSemanales() {
        return this.getHorasAdicionales() + this.horasSemanales;
    }

    public Boolean getAulaAsignadaAuto() {
        if (this.aulaAsignadaAuto == null) {
            return false;
        }
        return aulaAsignadaAuto;
    }

    public Integer getAmpliacionVacante() {
        if (ampliacionVacante == null) {
            return 0;
        }
        return ampliacionVacante;
    }

    public Integer getSolicitudesMatricula() {
        if (solicitudesMatricula == null) {
            return 0;
        }
        return solicitudesMatricula;
    }

    public void setSolicitudesMatricula(Integer solicitudesMatricula) {
        this.solicitudesMatricula = solicitudesMatricula;
    }

    public boolean getIsTipoSeccionTCUR() {
        if (TipoSeccionEnum.TCUR.equals(this.getTipoSeccionEnum())) {
            return true;
        }
        return false;
    }

    public boolean isTipoSeccionTCUR() {
        if (TipoSeccionEnum.TCUR.equals(this.getTipoSeccionEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsTipoSeccionPCUR() {
        if (TipoSeccionEnum.PCUR.equals(this.getTipoSeccionEnum())) {
            return true;
        }
        return false;
    }

    public boolean isTipoSeccionPCUR() {
        if (TipoSeccionEnum.PCUR.equals(this.getTipoSeccionEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsTipoSeccionTEO() {
        if (TipoSeccionEnum.TEO.equals(this.getTipoSeccionEnum())) {
            return true;
        }
        return false;
    }

    public boolean isTipoSeccionTEO() {
        if (TipoSeccionEnum.TEO.equals(this.getTipoSeccionEnum())) {
            return true;
        }
        return false;
    }

    public boolean getIsTipoSeccionEvaluacionTeoria() {
        if (this.getTipoSeccionEnum().getTipoSeccionEvalEnum().equals(TipoSeccionEvalEnum.TEO)) {
            return true;
        }
        return false;
    }

    public boolean getIsTipoSeccionEvaluacionPractica() {
        if (this.getTipoSeccionEnum().getTipoSeccionEvalEnum().equals(TipoSeccionEvalEnum.PRAC)) {
            return true;
        }
        return false;
    }

    public boolean getIsTipoSeccionPRA() {
        if (TipoSeccionEnum.PRA.equals(this.getTipoSeccionEnum())) {
            return true;
        }
        return false;
    }

    public boolean isTipoSeccionPRA() {
        if (TipoSeccionEnum.PRA.equals(this.getTipoSeccionEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoOperativo() {
        if (Arrays.asList(ACT, BLO, CRE).contains(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoNoOperativo() {
        if (!Arrays.asList(ACT, BLO, CRE).contains(this.getEstadoEnum())) {
            return true;
        }
        return false;
    }

    public boolean isEstadoActivado() {
        if (this.getEstadoEnum() == SeccionEstadoEnum.ACT) {
            return true;
        }
        return false;
    }

    public boolean isEstadoCancelado() {
        if (this.getEstadoEnum() == SeccionEstadoEnum.CAN) {
            return true;
        }
        return false;
    }

    public boolean isEstadoAnulado() {
        if (this.getEstadoEnum() == SeccionEstadoEnum.ANU) {
            return true;
        }
        return false;
    }

    public boolean isEstadoBloqueado() {
        if (this.getEstadoEnum() == SeccionEstadoEnum.BLO) {
            return true;
        }
        return false;
    }

    public boolean isEstadoCreado() {
        if (this.getEstadoEnum() == SeccionEstadoEnum.CRE) {
            return true;
        }
        return false;
    }

    public Integer getDocentesCant() {
        Integer cant = 0;
        if (this.getDocenteSeccion() != null && !this.getDocenteSeccion().isEmpty()) {
            return this.getDocenteSeccion().size();
        }
        return cant;
    }

    public boolean isTieneRestriccion() {
        if (this.isTieneRestriccionCarrera()
                || this.isTieneRestriccionFacultad()
                || this.isTieneRestriccionModalidad()) {
            return true;
        }
        return false;
    }

    public boolean isTieneRestriccionCarrera() {
        if (this.getRestriccionesCarrera() != null && !this.getRestriccionesCarrera().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isTieneRestriccionFacultad() {
        if (this.getRestriccionesFacultad() != null && !this.getRestriccionesFacultad().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isTieneRestriccionModalidad() {
        if (this.getRestriccionesModalidad() != null && !this.getRestriccionesModalidad().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isTieneRestriccionRepitencia() {
        if (this.getRestriccionesRepitencia() != null && !this.getRestriccionesRepitencia().isEmpty()) {
            return true;
        }
        return false;
    }

    public Integer getSolicitudesAceptadas() {
        if (solicitudesAceptadas == null) {
            return 0;
        }
        return solicitudesAceptadas;
    }

    public boolean isIncrementado() {
        return incrementado;
    }

    public void setIncrementado(boolean incrementado) {
        this.incrementado = incrementado;
    }

    public String getDescuentoPrecioFormato() {
        if (this.descuentoPrecio == null) {
            return null;
        }
        return NumberFormat.precio(this.descuentoPrecio);
    }

    public ModoDictadoSeccionEnum getModoDictadoEnum() {
        if (modoDictado == null) {
            return null;
        }
        return ModoDictadoSeccionEnum.valueOf(modoDictado);
    }

    public BigDecimal getSaldoPrecioBase() {
        if (this.precioBase == null) {
            return null;
        }
        if (this.descuentoPrecio == null) {
            return null;
        }
        if (this.abonoVerano == null) {
            return null;
        }
        BigDecimal saldo = this.precioBase.subtract(descuentoPrecio).subtract(abonoVerano);
        if (saldo.compareTo(BigDecimal.ZERO) > 0) {
            return saldo;
        }
        return BigDecimal.ZERO;
    }

    public String getSaldoPrecioBaseFormato() {
        if (this.getSaldoPrecioBase() == null) {
            return null;
        }
        return NumberFormat.precio(this.getSaldoPrecioBase());
    }

    public String getHorarioAndAula() {
        if (this.aula != null && this.grupoHoras != null) {
            return this.grupoHoras.getCodigo() + "-" + this.getAula().getCodigo();
        }
        return "";
    }

    public String getHorariosConcat() {
        String result = "";
        if (this.horarioSeccion != null) {
            for (HorarioSeccion horarioSeccion1 : this.horarioSeccion) {
                result = result + "(" + horarioSeccion1.getIdDiaHora() + ")";
            }
            result = result + "-aul" + this.getAula().getCodigo();
        }
        return result;
    }

    public void validarGrupoExamen(List<GrupoHorasExamen> grupoHorasExamen) {
        this.letraExamen = null;
        if (this.grupoHoras == null) {
            return;
        }
        for (GrupoHorasExamen ghe : grupoHorasExamen) {
            if (this.grupoHoras.getCodigo().equals(ghe.getGrupoHoras().getLetra())) {
                this.letraExamen = ghe.getGrupoHoras().getCodigo();
                break;
            }
        }
        if (this.letraExamen != null) {
            return;
        }
        if (this.horarioSeccion == null) {
            return;
        }
        int count = 0;
        for (GrupoHorasExamen ghe : grupoHorasExamen) {
            List<FechaHoraGrupoExamen> fechaHoraLista = ghe.getFechasHorasGruposExamen();
            ListsInspector inspector = TypesUtil.analizeLists(fechaHoraLista, this.horarioSeccion, "idDiaHora");
            count = inspector.getOldListDB().size() > count ? inspector.getOldListDB().size() : count;
        }
        if (count == 0) {
            return;
        }
        for (GrupoHorasExamen ghe : grupoHorasExamen) {
            List<FechaHoraGrupoExamen> fechaHoraLista = ghe.getFechasHorasGruposExamen();
            ListsInspector inspector = TypesUtil.analizeLists(fechaHoraLista, this.horarioSeccion, "idDiaHora");
            int countFase = inspector.getOldListDB().size() > count ? inspector.getOldListDB().size() : count;
            if (countFase == count) {
                this.letraExamen = ghe.getGrupoHoras().getCodigo();
                return;
            }
        }
    }

    public static class CompareCodigo implements Comparator<Seccion> {

        @Override
        public int compare(Seccion s1, Seccion s2) {
            return s1.getCodigo().compareTo(s2.getCodigo());
        }
    }

    public static class CompareCodigo2 implements Comparator<Seccion> {

        @Override
        public int compare(Seccion s1, Seccion s2) {
            return s1.getCodigo2().compareTo(s2.getCodigo2());
        }
    }

    public static class CompareCodigo3 implements Comparator<Seccion> {

        @Override
        public int compare(Seccion s1, Seccion s2) {
            return s1.getCodigo3().compareTo(s2.getCodigo3());
        }
    }

    public static class CompareReservadosAleatorio implements Comparator<Seccion> {

        @Override
        public int compare(Seccion s1, Seccion s2) {
            if (s1.getReservados() == s2.getReservados().intValue()) {
                return s1.getAleatorio().compareTo(s2.getAleatorio());
            } else {
                return s1.getReservados().compareTo(s2.getReservados());
            }
        }
    }

    public static class CompareOrdenExamen implements Comparator<Seccion> {

        @Override
        public int compare(Seccion s1, Seccion s2) {
            if (s1.getHorarioSeccion().size() != s2.getHorarioSeccion().size()) {
                return s2.getHorarioSeccion().size() > s1.getHorarioSeccion().size() ? 1 : -1;
            }
            if (s1.getLetraExamen() == null && s2.getLetraExamen() == null) {
                return 0;
            }
            if (s1.getLetraExamen() != null && s2.getLetraExamen() == null) {
                return 1;
            }
            if (s1.getLetraExamen() == null && s2.getLetraExamen() != null) {
                return -1;
            }
            return s1.getLetraExamen().compareTo(s2.getLetraExamen());
        }
    }

    public List<String> getDiaHoraList() {
        List<String> result = this.getHorarioSeccion()
                .stream().map(x -> x.getDia().getNumeroDia() + "-" + x.getHora().getNumero())
                .collect(Collectors.toList());
        return result;
    }

    public String getHorarioTexto() {
        if (this.horarioSeccion == null) {
            return "";
        }
        if (this.horarioSeccion.isEmpty()) {
            return "";
        }

        String horario = "";
        Map<Long, List<Hora>> mapDiaHoras = TypesUtil.convertListToMapList("dia.id", "hora", this.horarioSeccion);
        List<Dia> dias = this.horarioSeccion.stream().map(x -> x.getDia()).distinct().collect(Collectors.toList());
        Collections.sort(dias, new Dia.CompareNumero());

        boolean inicio = true;
        String horaTextoAntes = "";
        String horaTexto = "";
        List<Dia> diasBloque = new ArrayList();
        List<String> mensajeHora = new ArrayList();

        for (Dia dia : dias) {

            List<Hora> horas = mapDiaHoras.get(dia.getId());
            Collections.sort(horas, new Hora.CompareCodigo());

            String horaInicio = "";
            String horaFin = "";

            List<Hora> horasDelete = new ArrayList();

            while (!horas.isEmpty()) {
                horaInicio = "";
                horaFin = "";
                horaTexto = "";

                for (int i = 0; i < horas.size(); i++) {

                    if (i == 0) {
                        horaInicio = horas.get(0).getDescripcion2();
                        horasDelete.add(horas.get(0));
                        if (horas.size() == 1) {
                            horaFin = horas.get(i).getDescripcion2Fin();
                            horaTexto = horaInicio + " a " + horaFin;
                        }
                        continue;
                    }

                    if (horas.get(i).getDescripcion2().equalsIgnoreCase(horas.get(i - 1).getDescripcion2Fin())) {
                        horaFin = horas.get(i).getDescripcion2Fin();
                        horaTexto = horaInicio + " a " + horaFin;
                        horasDelete.add(horas.get(i));
                    } else {
                        break;
                    }

                }

                mensajeHora.add(horaTexto);
                for (Hora hora : horasDelete) {
                    horas.remove(hora);
                }

                if (horas.isEmpty()) {
                    break;
                }
            }

            horaTexto = "";
            for (String msgHora : mensajeHora) {
                horaTexto += msgHora + " - ";
            }

            mensajeHora.clear();
            if (inicio) {
                diasBloque.add(dia);
                inicio = false;
                horaTextoAntes = horaTexto.substring(0, horaTexto.length() - 2);
                continue;

            } else if (horaTexto.substring(0, horaTexto.length() - 2).equals(horaTextoAntes)) {
                diasBloque.add(dia);
                continue;

            }

            horario += horario.equals("") ? "" : " y ";
            horario += createDiasBloqueTexto(diasBloque);
            horario += " " + horaTextoAntes;

            horaTextoAntes = horaTexto.substring(0, horaTexto.length() - 2);
            diasBloque.clear();
            diasBloque.add(dia);
        }

        horario += horario.equals("") ? "" : " y ";
        horario += createDiasBloqueTexto(diasBloque);
        horario += " " + horaTexto.substring(0, horaTexto.length() - 2);

        return horario;
    }

    private String createDiasBloqueTexto(List<Dia> dias) {
        String diasBloqueTexto = "";
        if (dias.isEmpty()) {
            return diasBloqueTexto;
        }
        if (dias.size() == 1) {
            return dias.get(0).getSimbolo();
        }

        boolean correlativo = true;
        int nroDiaAntes = dias.get(0).getNumeroDia() - 1;
        for (Dia dia : dias) {
            correlativo = correlativo && dia.getNumeroDia() == nroDiaAntes;
        }
        if (correlativo) {
            return dias.get(0).getSimbolo() + " a " + dias.get(dias.size() - 1).getSimbolo();
        }
        for (Dia dia : dias) {
            diasBloqueTexto += diasBloqueTexto.equals("") ? "" : ", ";
            diasBloqueTexto += dia.getSimbolo();
        }

        return diasBloqueTexto;
    }

    public String getNombre() {
        if (this.grupoSeccion == null) {
            return "";
        }
        if (this.grupoSeccion.getCurso() == null) {
            return "";
        }
        String nombre = this.codigo2 + " - ";
        if (this.grupoHoras != null) {
            nombre += this.grupoHoras.getCodigo();
            if (this.matriculados != null) {
                nombre += " (" + this.matriculados + ")";
            }
            nombre += " - ";
        }
        Curso curso = this.grupoSeccion.getCurso();
        nombre += curso.getCodigo() + " " + curso.getTpc() + " " + curso.getNombre();

        return nombre;
    }

    @Override
    public Seccion clone() {
        Seccion clone = null;
        try {
            clone = (Seccion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) obj;
        if (this.getId().compareTo(other.getId()) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seccion{" + "id=" + id + ", codigo=" + codigo + ", codigo2=" + codigo2 + ", tipoSeccion=" + tipoSeccion + '}';
    }

}
