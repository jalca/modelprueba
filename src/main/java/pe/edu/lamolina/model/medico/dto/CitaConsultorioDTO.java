package pe.edu.lamolina.model.medico.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CitaConsultorioDTO {

    private Long idUsuario;
    private String token;
    private String tipoSesion;
    private Long idCitaConsultorio;
    private Long idAlumno;

    public CitaConsultorioDTO(Long idUsuario, String token, String tipoSesion, Long idCitaConsultorio, Long idAlumno) {
        this.idUsuario = idUsuario;
        this.token = token;
        this.tipoSesion = tipoSesion;
        this.idCitaConsultorio = idCitaConsultorio;
        this.idAlumno = idAlumno;
    }

}
