package pe.edu.lamolina.model.academico;

import java.io.Serializable;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.CodigoAnexoBoletinEnum;
import static pe.edu.lamolina.model.enums.CodigoAnexoBoletinEnum.G02;
import static pe.edu.lamolina.model.enums.CodigoAnexoBoletinEnum.G03;
import static pe.edu.lamolina.model.enums.CodigoAnexoBoletinEnum.G04;
import pe.edu.lamolina.model.enums.EstadoEnum;

@Entity
@Getter
@Setter
@Table(name = "aca_anexo_boletin")
public class AnexoBoletin implements Serializable {

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

    @Column(name = "motivo_anulacion")
    private String motivoAnulacion;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "visible")
    private Boolean visible;

    @Column(name = "fecha_anulacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento_academico")
    private DepartamentoAcademico departamentoAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anexo_superior")
    private AnexoBoletin anexoSuperior;

    @OneToMany(mappedBy = "anexoBoletin", fetch = FetchType.LAZY)
    private List<GrupoSeccion> gruposSecciones;

    @Transient
    private Long cantidadGpoSecc;
    @Transient
    private List<AnexoBoletin> anexosBoletinHijos;
    @Transient
    private List<Curso> cursos;

    public AnexoBoletin() {
        this.visible = true;
    }

    public AnexoBoletin(CodigoAnexoBoletinEnum anexoEnum) {
        this.id = anexoEnum.getId();
        this.nombre = anexoEnum.getValue();
        this.codigo = anexoEnum.name();
    }

    public AnexoBoletin(Long id, Long cantidadGpoSecc) {
        this.id = id;
        this.cantidadGpoSecc = cantidadGpoSecc;
    }

    public AnexoBoletin(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    public void setCantidadGpoSeccInt(Integer cantidadGpoSecc) {
        if (cantidadGpoSecc == null) {
            this.cantidadGpoSecc = null;
        }
        this.cantidadGpoSecc = cantidadGpoSecc.longValue();
    }

    public static class CompareOrden implements Comparator<AnexoBoletin> {

        @Override
        public int compare(AnexoBoletin ab1, AnexoBoletin ab2) {
            AnexoBoletin sup1 = ab1.anexoSuperior;
            AnexoBoletin sup2 = ab2.anexoSuperior;
            if (sup1 != null && sup2 == null) {
                return 1;
            }
            if (sup1 == null && sup2 != null) {
                return -1;
            }
            if (sup1 == null && sup2 == null) {
                if (ab1.getEstadoEnum() == EstadoEnum.CRE && ab2.getEstadoEnum() != EstadoEnum.CRE) {
                    return -1;
                }
                if (ab1.getEstadoEnum() == EstadoEnum.ACT && ab2.getEstadoEnum() != EstadoEnum.ACT) {
                    return -1;
                }
                if (ab1.getEstadoEnum() == EstadoEnum.INA && ab2.getEstadoEnum() != EstadoEnum.INA) {
                    return 1;
                }
                return ab1.getOrden().compareTo(ab2.getOrden());
            }

            if (sup1.getOrden().compareTo(sup2.getOrden()) != 0) {
                return sup1.getOrden().compareTo(sup2.getOrden());
            }

            if (ab1.getEstadoEnum() == EstadoEnum.CRE && ab2.getEstadoEnum() != EstadoEnum.CRE) {
                return -1;
            }
            if (ab1.getEstadoEnum() == EstadoEnum.ACT && ab2.getEstadoEnum() != EstadoEnum.ACT) {
                return -1;
            }
            if (ab1.getEstadoEnum() == EstadoEnum.INA && ab2.getEstadoEnum() != EstadoEnum.INA) {
                return 1;
            }
            return ab1.getOrden().compareTo(ab2.getOrden());

        }
    }

    public boolean isAnexoCursosPostgrado() {
        if (this.codigo == null) {
            return false;
        }
        return G04.name().equals(this.codigo);
    }

    public boolean isAnexoCulturalesDeportes() {
        if (this.codigo == null) {
            return false;
        }
        return G03.name().equals(this.codigo);
    }

    public boolean isAnexoDepartamentos() {
        if (this.codigo == null) {
            return false;
        }
        return G02.name().equals(this.codigo);
    }

}
