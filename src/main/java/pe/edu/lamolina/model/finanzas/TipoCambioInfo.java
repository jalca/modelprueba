package pe.edu.lamolina.model.finanzas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoCambioInfoEnum;

@Entity
@Table(name = "sip_tipo_cambio_info")
public class TipoCambioInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "antes_inscripcion")
    private Integer antesInscripcion;

    @Column(name = "antes_examen")
    private Integer antesExamen;

    public TipoCambioInfo() {
    }

    public TipoCambioInfo(Object id) {
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

    public TipoCambioInfoEnum getCodigoEnum() {
        return TipoCambioInfoEnum.valueOf(codigo);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAntesInscripcion() {
        return antesInscripcion;
    }

    public void setAntesInscripcion(Integer antesInscripcion) {
        this.antesInscripcion = antesInscripcion;
    }

    public Integer getAntesExamen() {
        return antesExamen;
    }

    public void setAntesExamen(Integer antesExamen) {
        this.antesExamen = antesExamen;
    }

}
