package pe.edu.lamolina.model.permisoprogramacion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aca_permiso_programacion")
public class PermisoProgramacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nivel")
    private String nivel;

    @Column(name = "texto_agregar")
    private String textoAgregar;

    @Column(name = "texto_modificar")
    private String textoModificar;

    @Column(name = "texto_eliminar")
    private String textoEliminar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTextoAgregar() {
        return textoAgregar;
    }

    public void setTextoAgregar(String textoAgregar) {
        this.textoAgregar = textoAgregar;
    }

    public String getTextoModificar() {
        return textoModificar;
    }

    public void setTextoModificar(String textoModificar) {
        this.textoModificar = textoModificar;
    }

    public String getTextoEliminar() {
        return textoEliminar;
    }

    public void setTextoEliminar(String textoEliminar) {
        this.textoEliminar = textoEliminar;
    }

}
