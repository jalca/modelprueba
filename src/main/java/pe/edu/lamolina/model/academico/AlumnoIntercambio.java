package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.math.BigDecimal;
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
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Table(name = "aca_alumno_intercambio")
public class AlumnoIntercambio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto_beca")
    private BigDecimal monto;

    @Column(name = "facultad_destino")
    private String facultadDestino;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_universidad_destino")
    private Universidad universidadDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_intercambio")
    private CicloAcademico cicloIntercambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_destino")
    private Pais paisDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_beca_estudio")
    private BecaEstudio BecaEstudio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public AlumnoIntercambio() {
    }

    public AlumnoIntercambio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFacultadDestino() {
        return facultadDestino;
    }

    public void setFacultadDestino(String facultadDestino) {
        this.facultadDestino = facultadDestino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Universidad getUniversidadDestino() {
        return universidadDestino;
    }

    public void setUniversidadDestino(Universidad universidadDestino) {
        this.universidadDestino = universidadDestino;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public CicloAcademico getCicloIntercambio() {
        return cicloIntercambio;
    }

    public void setCicloIntercambio(CicloAcademico cicloBeca) {
        this.cicloIntercambio = cicloBeca;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Pais getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(Pais paisDestino) {
        this.paisDestino = paisDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BecaEstudio getBecaEstudio() {
        return BecaEstudio;
    }

    public void setBecaEstudio(BecaEstudio BecaEstudio) {
        this.BecaEstudio = BecaEstudio;
    }
    
}
