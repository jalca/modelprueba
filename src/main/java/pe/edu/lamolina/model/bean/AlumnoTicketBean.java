package pe.edu.lamolina.model.bean;

import java.math.BigDecimal;
import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.comedor.ControlVentaTramo;
import pe.edu.lamolina.model.comedor.TicketComedor;
import pe.edu.lamolina.model.comedor.TipoServicioComedor;
import pe.edu.lamolina.model.seguridad.TokenIngresante;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoTicketBean {

    private TipoServicioComedor tipoServicioComedor;
    private TicketComedor ticketComedor;
    private ControlVentaTramo controlVentaTramo;
    private Alumno alumno;
    private CicloAcademico ciclo;
    private Usuario usuario;
    private TokenIngresante token;

    private BigDecimal saldo;
    private Integer postergado;
    private String motivo;
    private String horaPostergado;

    public void setPostergado(Boolean postergado) {
        if (postergado == null) {
            this.postergado = 0;
            return;
        }
        if (postergado) {
            this.postergado = 1;
        } else {
            this.postergado = 0;
        }
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "saldo", saldo, false);
        ModelUtils.getDataByAttr(join, "postergado", postergado, false);
        ModelUtils.getDataByAttr(join, "motivo", motivo, false);
        ModelUtils.getDataByAttr(join, "horaPostergado", horaPostergado, false);
        ModelUtils.getDataByAttrObject(join, "tipoServicioComedor", tipoServicioComedor, "id");
        ModelUtils.getDataByAttrObject(join, "ticketComedor", ticketComedor, "id");
        ModelUtils.getDataByAttrObject(join, "controlVentaTramo", controlVentaTramo, "id");
        ModelUtils.getDataByAttrObject(join, "alumno", alumno, "id");
        ModelUtils.getDataByAttrObject(join, "ciclo", ciclo, "id");
        ModelUtils.getDataByAttrObject(join, "usuario", usuario, "id");
        ModelUtils.getDataByAttrObject(join, "token", token, "id,valor");

        return join.toString();
    }

}
