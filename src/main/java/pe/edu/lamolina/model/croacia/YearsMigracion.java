package pe.edu.lamolina.model.croacia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "years_migracion", catalog = "croacia")
public class YearsMigracion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    private String year;

    @NotNull
    @Column(name = "ind_histo_migrado")
    private Boolean indHistoMigrado;

    @NotNull
    @Column(name = "ind_alumnos_migrados")
    private Boolean indAlumnosMigrados;

    @NotNull
    @Column(name = "ind_promciclos_migrados")
    private Boolean indPromCiclosMigrados;

    @NotNull
    @Column(name = "ind_migrado")
    private Boolean indMigrado;

    @NotNull
    @Column(name = "ind_procesado")
    private Boolean indProcesado;

    public YearsMigracion() {
    }

    public YearsMigracion(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getIndHistoMigrado() {
        return indHistoMigrado;
    }

    public void setIndHistoMigrado(Boolean indHistoMigrado) {
        this.indHistoMigrado = indHistoMigrado;
    }

    public Boolean getIndProcesado() {
        return indProcesado;
    }

    public void setIndProcesado(Boolean indProcesado) {
        this.indProcesado = indProcesado;
    }

    public Boolean getIndAlumnosMigrados() {
        return indAlumnosMigrados;
    }

    public void setIndAlumnosMigrados(Boolean indAlumnosMigrados) {
        this.indAlumnosMigrados = indAlumnosMigrados;
    }

    public Boolean getIndPromCiclosMigrados() {
        return indPromCiclosMigrados;
    }

    public void setIndPromCiclosMigrados(Boolean indPromCiclosMigrados) {
        this.indPromCiclosMigrados = indPromCiclosMigrados;
    }

    public Boolean getIndMigrado() {
        return indMigrado;
    }

    public void setIndMigrado(Boolean indMigrado) {
        this.indMigrado = indMigrado;
    }

}
