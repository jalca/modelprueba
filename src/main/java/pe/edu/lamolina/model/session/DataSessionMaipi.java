package pe.edu.lamolina.model.session;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.academico.MensajeIntranet;
import pe.edu.lamolina.model.enums.RutaInicioEnum;
import pe.edu.lamolina.model.general.Compania;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.medico.HistoriaClinica;
import pe.edu.lamolina.model.medico.Paciente;
import pe.edu.lamolina.model.seguridad.Menu;
import pe.edu.lamolina.model.seguridad.Rol;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.socioeconomico.FichaSocioeconomica;
import pe.edu.lamolina.model.tramite.Tramite;

@Getter
@Setter
public class DataSessionMaipi implements Serializable {

    private String email;
    private Persona persona;

    private Postulante postulante;
    private Compania compania;
    private Paciente paciente;
    private HistoriaClinica historiaClinica;

    private Alumno alumno;
    private List<Alumno> alumnos;

    private Carrera carrera;
    private Facultad facultad;
    private Usuario usuario;
    private CicloAcademico ciclo;

    private Rol rolActivo;
    private List<Rol> roles;
    private List<Rol> rolesMain;
    private List<Menu> menus;
    private Long timeLoadMenu;
    //private List<Menu> menusTotal;

    private List<MensajeIntranet> mensajes;

    private Tramite tramite;
    private FichaSocioeconomica fichaSocioeconomica;

    private String browser;
    private String direccionIp;
    private String sistemaOperativo;
    private String rutaMatricula;
    private String rutaIntranet;
    private String rutaAmauta;
    private String origen;
    private String rutaFicha;
    private String rutaFichaRegular;
    private String rutaInicioIntranet;
    private String rutaEncuentaSunedu;

    private String tipoLogin;
    private Boolean puedeMatricular;
    private Boolean tieneExamen;
    // private Boolean tieneComiteConsejero;
    private Integer encuestasPendientes;
    private Boolean isRealAlumno;
    // private Boolean puedeProyectoTesis;
    // private Boolean puedeSustentacionTesis;
    private Boolean encuestaSunedu;
    // private Boolean tieneInformesSubvencion;

    public DataSessionMaipi() {
        puedeMatricular = false;
        isRealAlumno = false;
        // puedeProyectoTesis = false;
        // puedeSustentacionTesis = false;
        // tieneInformesSubvencion = false;
    }

    public Map<Long, Rol> getMapRoles() {
        return roles.stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x));
    }

    public Map<Long, Alumno> getMapAlumnos() {
        return alumnos.stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x));
    }

    public ArrayNode getMensajesJson() {
        ArrayNode array = new ArrayNode(JsonNodeFactory.instance);
        if (this.mensajes == null) {
            return array;
        }
        for (MensajeIntranet mensaje : mensajes) {
            ObjectNode msgJson = JsonHelper.createJson(mensaje, JsonNodeFactory.instance, true,
                    new String[]{
                        "*", "cicloAcademico.*", "grupoAlumno.*", "tipoMensajeIntranet.*"
                    });
            array.add(msgJson);
        }
        return array;
    }

    public RutaInicioEnum getRutaInicioIntranetEnum() {
        if (this.rutaInicioIntranet == null) {
            return null;
        }
        return RutaInicioEnum.valueOf(rutaInicioIntranet);
    }

}
