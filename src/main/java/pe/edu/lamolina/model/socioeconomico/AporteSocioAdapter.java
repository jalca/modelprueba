package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.aporte.Aporte;
import pe.edu.lamolina.model.bienestar.CategoriaBienestar;

public class AporteSocioAdapter {

    private Long idAlumno;
    private CicloAcademico cicloAcademico;
    private CategoriaBienestar categoriaBienestar;
    private Aporte aporte;
    private BigDecimal monto;

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Aporte getAporte() {
        return aporte;
    }

    public void setAporte(Aporte aporte) {
        this.aporte = aporte;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public CategoriaBienestar getCategoriaBienestar() {
        return categoriaBienestar;
    }

    public void setCategoriaBienestar(CategoriaBienestar categoriaBienestar) {
        this.categoriaBienestar = categoriaBienestar;
    }

    public ObjectNode toJson() {
        ObjectNode json = JsonHelper.createJson(this, JsonNodeFactory.instance);
        Aporte apo = this.aporte == null ? new Aporte() : this.aporte;
        CicloAcademico ca = this.cicloAcademico == null ? new CicloAcademico() : this.cicloAcademico;
        CategoriaBienestar cb = this.categoriaBienestar == null ? new CategoriaBienestar() : this.categoriaBienestar;
        json.set("aporte", JsonHelper.createJson(apo, JsonNodeFactory.instance));
        json.set("cicloAcademico", JsonHelper.createJson(ca, JsonNodeFactory.instance));
        json.set("categoriaBienestar", JsonHelper.createJson(cb, JsonNodeFactory.instance));
        return json;
    }

}
