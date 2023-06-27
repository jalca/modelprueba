package pe.edu.lamolina.model.inscripcion;

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
import pe.edu.lamolina.model.enums.DescuentoEnum;

@Entity
@Table(name = "sip_descuento_examen")
public class DescuentoExamen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "gestion_colegio")
    private String gestionColegio;

    @Column(name = "tipo_colaborador")
    private String tipoColaborador;

    @Column(name = "porcentaje")
    private Integer porcentaje;

    @Column(name = "maximo_descuentos")
    private Integer maximoDescuentos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modalidad_ingreso")
    private ModalidadIngreso modalidadIngreso;

    public DescuentoExamen() {
    }

    public DescuentoExamen(Object id) {
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

    public void setCodigoEnum(DescuentoEnum codigo) {
        this.codigo = codigo.name();
    }

    public DescuentoEnum getCodigoEnum() {
        if (codigo == null) {
            return null;
        }
        return DescuentoEnum.valueOf(codigo);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGestionColegio() {
        return gestionColegio;
    }

    public void setGestionColegio(String gestionColegio) {
        this.gestionColegio = gestionColegio;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public ModalidadIngreso getModalidadIngreso() {
        return modalidadIngreso;
    }

    public void setModalidadIngreso(ModalidadIngreso modalidadIngreso) {
        this.modalidadIngreso = modalidadIngreso;
    }

    public String getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(String tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public Integer getMaximoDescuentos() {
        return maximoDescuentos;
    }

    public void setMaximoDescuentos(Integer maximoDescuentos) {
        this.maximoDescuentos = maximoDescuentos;
    }

}
