package pe.edu.lamolina.model.croacia.ept;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ept_alumnos_tarifa", catalog = "croacia")
public class AlumnosTarifaMy implements Serializable {

    @Id
    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "TARIFA")
    private String tarifa;

    @Column(name = "EPG_CODIGO")
    private String espCodigo;

    @Column(name = "FECHA_MODIFI")
    private Date fechaModifi;

    @Column(name = "USUARIO_MODIFI")
    private String usuarioModifi;

    public AlumnosTarifaMy() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getEspCodigo() {
        return espCodigo;
    }

    public void setEspCodigo(String espCodigo) {
        this.espCodigo = espCodigo;
    }

    public Date getFechaModifi() {
        return fechaModifi;
    }

    public void setFechaModifi(Date fechaModifi) {
        this.fechaModifi = fechaModifi;
    }

    public String getUsuarioModifi() {
        return usuarioModifi;
    }

    public void setUsuarioModifi(String usuarioModifi) {
        this.usuarioModifi = usuarioModifi;
    }

    @Override
    public String toString() {
        return "AlumnosTarifaMy{" + "matricula=" + matricula + ", tarifa=" + tarifa + ", espCodigo=" + espCodigo + '}';
    }

}
