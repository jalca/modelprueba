package pe.edu.lamolina.model.documental;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import javax.persistence.TemporalType;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import java.io.Serializable;
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
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.general.TipoDocumentoCompania;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "doc_documento")
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "origen")
    private String origen;

    @Column(name = "generar_plantilla")
    private boolean generarPlantilla;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_documento")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaDocumento;

    @Column(name = "serie_numero")
    private String serieNumero;

    @Column(name = "folios")
    private Integer folios;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "firmante")
    private String firmante;

    @Column(name = "destinatario")
    private String destinatario;

    @Column(name = "oficina_procedencia")
    private String oficinaProcedenciaOtro;

    @Column(name = "oficina_destino")
    private String oficinaDestinoOtro;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoCompania tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_procedencia")
    private Oficina oficinaProcedencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_destino")
    private Oficina oficinaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_firma")
    private Persona personaFirma;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_destino")
    private Persona personaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plantilla")
    private PlantillaDocumental plantilla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_plantilla")
    private Archivo archivoPlantilla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_documento")
    private Archivo archivoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona_registro")
    private Persona personaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivador")
    private ArchivadorDocumental archivador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_gestora")
    private Oficina oficinaGestora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_padre")
    private Documento documentoPadre;

    @Column(name = "id_user_registro")
    private Long userRegistro;

    @Column(name = "id_user_modificacion")
    private Long userModificacion;

    @OneToMany(mappedBy = "documento", fetch = FetchType.LAZY)
    private List<AdjuntoDocumental> adjuntoDocumental;

    public Documento() {
    }

    public Documento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getSerieNumero() {
        return serieNumero;
    }

    public void setSerieNumero(String serieNumero) {
        this.serieNumero = serieNumero;
    }

    public Integer getFolios() {
        return folios;
    }

    public void setFolios(Integer folios) {
        this.folios = folios;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getFirmante() {
        return firmante;
    }

    public void setFirmante(String firmante) {
        this.firmante = firmante;
    }

    public String getOficinaProcedenciaOtro() {
        return oficinaProcedenciaOtro;
    }

    public void setOficinaProcedenciaOtro(String oficinaProcedenciaOtro) {
        this.oficinaProcedenciaOtro = oficinaProcedenciaOtro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public TipoDocumentoCompania getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoCompania tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Oficina getOficinaProcedencia() {
        return oficinaProcedencia;
    }

    public void setOficinaProcedencia(Oficina oficinaProcedencia) {
        this.oficinaProcedencia = oficinaProcedencia;
    }

    public Persona getPersonaFirma() {
        return personaFirma;
    }

    public void setPersonaFirma(Persona personaFirma) {
        this.personaFirma = personaFirma;
    }

    public PlantillaDocumental getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(PlantillaDocumental plantilla) {
        this.plantilla = plantilla;
    }

    public Archivo getArchivoPlantilla() {
        return archivoPlantilla;
    }

    public void setArchivoPlantilla(Archivo archivoPlantilla) {
        this.archivoPlantilla = archivoPlantilla;
    }

    public Archivo getArchivoDocumento() {
        return archivoDocumento;
    }

    public void setArchivoDocumento(Archivo archivoDocumento) {
        this.archivoDocumento = archivoDocumento;
    }

    public Persona getPersonaRegistro() {
        return personaRegistro;
    }

    public void setPersonaRegistro(Persona personaRegistro) {
        this.personaRegistro = personaRegistro;
    }

    public ArchivadorDocumental getArchivador() {
        return archivador;
    }

    public void setArchivador(ArchivadorDocumental archivador) {
        this.archivador = archivador;
    }

    public Oficina getOficinaGestora() {
        return oficinaGestora;
    }

    public void setOficinaGestora(Oficina oficinaGestora) {
        this.oficinaGestora = oficinaGestora;
    }

    public Long getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Long userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Long getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Long userModificacion) {
        this.userModificacion = userModificacion;
    }

    public boolean isGenerarPlantilla() {
        return generarPlantilla;
    }

    public void setGenerarPlantilla(boolean generarPlantilla) {
        this.generarPlantilla = generarPlantilla;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getOficinaDestinoOtro() {
        return oficinaDestinoOtro;
    }

    public void setOficinaDestinoOtro(String oficinaDestinoOtro) {
        this.oficinaDestinoOtro = oficinaDestinoOtro;
    }

    public Oficina getOficinaDestino() {
        return oficinaDestino;
    }

    public void setOficinaDestino(Oficina oficinaDestino) {
        this.oficinaDestino = oficinaDestino;
    }

    public Persona getPersonaDestino() {
        return personaDestino;
    }

    public void setPersonaDestino(Persona personaDestino) {
        this.personaDestino = personaDestino;
    }

    public Documento getDocumentoPadre() {
        return documentoPadre;
    }

    public void setDocumentoPadre(Documento documentoPadre) {
        this.documentoPadre = documentoPadre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<AdjuntoDocumental> getAdjuntoDocumental() {
        return adjuntoDocumental;
    }

    public void setAdjuntoDocumental(List<AdjuntoDocumental> adjuntoDocumental) {
        this.adjuntoDocumental = adjuntoDocumental;
    }

}
