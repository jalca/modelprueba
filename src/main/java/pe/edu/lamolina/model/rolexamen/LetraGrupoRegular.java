package pe.edu.lamolina.model.rolexamen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "rex_letra_grupo_regular")
public class LetraGrupoRegular implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "letra")
    private String letra;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_examenes")
    private RolExamenes rolExamenes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo_horas_examen")
    private GrupoHorasExamen grupoHorasExamen;

    @OneToMany(mappedBy = "letraGrupoRegular", fetch = FetchType.LAZY)
    private List<SeccionGrupoRegular> seccionesGruposRegulares;

    @OneToMany(mappedBy = "letraGrupoRegular", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GrupoRegularExamen> gruposRegularesExamenes;

    @Transient
    @JsonIgnore
    private Integer gruposRegularesActivosCount;

    @Transient
    @JsonIgnore
    private Integer contadorSecciones;

    @Transient
    @JsonIgnore
    private Integer seccionesRegularesActivosCount;

    @Transient
    @JsonIgnore
    private Integer alumnosRegularesActivosCount;

    public LetraGrupoRegular() {
    }

    public LetraGrupoRegular(String letra,
            RolExamenes rolExamenes,
            Date today,
            Usuario usuario) {
        this.letra = letra;
        this.rolExamenes = rolExamenes;
        this.fechaRegistro = today;
        this.userRegistro = usuario;
        this.gruposRegularesExamenes = new ArrayList<>();
        //   this.alumnosGruposRegulares = new ArrayList<>();
        this.seccionesGruposRegulares = new ArrayList<>();
    }

    public LetraGrupoRegular(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    /*
    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }
     */
    public RolExamenes getRolExamenes() {
        return rolExamenes;
    }

    public void setRolExamenes(RolExamenes rolExamenes) {
        this.rolExamenes = rolExamenes;
    }

    /*
    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
     */
    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /*
    public List<AlumnoGrupoRegular> getAlumnosGruposRegulares() {
        return alumnosGruposRegulares;
    }

    public void setAlumnosGruposRegulares(List<AlumnoGrupoRegular> alumnosGruposRegulares) {
        this.alumnosGruposRegulares = alumnosGruposRegulares;
    }
     */
    public List<SeccionGrupoRegular> getSeccionesGruposRegulares() {
        return seccionesGruposRegulares;
    }

    public void setSeccionesGruposRegulares(List<SeccionGrupoRegular> seccionesGruposRegulares) {
        this.seccionesGruposRegulares = seccionesGruposRegulares;
    }

    public List<GrupoRegularExamen> getGruposRegularesExamenes() {
        return gruposRegularesExamenes;
    }

    public void setGruposRegularesExamenes(List<GrupoRegularExamen> gruposRegularesExamenes) {
        this.gruposRegularesExamenes = gruposRegularesExamenes;
    }

    public Integer getAlumnosRegularesActivosCount() {
        return alumnosRegularesActivosCount;
    }

    public void setAlumnosRegularesActivosCount(Integer alumnosRegularesActivosCount) {
        this.alumnosRegularesActivosCount = alumnosRegularesActivosCount;
    }

    public Integer getSeccionesRegularesActivosCount() {
        return seccionesRegularesActivosCount;
    }

    public void setSeccionesRegularesActivosCount(Integer seccionesRegularesActivosCount) {
        this.seccionesRegularesActivosCount = seccionesRegularesActivosCount;
    }

    public Integer getGruposRegularesActivosCount() {
        return gruposRegularesActivosCount;
    }

    public void setGruposRegularesActivosCount(Integer gruposRegularesActivosCount) {
        this.gruposRegularesActivosCount = gruposRegularesActivosCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof LetraGrupoRegular)) {
            return false;
        }
        LetraGrupoRegular other = (LetraGrupoRegular) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Integer getContadorSecciones() {
        return contadorSecciones;
    }

    public void setContadorSecciones(Integer contadorSecciones) {
        this.contadorSecciones = contadorSecciones;
    }

    public GrupoHorasExamen getGrupoHorasExamen() {
        return grupoHorasExamen;
    }

    public void setGrupoHorasExamen(GrupoHorasExamen grupoHorasExamen) {
        this.grupoHorasExamen = grupoHorasExamen;
    }

    @Override
    public String toString() {
        return "LetraGrupoRegular{" + "id=" + id + ", letra=" + letra + '}';
    }

    @Override
    public LetraGrupoRegular clone() {
        LetraGrupoRegular clone = null;
        try {
            clone = (LetraGrupoRegular) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
