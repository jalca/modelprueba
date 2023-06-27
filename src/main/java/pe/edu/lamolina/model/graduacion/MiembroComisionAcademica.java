package pe.edu.lamolina.model.graduacion;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.general.Colaborador;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Table(name = "epg_miembro_comision_academica")
public class MiembroComisionAcademica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comision_academica")
    private ComisionAcademica comisionAcademica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_miembro_comision")
    private TipoMiembroComision tipoMiembroComision;

    @Column(name = "es_presidente")
    private Boolean esPresidente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;
    /**
     * 
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;
    /**
     * 
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    public MiembroComisionAcademica() {
    }

    public MiembroComisionAcademica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ComisionAcademica getComisionAcademica() {
        return comisionAcademica;
    }

    public void setComisionAcademica(ComisionAcademica comisionAcademica) {
        this.comisionAcademica = comisionAcademica;
    }

    public TipoMiembroComision getTipoMiembroComision() {
        return tipoMiembroComision;
    }

    public void setTipoMiembroComision(TipoMiembroComision tipoMiembroComision) {
        this.tipoMiembroComision = tipoMiembroComision;
    }

    public Boolean getEsPresidente() {
        return esPresidente;
    }

    public void setEsPresidente(Boolean esPresidente) {
        this.esPresidente = esPresidente;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public static class CompareOrdenTipoMiembro implements Comparator<MiembroComisionAcademica> {

        @Override
        public int compare(MiembroComisionAcademica mcc1, MiembroComisionAcademica mcc2) {
            TipoMiembroComision tcc1 = mcc1.tipoMiembroComision;
            TipoMiembroComision tcc2 = mcc2.tipoMiembroComision;
            return tcc1.getOrden().compareTo(tcc2.getOrden());
        }
    }

}
