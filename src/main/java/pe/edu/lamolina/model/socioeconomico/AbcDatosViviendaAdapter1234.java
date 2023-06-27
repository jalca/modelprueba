package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.seguridad.Usuario;

public class AbcDatosViviendaAdapter1234 implements Serializable {

    /***
    private Long idAlumno;
    private Long idPersona;
    private String coordenadaLima;
    private String povLima;
    private String povOrigen;
    private String coordenadaProvincia;
    private String especificaTipoVivienda;
    private String especificaTenencia;
    private BigDecimal costoAlquiler;
    private String especificaMaterialVivienda;
    private String especificaCondicionVivienda;
    private Integer tieneAlumbrado;
    private String especificaServicioAgua;
    private String especificaDesague;
    private Integer ingresoTotal;
    private BigDecimal ingresoTotalFamiliar;
    private String bienes;

    private CicloAcademico cicloAcademico;
    private TipoVivienda tipoVivienda;
    private Tenencia tenencia;
    private MaterialVivienda materialVivienda;
    private CondicionVivienda condicionVivienda;
    private ServicioAgua servicioAgua;
    private Desague desague;
    private LugarResidencia lugarResidencia;
    private Usuario usuarioRegistro;

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getCoordenadaLima() {
        return coordenadaLima;
    }

    public void setCoordenadaLima(String coordenadaLima) {
        this.coordenadaLima = coordenadaLima;
    }

    public String getCoordenadaProvincia() {
        return coordenadaProvincia;
    }

    public void setCoordenadaProvincia(String coordenadaProvincia) {
        this.coordenadaProvincia = coordenadaProvincia;
    }

    public TipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(TipoVivienda tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public String getEspecificaTipoVivienda() {
        return especificaTipoVivienda;
    }

    public void setEspecificaTipoVivienda(String especificaTipoVivienda) {
        this.especificaTipoVivienda = especificaTipoVivienda;
    }

    public Tenencia getTenencia() {
        return tenencia;
    }

    public void setTenencia(Tenencia tenencia) {
        this.tenencia = tenencia;
    }

    public String getEspecificaTenencia() {
        return especificaTenencia;
    }

    public void setEspecificaTenencia(String especificaTenencia) {
        this.especificaTenencia = especificaTenencia;
    }

    public MaterialVivienda getMaterialVivienda() {
        return materialVivienda;
    }

    public void setMaterialVivienda(MaterialVivienda materialVivienda) {
        this.materialVivienda = materialVivienda;
    }

    public String getEspecificaMaterialVivienda() {
        return especificaMaterialVivienda;
    }

    public void setEspecificaMaterialVivienda(String especificaMaterialVivienda) {
        this.especificaMaterialVivienda = especificaMaterialVivienda;
    }

    public CondicionVivienda getCondicionVivienda() {
        return condicionVivienda;
    }

    public void setCondicionVivienda(CondicionVivienda condicionVivienda) {
        this.condicionVivienda = condicionVivienda;
    }

    public String getEspecificaCondicionVivienda() {
        return especificaCondicionVivienda;
    }

    public void setEspecificaCondicionVivienda(String especificaCondicionVivienda) {
        this.especificaCondicionVivienda = especificaCondicionVivienda;
    }

    public Integer getTieneAlumbrado() {
        return tieneAlumbrado;
    }

    public void setTieneAlumbrado(Integer tieneAlumbrado) {
        this.tieneAlumbrado = tieneAlumbrado;
    }

    public ServicioAgua getServicioAgua() {
        return servicioAgua;
    }

    public void setServicioAgua(ServicioAgua servicioAgua) {
        this.servicioAgua = servicioAgua;
    }

    public Desague getDesague() {
        return desague;
    }

    public void setDesague(Desague desague) {
        this.desague = desague;
    }

    public LugarResidencia getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(LugarResidencia lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getBienes() {
        return bienes;
    }

    public void setBienes(String bienes) {
        this.bienes = bienes;
    }

    public Integer getIngresoTotal() {
        return ingresoTotal;
    }

    public void setIngresoTotal(Integer ingresoTotal) {
        this.ingresoTotal = ingresoTotal;
    }

    public BigDecimal getIngresoTotalFamiliar() {
        return ingresoTotalFamiliar;
    }

    public void setIngresoTotalFamiliar(BigDecimal ingresoTotalFamiliar) {
        this.ingresoTotalFamiliar = ingresoTotalFamiliar;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public String getEspecificaServicioAgua() {
        return especificaServicioAgua;
    }

    public void setEspecificaServicioAgua(String especificaServicioAgua) {
        this.especificaServicioAgua = especificaServicioAgua;
    }

    public String getEspecificaDesague() {
        return especificaDesague;
    }

    public void setEspecificaDesague(String especificaDesague) {
        this.especificaDesague = especificaDesague;
    }

    public BigDecimal getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setCostoAlquiler(BigDecimal costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public String getPovLima() {
        return povLima;
    }

    public void setPovLima(String povLima) {
        this.povLima = povLima;
    }

    public String getPovOrigen() {
        return povOrigen;
    }

    public void setPovOrigen(String povOrigen) {
        this.povOrigen = povOrigen;
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance, true, new String[]{
            "*",
            "cicloAcademico.*",
            "tipoVivienda.*",
            "tenencia.*",
            "materialVivienda.*",
            "condicionVivienda.*",
            "servicioAgua.*",
            "desague.*",
            "lugarResidencia.*",
            "usuarioRegistro.*",});
    }
    // *****/

}
