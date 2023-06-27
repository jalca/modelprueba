package pe.edu.lamolina.model.extensionobu;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "extn_precio_taller")
public class PrecioTaller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "precio_un")
    private BigDecimal precioUn;

    @Column(name = "precio_dos")
    private BigDecimal precioDos;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller_ciclo")
    private TallerCiclo tallerCiclo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fecha_taller_ciclo")
    private FechaTallerCiclo fechaTallerCiclo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecioUn() {
        return precioUn;
    }

    public void setPrecioUn(BigDecimal precioUn) {
        this.precioUn = precioUn;
    }

    public BigDecimal getPrecioDos() {
        return precioDos;
    }

    public void setPrecioDos(BigDecimal precioDos) {
        this.precioDos = precioDos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public TallerCiclo getTallerCiclo() {
        return tallerCiclo;
    }

    public void setTallerCiclo(TallerCiclo tallerCiclo) {
        this.tallerCiclo = tallerCiclo;
    }

    public FechaTallerCiclo getFechaTallerCiclo() {
        return fechaTallerCiclo;
    }

    public void setFechaTallerCiclo(FechaTallerCiclo fechaTallerCiclo) {
        this.fechaTallerCiclo = fechaTallerCiclo;
    }

}
