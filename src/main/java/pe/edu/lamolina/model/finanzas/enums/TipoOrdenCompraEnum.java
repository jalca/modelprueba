package pe.edu.lamolina.model.finanzas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoOrdenCompraEnum {

    OC("Orden de Compra"),
    OS("Orden de Servicio");

    private String descripcion;

}
