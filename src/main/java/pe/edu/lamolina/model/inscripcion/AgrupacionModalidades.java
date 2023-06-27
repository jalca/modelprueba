package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
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
import javax.persistence.Transient;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "sip_agrupacion_modalidades")
public class AgrupacionModalidades implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_edad")
    private Integer tipoEdad;

    @Column(name = "postulantes")
    private Integer postulantes;

    @Column(name = "con_aulas")
    private Integer conAulas;

    @Column(name = "sin_aulas")
    private Integer sinAulas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @OneToMany(mappedBy = "agrupacionModalidades", fetch = FetchType.LAZY)
    private List<ModalidadGrupo> modalidadGrupo;

    @Transient
    List<ModalidadIngreso> modalidades;

    public AgrupacionModalidades() {
    }

    public AgrupacionModalidades(Object id) {
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

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public List<ModalidadGrupo> getModalidadGrupo() {
        return modalidadGrupo;
    }

    public void setModalidadGrupo(List<ModalidadGrupo> modalidadGrupo) {
        this.modalidadGrupo = modalidadGrupo;
    }

    public Integer getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Integer postulantes) {
        this.postulantes = postulantes;
    }

    public Integer getTipoEdad() {
        return tipoEdad;
    }

    public void setTipoEdad(Integer tipoEdad) {
        this.tipoEdad = tipoEdad;
    }

    public List<ModalidadIngreso> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<ModalidadIngreso> modalidades) {
        this.modalidades = modalidades;
    }

    public Integer getConAulas() {
        return conAulas;
    }

    public void setConAulas(Integer conAulas) {
        this.conAulas = conAulas;
    }

    public Integer getSinAulas() {
        return sinAulas;
    }

    public void setSinAulas(Integer sinAulas) {
        this.sinAulas = sinAulas;
    }

}
