package pe.edu.lamolina.model.tramite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.general.DocumentoCompania;

@Entity
@Table(name = "epg_examen_grado")
public class ExamenGrado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_tramite")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jurado_tesis")
    private JuradoTesis juradoTesis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_compania")
    private DocumentoCompania documentoCompania;

    public ExamenGrado() {
        
    }

    public ExamenGrado(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoTramite getEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(EstadoTramite estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public JuradoTesis getJuradoTesis() {
        return juradoTesis;
    }

    public void setJuradoTesis(JuradoTesis juradoTesis) {
        this.juradoTesis = juradoTesis;
    }

    public DocumentoCompania getDocumentoCompania() {
        return documentoCompania;
    }

    public void setDocumentoCompania(DocumentoCompania documentoCompania) {
        this.documentoCompania = documentoCompania;
    }

}
