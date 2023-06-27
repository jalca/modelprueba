package pe.edu.lamolina.model.croacia.oficina;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ofi_aulas", catalog = "croacia")
public class AulaOfiMy implements Serializable {

    @Id
    @Column(name = "AULA_COD")
    private String aulaCod;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "MODULO")
    private String modulo;

    @Column(name = "TAULA")
    private String taula;

    @Column(name = "AULA")
    private String aula;

    @Column(name = "RESP_CODIGO")
    private String respCodigo;

    @Column(name = "CAP_MAX")
    private Integer capMax;

    @Column(name = "DEP_CODIGO")
    private String depCodigo;

    @Column(name = "ACTIVO")
    private String activo;

    @Column(name = "PARA_ASIGNAR")
    private String paraAsignar;

    @Column(name = "FLAG_GNRAR_HRRIO")
    private String flagGnrarHrrio;

    @Column(name = "PIZARRA")
    private String pizarra;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "AULA_ANTIGUA")
    private String aulaAntigua;

    @Column(name = "RESP_CODIGO_T")
    private String respCodigoT;

    @Column(name = "PLANTA")
    private String planta;

    @Column(name = "AIRE_ACON")
    private String aireAcon;

    public AulaOfiMy() {
    }

    public AulaOfiMy(String aulaCod) {
        this.aulaCod = aulaCod;
    }

    public String getAulaCod() {
        return aulaCod;
    }

    public void setAulaCod(String aulaCod) {
        this.aulaCod = aulaCod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getTaula() {
        return taula;
    }

    public void setTaula(String taula) {
        this.taula = taula;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getRespCodigo() {
        return respCodigo;
    }

    public void setRespCodigo(String respCodigo) {
        this.respCodigo = respCodigo;
    }

    public Integer getCapMax() {
        return capMax;
    }

    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }

    public String getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(String depCodigo) {
        this.depCodigo = depCodigo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getParaAsignar() {
        return paraAsignar;
    }

    public void setParaAsignar(String paraAsignar) {
        this.paraAsignar = paraAsignar;
    }

    public String getFlagGnrarHrrio() {
        return flagGnrarHrrio;
    }

    public void setFlagGnrarHrrio(String flagGnrarHrrio) {
        this.flagGnrarHrrio = flagGnrarHrrio;
    }

    public String getPizarra() {
        return pizarra;
    }

    public void setPizarra(String pizarra) {
        this.pizarra = pizarra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getAulaAntigua() {
        return aulaAntigua;
    }

    public void setAulaAntigua(String aulaAntigua) {
        this.aulaAntigua = aulaAntigua;
    }

    public String getRespCodigoT() {
        return respCodigoT;
    }

    public void setRespCodigoT(String respCodigoT) {
        this.respCodigoT = respCodigoT;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getAireAcon() {
        return aireAcon;
    }

    public void setAireAcon(String aireAcon) {
        this.aireAcon = aireAcon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aulaCod != null ? aulaCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AulaOfiMy)) {
            return false;
        }
        AulaOfiMy other = (AulaOfiMy) object;
        if ((this.aulaCod == null && other.aulaCod != null) || (this.aulaCod != null && !this.aulaCod.equals(other.aulaCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.lamolina.model.croacia.oficina.AulaOfiMy[ aulaCod=" + aulaCod + " ]";
    }

}
