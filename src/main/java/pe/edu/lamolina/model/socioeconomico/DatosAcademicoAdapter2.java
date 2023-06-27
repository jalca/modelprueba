package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.json.JaneHelper;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.inscripcion.Postulante;
import pe.edu.lamolina.model.tramite.Tramite;

@Getter
@Setter
public class DatosAcademicoAdapter2 implements Serializable {

    private Long idAlumno;
    private Long idPersona;
    private Alumno alumno;
    private Tramite tramite;
    private Postulante postulante;
    private Boolean isSimultaneo;

    public DatosAcademicoAdapter2() {
    }

    public Boolean getIsColegioPeruano() {
        if (postulante == null) {
            return false;
        }
        if (postulante.getColegioProcedencia() != null) {
            return true;
        }
        return false;
    }

    public Boolean getIsColegioExtranjero() {
        if (postulante == null) {
            return false;
        }
        if (!StringUtils.isBlank(postulante.getColegioExtranjero())) {
            return true;
        }
        return false;
    }

    public Boolean getIsUniversidadPeruana() {
        if (postulante == null) {
            return false;
        }
        if (postulante.getUniversidadProcedencia() != null) {
            return true;
        }
        return false;
    }

    public Boolean getIsUniversidadExtranjera() {
        if (postulante == null) {
            return false;
        }
        if (!StringUtils.isBlank(postulante.getUniversidadExtranjera())) {
            return true;
        }
        return false;
    }

    public ObjectNode toJson() {
        return JaneHelper
                .from(this)
                .join("alumno", "id,codigo")
                .join("alumno.cicloIngreso", "id,descripcion,descripcion2")
                .join("postulante", "id,yearEgresoColegio,pensionColegio,colegioExtranjero,universidadExtranjera,especialidadUniversidad,sedeUniversidad,gradoTitulo,gradoUniversidad,institucionEstudioSimultaneo")
                .join("postulante.paisUniversidad", "id,nombre,codigo,esPeru")
                .join("postulante.paisColegio", "id,nombre,codigo,esPeru")
                .join("postulante.colegioProcedencia", "id,nombre,tipoObuaeEnum,tipoObuae,direccion,codigoModular,anexo")
                .join("postulante.colegioProcedencia.gestion")
                .join("postulante.colegioProcedencia.gestionDependencia")
                .join("postulante.colegioProcedencia.ubicacion", "distrito")
                .join("postulante.modalidadIngreso", "id,trasladoExterno,nombre,nombreInscripcion,nombreCorto,graduadosTituladosUniversitarios")
                .join("postulante.universidadProcedencia", "id,nombre,tipoGestion")
                .join("postulante.universidadProcedencia.ubicacion", "distrito")
                .json();
    }
}
