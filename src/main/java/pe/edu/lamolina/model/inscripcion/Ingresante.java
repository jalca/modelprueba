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
import pe.edu.lamolina.model.academico.Carrera;

@Entity
@Table(name = "sip_ingresante")
public class Ingresante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "orden_merito")
    private Integer ordenMerito;

    @Column(name = "ruta_resolucion")
    private String rutaResolucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluado")
    private Evaluado evaluado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prelamolina")
    private Prelamolina prelamolina;

    public Ingresante() {
    }

    public Ingresante(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Evaluado getEvaluado() {
        return evaluado;
    }

    public void setEvaluado(Evaluado evaluado) {
        this.evaluado = evaluado;
    }

    public Prelamolina getPrelamolina() {
        return prelamolina;
    }

    public void setPrelamolina(Prelamolina prelamolina) {
        this.prelamolina = prelamolina;
    }

    public Integer getOrdenMerito() {
        return ordenMerito;
    }

    public void setOrdenMerito(Integer ordenMerito) {
        this.ordenMerito = ordenMerito;
    }

    public String getRutaResolucion() {
        return rutaResolucion;
    }

    public void setRutaResolucion(String rutaResolucion) {
        this.rutaResolucion = rutaResolucion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrdenMatricula() {
        String codeCarrera = this.getCarrera().getCodigo();
        String apellidosNombres = this.getPostulante().getPersona().getApellidosNombres();
        return codeCarrera + "-" + apellidosNombres;
    }

}
