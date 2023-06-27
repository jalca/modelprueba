package pe.edu.lamolina.model.inscripcion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Comparator;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.ModalidadEstudio;
import pe.edu.lamolina.model.calificacion.TemaExamenModalidad;
import pe.edu.lamolina.model.constantines.AdmisionConstantine;
import pe.edu.lamolina.model.enums.ModalidadIngresoEstadoEnum;
import pe.edu.lamolina.model.finanzas.ConceptoPago;
import pe.edu.lamolina.model.finanzas.CostoModalidad;

@Entity
@Table(name = "sip_modalidad_ingreso")
public class ModalidadIngreso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre_inscripcion")
    private String nombreInscripcion;

    @Column(name = "nombre_corto")
    private String nombreCorto;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "orden")
    private Integer orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_superior")
    private ModalidadIngreso modalidadSuperior;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_estudio")
    private ModalidadEstudio modalidadEstudio;

    @OneToMany(mappedBy = "modalidadIngreso", fetch = FetchType.LAZY)
    private List<Postulante> postulante;

    @OneToMany(mappedBy = "modalidadSuperior", fetch = FetchType.LAZY)
    private List<ModalidadIngreso> modalidadInferior;

    @OneToMany(mappedBy = "modalidad", fetch = FetchType.LAZY)
    private List<DocumentoModalidad> documentoModalidad;

    @OneToMany(mappedBy = "modalidadIngreso", fetch = FetchType.LAZY)
    private List<ConceptoPago> conceptoPago;

    @OneToMany(mappedBy = "modalidadIngreso", fetch = FetchType.LAZY)
    private List<CostoModalidad> costoModalidad;

    @OneToMany(mappedBy = "modalidadIngreso", fetch = FetchType.LAZY)
    private List<ModalidadIngresoCiclo> modalidadIngresoCiclo;

    @OneToMany(mappedBy = "modalidadIngreso", fetch = FetchType.LAZY)
    private List<TemaExamenModalidad> temaExamenModalidad;

    @Transient
    private Boolean activado;
    @Transient
    private Integer porcentajeAumentoNota;
    @Transient
    private ModalidadIngresoCiclo modalidadIngresoCicloActual;

    public ModalidadIngreso() {
    }

    public boolean isPrimerosPuestos() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_PRIMEROS_PUESTOS);
    }

    public boolean isTrasladoExterno() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_TRASLADO);
    }

    public boolean isConcursoOrdinario() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_ORDINARIO);
    }

    public boolean isParticipanteLibre() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_PARTICIPANTE_LIBRE);
    }

    public boolean isQuintoSecundaria() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_QUINTO_SECUNDARA);
    }

    public boolean isGraduadosTituladosUniversitarios() {
        if (codigo == null) {
            return false;
        }
        if (this.modalidadSuperior != null) {
            return this.modalidadSuperior.getCodigo().equals(AdmisionConstantine.CODE_MODALIDAD_GRADUADOS_TITULADOS);
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_GRADUADOS_TITULADOS);
    }

    public boolean isPreLaMolina() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_CEPRE);
    }

    public boolean isConvenioAndresBello() {
        if (codigo == null) {
            return false;
        }
        return AdmisionConstantine.CODE_MODALIDAD_ANDRES_BELLO.contains(codigo);
    }

    public boolean isPir() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_PIR);
    }

    public boolean isBecarioExtranjero() {
        if (codigo == null) {
            return false;
        }
        return codigo.equals(AdmisionConstantine.CODE_MODALIDAD_BECARIO_EXTRANJERO);
    }

    public boolean isOtrasModalidades() {
        if (codigo == null) {
            return false;
        }
        if (codigo.equals(AdmisionConstantine.CODE_MODALIDAD_CONCURSO_ORDINARIO)) {
            return false;
        }
        if (codigo.equals(AdmisionConstantine.CODE_MODALIDAD_CEPRE)) {
            return false;
        }
        return true;
    }

    public ModalidadIngreso(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModalidadEstudio getModalidadEstudio() {
        return modalidadEstudio;
    }

    public void setModalidadEstudio(ModalidadEstudio modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreInscripcion() {
        return nombreInscripcion;
    }

    public void setNombreInscripcion(String nombreInscripcion) {
        this.nombreInscripcion = nombreInscripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonIgnore
    public void setEstadoEnum(ModalidadIngresoEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public ModalidadIngresoEstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return ModalidadIngresoEstadoEnum.valueOf(estado);
    }

    public List<Postulante> getPostulante() {
        return postulante;
    }

    public void setPostulante(List<Postulante> postulante) {
        this.postulante = postulante;
    }

    public ModalidadIngreso getModalidadSuperior() {
        return modalidadSuperior;
    }

    public void setModalidadSuperior(ModalidadIngreso modalidadSuperior) {
        this.modalidadSuperior = modalidadSuperior;
    }

    public List<ModalidadIngreso> getModalidadInferior() {
        return modalidadInferior;
    }

    public void setModalidadInferior(List<ModalidadIngreso> modalidadInferior) {
        this.modalidadInferior = modalidadInferior;
    }

    public List<DocumentoModalidad> getDocumentoModalidad() {
        return documentoModalidad;
    }

    public void setDocumentoModalidad(List<DocumentoModalidad> documentoModalidad) {
        this.documentoModalidad = documentoModalidad;
    }

    public List<ConceptoPago> getConceptoPago() {
        return conceptoPago;
    }

    public void setConceptoPago(List<ConceptoPago> conceptoPago) {
        this.conceptoPago = conceptoPago;
    }

    public List<CostoModalidad> getCostoModalidad() {
        return costoModalidad;
    }

    public void setCostoModalidad(List<CostoModalidad> costoModalidad) {
        this.costoModalidad = costoModalidad;
    }

    public Boolean getActivado() {
        return activado;
    }

    public void setActivado(Boolean activado) {
        this.activado = activado;
    }

    public List<ModalidadIngresoCiclo> getModalidadIngresoCiclo() {
        return modalidadIngresoCiclo;
    }

    public void setModalidadIngresoCiclo(List<ModalidadIngresoCiclo> modalidadIngresoCiclo) {
        this.modalidadIngresoCiclo = modalidadIngresoCiclo;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public List<TemaExamenModalidad> getTemaExamenModalidad() {
        return temaExamenModalidad;
    }

    public void setTemaExamenModalidad(List<TemaExamenModalidad> temaExamenModalidad) {
        this.temaExamenModalidad = temaExamenModalidad;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getPorcentajeAumentoNota() {
        return porcentajeAumentoNota;
    }

    public void setPorcentajeAumentoNota(Integer porcentajeAumentoNota) {
        this.porcentajeAumentoNota = porcentajeAumentoNota;
    }

    public ModalidadIngresoCiclo getModalidadIngresoCicloActual() {
        return modalidadIngresoCicloActual;
    }

    public void setModalidadIngresoCicloActual(ModalidadIngresoCiclo modalidadIngresoCicloActual) {
        this.modalidadIngresoCicloActual = modalidadIngresoCicloActual;
    }

    public static class CompareCodigo implements Comparator<ModalidadIngreso> {

        @Override
        public int compare(ModalidadIngreso mi1, ModalidadIngreso mi2) {
            return mi1.getCodigo().compareTo(mi2.getCodigo());
        }
    }

}
