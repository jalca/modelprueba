package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.math.BigDecimal;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.general.Colegio;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Ubicacion;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.inscripcion.ModalidadIngreso;
import pe.edu.lamolina.model.seguridad.Usuario;

public class AbcDatosAcademicoAdapter1234 implements Serializable {

    /*
    private Long idAlumno;
    private Long idPersona;
    private String colegioProcedencia;
    private Integer agnoEgreso;
    private BigDecimal pensionMensual;
    private String traslado;
    private String universidadExtranjera;
    private String carrera;
    private String gradoUniversidad;
    private String direccionUniversidad;
    private String tipoUniversidad;
    private String estudiaSimultaneo;
    private String institucion;
    private String sedeUniversidad;
    private String colegioExtranjero;
    private String tipoTramite;

    private Pais paisColegio;
    private Colegio colegio;
    private Ubicacion ubicacionColegio;
    private ModalidadIngreso modalidadIngreso;
    private Universidad universidadNacional;
    private Pais paisUniversidad;
    private Ubicacion ubicacionUniversidad;
    private Usuario usuarioRegistro;

    public AbcDatosAcademicoAdapter1234() {
    }

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

    public String getColegioProcedencia() {
        return colegioProcedencia;
    }

    public void setColegioProcedencia(String colegioProcedencia) {
        this.colegioProcedencia = colegioProcedencia;
    }

    public Integer getAgnoEgreso() {
        return agnoEgreso;
    }

    public void setAgnoEgreso(Integer agnoEgreso) {
        this.agnoEgreso = agnoEgreso;
    }

    public BigDecimal getPensionMensual() {
        return pensionMensual;
    }

    public void setPensionMensual(BigDecimal pensionMensual) {
        this.pensionMensual = pensionMensual;
    }

    public Pais getPaisColegio() {
        return paisColegio;
    }

    public void setPaisColegio(Pais paisColegio) {
        this.paisColegio = paisColegio;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public Ubicacion getUbicacionColegio() {
        return ubicacionColegio;
    }

    public void setUbicacionColegio(Ubicacion ubicacionColegio) {
        this.ubicacionColegio = ubicacionColegio;
    }

    public ModalidadIngreso getModalidadIngreso() {
        return modalidadIngreso;
    }

    public void setModalidadIngreso(ModalidadIngreso modalidadIngreso) {
        this.modalidadIngreso = modalidadIngreso;
    }

    public String getTraslado() {
        return traslado;
    }

    public void setTraslado(String traslado) {
        this.traslado = traslado;
    }

    public Universidad getUniversidadNacional() {
        return universidadNacional;
    }

    public void setUniversidadNacional(Universidad universidadNacional) {
        this.universidadNacional = universidadNacional;
    }

    public String getUniversidadExtranjera() {
        return universidadExtranjera;
    }

    public void setUniversidadExtranjera(String universidadExtranjera) {
        this.universidadExtranjera = universidadExtranjera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGradoUniversidad() {
        return gradoUniversidad;
    }

    public void setGradoUniversidad(String gradoUniversidad) {
        this.gradoUniversidad = gradoUniversidad;
    }

    public Pais getPaisUniversidad() {
        return paisUniversidad;
    }

    public void setPaisUniversidad(Pais paisUniversidad) {
        this.paisUniversidad = paisUniversidad;
    }

    public Ubicacion getUbicacionUniversidad() {
        return ubicacionUniversidad;
    }

    public void setUbicacionUniversidad(Ubicacion ubicacionUniversidad) {
        this.ubicacionUniversidad = ubicacionUniversidad;
    }

    public String getDireccionUniversidad() {
        return direccionUniversidad;
    }

    public void setDireccionUniversidad(String direccionUniversidad) {
        this.direccionUniversidad = direccionUniversidad;
    }

    public String getTipoUniversidad() {
        return tipoUniversidad;
    }

    public void setTipoUniversidad(String tipoUniversidad) {
        this.tipoUniversidad = tipoUniversidad;
    }

    public String getEstudiaSimultaneo() {
        return estudiaSimultaneo;
    }

    public void setEstudiaSimultaneo(String estudiaSimultaneo) {
        this.estudiaSimultaneo = estudiaSimultaneo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getColegioExtranjero() {
        return colegioExtranjero;
    }

    public void setColegioExtranjero(String colegioExtranjero) {
        this.colegioExtranjero = colegioExtranjero;
    }

    public String getSedeUniversidad() {
        return sedeUniversidad;
    }

    public void setSedeUniversidad(String sedeUniversidad) {
        this.sedeUniversidad = sedeUniversidad;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance, true, new String[]{
            "*",
            "paisColegio.*",
            "colegio.*",
            "colegio.gestion.*",
            "colegio.gestionDependencia.*",
            "ubicacionColegio.*",
            "modalidadIngreso.*",
            "universidadNacional.*",
            "paisUniversidad.*",
            "ubicacionUniversidad.*",
            "usuarioRegistro.*"
        });
    }
    //*****/
}
