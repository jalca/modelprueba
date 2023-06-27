package pe.edu.lamolina.model.croacia.auxiliar;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aux_years_migracion_lite")
public class YearsMigracionLite implements Serializable {

    

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    private String year;

    @Column(name = "ind_migrados")
    private Integer indMigrados;

    @Column(name = "ind_procesado")
    private Integer indProcesado;

    public YearsMigracionLite() {
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

    public Integer getIndMigrados() {
        return indMigrados;
    }

    public void setIndMigrados(Integer indMigrados) {
        this.indMigrados = indMigrados;
    }

    public Integer getIndProcesado() {
        return indProcesado;
    }

    public void setIndProcesado(Integer indProcesado) {
        this.indProcesado = indProcesado;
    }

}
