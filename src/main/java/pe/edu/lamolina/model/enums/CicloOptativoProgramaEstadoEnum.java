package pe.edu.lamolina.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CicloOptativoProgramaEstadoEnum {

    ACT("Activo", "badge-success"), 
    CER("Cerrado", "badge-primary"),
    CRE("Creado", "badge-secondary"), 
    DES("Desactivado", "badge-warning"), 
    PEND("Pendiente", "badge-info"), 
    CFG("Configurando", "badge-info"), 
    ANU("Anulado", "badge-danger");

    
    private String descripcion;
    private String badge;
    
}
