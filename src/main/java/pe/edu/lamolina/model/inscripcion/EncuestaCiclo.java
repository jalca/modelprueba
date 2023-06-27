package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
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
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.examen.ExamenVirtual;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "sip_encuesta_ciclo")
public class EncuestaCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "es_obligatorio")
    private Integer esObligatorio;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_postula")
    private CicloPostula cicloPostula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen_virtual")
    private ExamenVirtual examenVirtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_creacion")
    private Usuario userCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public EncuestaCiclo() {
    }

    public EncuestaCiclo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEsObligatorio() {
        return esObligatorio;
    }

    public void setEsObligatorio(Integer esObligatorio) {
        this.esObligatorio = esObligatorio;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public CicloPostula getCicloPostula() {
        return cicloPostula;
    }

    public void setCicloPostula(CicloPostula cicloPostula) {
        this.cicloPostula = cicloPostula;
    }

    public ExamenVirtual getExamenVirtual() {
        return examenVirtual;
    }

    public void setExamenVirtual(ExamenVirtual examenVirtual) {
        this.examenVirtual = examenVirtual;
    }

    public Usuario getUserCreacion() {
        return userCreacion;
    }

    public void setUserCreacion(Usuario userCreacion) {
        this.userCreacion = userCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Usuario getUserModificacion() {
        return userModificacion;
    }

    public void setUserModificacion(Usuario userModificacion) {
        this.userModificacion = userModificacion;
    }

    public static class ComparePeriodo implements Comparator<EncuestaCiclo> {

        @Override
        public int compare(EncuestaCiclo cp1, EncuestaCiclo cp2) {
            CicloAcademico ciclo1 = cp1.getCicloPostula().getCicloAcademico();
            CicloAcademico ciclo2 = cp2.getCicloPostula().getCicloAcademico();

            int compareYear = ciclo1.getYear().compareTo(ciclo2.getYear());
            if (compareYear != 0) {
                return compareYear;
            }

            return ciclo1.getNumeroCiclo().compareTo(ciclo2.getNumeroCiclo());
        }
    }

}
