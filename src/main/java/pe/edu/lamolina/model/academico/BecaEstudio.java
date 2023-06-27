package pe.edu.lamolina.model.academico;

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
import pe.edu.lamolina.model.general.Empresa;

@Entity
@Table(name = "aca_beca_estudio")
public class BecaEstudio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_institucion")
    private Empresa institucion;
    
    public BecaEstudio(String nombre, Empresa institucionOtorga) {
        this.nombre = nombre;
        this.institucion = institucionOtorga;
    }

    public BecaEstudio() {
    }

    public BecaEstudio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Empresa institucion) {
        this.institucion = institucion;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.academico.BecaEstudio[ id=" + id + " ]";
    }

}
