package pe.edu.lamolina.model.bean;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.bienestar.TipoSubvencion;
import pe.edu.lamolina.model.tramite.AlumnoValidacionSubvencion;

@Getter
@Setter
public class CasoSocialBean {

    private TipoSubvencion tipoSubvencion;
    private Alumno alumno;
    private String motivo;
    private List<AlumnoValidacionSubvencion> alumnoValidacions;

}
