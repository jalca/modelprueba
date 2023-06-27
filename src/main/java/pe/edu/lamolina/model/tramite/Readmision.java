package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
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
import javax.persistence.Transient;
import lombok.Data;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.albatross.zelpers.spring.deserializer.DateTimeDeserializer;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.seguridad.Usuario;

@Data
@Entity
@Table(name = "tram_readmision")
public class Readmision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "motivo_rechazo")
    private String motivoRechazo;

    @Column(name = "aceptado")
    private Integer aceptado;

    @Column(name = "es_condicional")
    private Boolean esCondicional;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private EstadoTramite estadoTramite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_readmitido")
    private CicloAcademico cicloReadmitido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resolucion")
    private Resolucion resolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Transient
    private boolean seleccionado;

    @Transient
    private boolean rechazado;

    public Readmision() {
        this.aceptado = 0;
        this.esCondicional = false;
    }

    public Readmision(Object id) {
        this.id = TypesUtil.getLong(id);
        this.aceptado = 0;
        this.esCondicional = false;
    }

    public boolean getEstaAceptado() {
        if (this.aceptado.compareTo(BigDecimal.ONE.intValue()) == 0) {
            return true;
        }
        return false;
    }

    public Boolean getEsCondicional() {
        if (esCondicional == null) {
            return false;
        }
        return esCondicional;
    }

    public static class CompareCiclo implements Comparator<Readmision> {

        @Override
        public int compare(Readmision s1, Readmision s2) {
            return s1.getCicloReadmitido().getCodigo().compareTo(s2.getCicloReadmitido().getCodigo());
        }

    }

    public boolean getEsPosibleRevertirEstadoTram() {
        if (this.getEstadoTramite().getEsSolicitudHistorialRevisado()
                || this.getEstadoTramite().getEsConsejoFacultad()) {
            return true;
        }
        return false;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

}
