package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.ResolucionEstadoEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Oficina;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "tram_resolucion")
public class Resolucion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "aplicacion_directa")
    private Long aplicacionDirecta;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private String numero;

    @Column(name = "numero_visible")
    private String numeroVisible;

    @Column(name = "ruta_url")
    private String rutaUrl;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cargo_rendir_cuenta")
    private Boolean cargoRendirCuenta;

    @Column(name = "fecha")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_actualizacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reunion_consejo")
    private ReunionConsejo reunionConsejo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_resolucion")
    private TipoResolucion tipoResolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo")
    private Archivo archivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_aplica")
    private CicloAcademico cicloAplica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_actualizacion")
    private Usuario userActualizacion;

    @OneToMany(mappedBy = "resolucion", fetch = FetchType.LAZY)
    private List<Reincorporacion> reincorporaciones;

    @OneToMany(mappedBy = "resolucion", fetch = FetchType.LAZY)
    private List<Readmision> readmisiones;

    @OneToMany(mappedBy = "resolucion", fetch = FetchType.LAZY)
    private List<CambioPlanCurricular> cambioPlanCurriculares;

    @Transient
    private CicloAcademico cicloReincorporacion;

    @Transient
    private List<RetiroCiclo> retiroCiclo;

    @Transient
    private List<CambioNota> cambioNota;

    @Transient
    private List<CursoDirigido> cursoDirigido;

    @Transient
    private List<TramiteTraslado> tramiteTraslado;

    @Transient
    private List<CambioNotaMasBaja> cambioNotaMasBajas;

    @Transient
    List<TramiteReunionConsejo> tramitesReunionConsejo;

    @Transient
    List<TramiteBachiller> tramiteBachiller;

    @Transient
    List<PracticasPreProfesional> tramitePracticasPreProfesionales;

    @Transient
    List<TramiteTitulo> tramiteTitulos;

    @Transient
    private String archivoTmp;

    @Transient
    private Boolean autorizado;

    public Resolucion(Object id) {
        this.id = TypesUtil.getLong(id);
        this.cargoRendirCuenta = false;
    }

    public Resolucion() {
        this.cargoRendirCuenta = false;
    }

    @JsonIgnore
    public void setEstadoEnum(ResolucionEstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public ResolucionEstadoEnum getEstadoEnum() {
        return ResolucionEstadoEnum.valueOf(this.estado);
    }

    public Integer getCantidadTramites() {
        if (this.getTipoResolucion().isReincorporacion()) {
            return this.getReincorporaciones().size();
        }
        return BigDecimal.ZERO.intValue();
    }

    public Long getAplicacionDirecta() {
        if (aplicacionDirecta == null) {
            return 0l;
        }
        return aplicacionDirecta;
    }

    public boolean getEsEstadoCre() {
        if (ResolucionEstadoEnum.CRE.name().equals(this.getEstado())) {
            return true;
        }
        return false;
    }

    public boolean getEsEstadoAct() {
        if (ResolucionEstadoEnum.ACT.name().equals(this.getEstado())) {
            return true;
        }
        return false;
    }

    public boolean getIsEstadoDocConf() {
        if (ResolucionEstadoEnum.DOC_CONF.name().equals(this.getEstado())) {
            return true;
        }
        return false;
    }

    public Boolean getAutorizado() {
        if (autorizado == null) {
            return false;
        }
        return autorizado;
    }

    public boolean isTipoReincorporacion() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isReincorporacion();
    }

    public boolean isTipoCursoDirigido() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isCursoDirigido();
    }

    public boolean isTipoRetiroCiclo() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isRetiroCiclo();
    }

    public boolean isTipoAnulacionCiclo() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isAnulacionCiclo();
    }

    public boolean isTipoCambioNota() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isCambioNota();
    }

    public boolean isTipoNotaBaja() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isNotaBaja();
    }

    public boolean isTipoIngresoFisicoHistorial() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isIngresoFisicoHistorial();
    }

    public boolean isTipoIntercambioEstudiantil() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isIntercambioEstudiantil();
    }

    public boolean isTipoTrasladoExterno() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isTrasladoExterno();
    }

    public boolean isTipoTrasladoInterno() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isTrasladoInterno();
    }

    public boolean isTipoTramiteBachiller() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isTramiteBachiller();
    }

    public boolean isTipoReadmision() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isReadmision();
    }

    public boolean isTipoCambioPlanCurricular() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isCambioPlanCurricular();
    }

    public boolean isTipoTramiteTitulo() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isTramiteTitulo();
    }

    public boolean isTipoTramitePracticas() {
        if (this.tipoResolucion == null) {
            return false;
        }

        return this.tipoResolucion.isTramitePracticas();
    }

    public boolean isTipoTramiteBachillerFacultad() {
        if (this.tipoResolucion == null) {
            return false;
        }
        return this.tipoResolucion.isTramiteBachillerFacultad();
    }

    public String getDescripcion() {

        if (numero == null || serie == null || oficina == null) {
            return null;
        }

        if (oficina.getCodigo().equals("UNA")) {
            return String.format("RES. %s-%s/%s", numero, serie, "UNALM");
        } else {
            return String.format("RES. %s-%s/%s", numero, serie, oficina.getCodigoDocumento());
        }
    }

    public String getDescripcionFacultad() {

        if (numero == null || serie == null || oficina == null) {
            return null;
        }
            return String.format("RES. %s-%s/%s", numero, serie, oficina.getCodigoDocumento());
    }
    

    public String getCodigoTituloBachiller() {

        if (numero == null || serie == null) {
            return null;
        }
        String num = numero + "";
        if (numero.toString().length() == 1) {
            num = "00" + numero;
        } else if (numero.toString().length() == 2) {
            num = "0" + numero;
        }
        return String.format("%s-%s-CU_UNALM", num, serie);
    }

    public String getCodigoPracticas() {

        if (numero == null || serie == null) {
            return null;
        }
        String num = numero + "";
        if (numero.toString().length() == 1) {
            num = "00" + numero;
        } else if (numero.toString().length() == 2) {
            num = "0" + numero;
        }
        return String.format("%s-%s/%s", oficina.getCodigoDocumento(), num, serie);
    }

}
