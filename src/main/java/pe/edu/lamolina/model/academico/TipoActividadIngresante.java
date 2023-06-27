package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.TipoActividadIngresanteEnum;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "aca_tipo_actividad_ingresante")
public class TipoActividadIngresante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "nombre_admision")
    private String nombreAdmision;

    @Column(name = "codigo_visible")
    private String codigoVisible;

    @Column(name = "codigo_responsable")
    private String codigoOficina;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "orden_creacion")
    private Integer ordenCreacion;
    
    @Column(name = "para_posgrado")
    private Integer paraPosgrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_recorrido")
    private OficinaRecorrido oficinaRecorrido;

    public TipoActividadIngresante(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoActividadIngresanteEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return TipoActividadIngresanteEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoEnum(TipoActividadIngresanteEnum codigo) {
        if (codigo == null) {
            return;
        }
        this.codigo = codigo.name();
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public boolean isTipoRPAGOADM() {
        return this.isTrue(TipoActividadIngresanteEnum.RPAGOADM);
    }

    public boolean isTipoPAGOEXAMED() {
        return this.isTrue(TipoActividadIngresanteEnum.PAGOEXAMED);
    }

    public boolean isTipoCAREO() {
        return this.isTrue(TipoActividadIngresanteEnum.CAREO);
    }

    public boolean isTipoDOCS() {
        return this.isTrue(TipoActividadIngresanteEnum.DOCS);
    }

    public boolean isTipoENTREV() {
        return this.isTrue(TipoActividadIngresanteEnum.ENTREV);
    }

    public boolean isTipoFISOEC() {
        return this.isTrue(TipoActividadIngresanteEnum.FISOEC);
    }

    public boolean isTipoTESTPSIC() {
        return this.isTrue(TipoActividadIngresanteEnum.TESTPSIC);
    }

    public boolean isTipoPAGOMATRI() {
        return this.isTrue(TipoActividadIngresanteEnum.PAGOMATRI);
    }

    public boolean isTipoEXAMED() {
        return this.isTrue(TipoActividadIngresanteEnum.EXAMED);
    }

    public boolean isTipoRECEP() {
        return this.isTrue(TipoActividadIngresanteEnum.RECEP);
    }

    public boolean isTipoMATRI() {
        return this.isTrue(TipoActividadIngresanteEnum.MATRI);
    }

    private boolean isTrue(TipoActividadIngresanteEnum tipoEnum) {
        if (this.codigo == null) {
            return false;
        }
        return tipoEnum.name().equals(this.codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final TipoActividadIngresante other = (TipoActividadIngresante) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
