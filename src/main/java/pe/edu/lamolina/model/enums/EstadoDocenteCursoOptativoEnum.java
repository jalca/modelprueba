package pe.edu.lamolina.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoDocenteCursoOptativoEnum {

    ACT("Activo", "badge-success"),
    ANU("Anulado", "badge-danger");

    private String descripcion;
    private String badge;
}
