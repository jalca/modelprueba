package pe.edu.lamolina.model.posgrado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.BecadoPosgradoEstadoEnum;
import pe.edu.lamolina.model.enums.TipoPatrocinioBecaEnum;
import pe.edu.lamolina.model.general.DocumentoCompania;
import pe.edu.lamolina.model.general.DocumentoExterno;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.tramite.Resolucion;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_becado_posgrado")
public class BecadoPosgrado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "porcentaje")
    private int porcentaje;

    @Column(name = "numero_beca")
    private int numeroBeca;

    @Column(name = "tipo_patrocinio")
    private String tipoPatrocinio;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patrocinador")
    private Empresa patrocinador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_compania")
    private DocumentoCompania documentoCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_externo")
    private DocumentoExterno documentoExterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_beca_posgrado")
    private TipoBecaPosgrado tipoBecaPosgrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion")
    private Resolucion resolucion;

    public BecadoPosgrado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public BecadoPosgrado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getNumeroBeca() {
        return numeroBeca;
    }

    public void setNumeroBeca(int numeroBeca) {
        this.numeroBeca = numeroBeca;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public BecadoPosgradoEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return BecadoPosgradoEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(BecadoPosgradoEstadoEnum estado) {
        this.estado = estado.name();
    }

    public DocumentoCompania getDocumentoCompania() {
        return documentoCompania;
    }

    public void setDocumentoCompania(DocumentoCompania documentoCompania) {
        this.documentoCompania = documentoCompania;
    }

    public TipoBecaPosgrado getTipoBecaPosgrado() {
        return tipoBecaPosgrado;
    }

    public void setTipoBecaPosgrado(TipoBecaPosgrado tipoBecaPosgrado) {
        this.tipoBecaPosgrado = tipoBecaPosgrado;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoPatrocinio() {
        return tipoPatrocinio;
    }

    public void setTipoPatrocinio(String tipoPatrocinio) {
        this.tipoPatrocinio = tipoPatrocinio;
    }

    public TipoPatrocinioBecaEnum getTipoPatrocinioEnum() {
        if (StringUtils.isBlank(this.tipoPatrocinio)) {
            return null;
        }
        return TipoPatrocinioBecaEnum.valueOf(this.tipoPatrocinio);
    }

    @JsonIgnore
    public void setTipoPatrocinioEnum(TipoPatrocinioBecaEnum tipoPatrocinio) {
        if (tipoPatrocinio == null) {
            return;
        }
        this.tipoPatrocinio = tipoPatrocinio.name();
    }

    public Empresa getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Empresa patrocinador) {
        this.patrocinador = patrocinador;
    }

    public DocumentoExterno getDocumentoExterno() {
        return documentoExterno;
    }

    public void setDocumentoExterno(DocumentoExterno documentoExterno) {
        this.documentoExterno = documentoExterno;
    }

}
