package pe.edu.lamolina.model.bean;

import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.tramite.PlantillaDocumentoAcademico;
import pe.edu.lamolina.model.tramite.TramiteDocumentoAcademico;

public class PlantillaIncrustacionGeneralBean {

    TramiteDocumentoAcademico tramiteDocumentoAcademico;
    PlantillaDocumentoAcademico plantillaDocumentoAcademico;
    CicloAcademico cicloEstudiado;
    Alumno alumno;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public PlantillaDocumentoAcademico getPlantillaDocumentoAcademico() {
        return plantillaDocumentoAcademico;
    }

    public void setPlantillaDocumentoAcademico(PlantillaDocumentoAcademico plantillaDocumentoAcademico) {
        this.plantillaDocumentoAcademico = plantillaDocumentoAcademico;
    }

    public CicloAcademico getCicloEstudiado() {
        return cicloEstudiado;
    }

    public void setCicloEstudiado(CicloAcademico cicloEstudiado) {
        this.cicloEstudiado = cicloEstudiado;
    }

    public TramiteDocumentoAcademico getTramiteDocumentoAcademico() {
        return tramiteDocumentoAcademico;
    }

    public void setTramiteDocumentoAcademico(TramiteDocumentoAcademico tramiteDocumentoAcademico) {
        this.tramiteDocumentoAcademico = tramiteDocumentoAcademico;
    }

}
