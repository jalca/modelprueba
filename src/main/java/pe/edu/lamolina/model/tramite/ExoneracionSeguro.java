package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.enums.ExoneracionSeguroEstadoEnum;
import pe.edu.lamolina.model.enums.TipoExoneracionSeguroEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Empresa;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "obu_exonerar_seguro_accidente")
public class ExoneracionSeguro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "observacion")
    private String observacion;
    
    @Column(name = "otra_aseguradora")
    private String otraAseguradora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresaAseguradora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario userModifica;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @Column(name = "fecha_modifica")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaModifica;

    @Transient
    List<Archivo> archivos;

    public ExoneracionSeguro() {
    }

    @JsonIgnore
    public void setEstadoEnum(ExoneracionSeguroEstadoEnum estadoEnum) {
        this.estado = estadoEnum.name();
    }

    public ExoneracionSeguroEstadoEnum getEstadoEnum() {
        return ExoneracionSeguroEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setTipoEnum(TipoExoneracionSeguroEnum tipoEnum) {
        this.tipo = tipoEnum.name();
    }

    public TipoExoneracionSeguroEnum getTipoEnum() {
        return TipoExoneracionSeguroEnum.valueOf(tipo);
    }

}
