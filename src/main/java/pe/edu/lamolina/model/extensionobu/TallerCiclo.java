package pe.edu.lamolina.model.extensionobu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Curso;
import pe.edu.lamolina.model.academico.Docente;
import pe.edu.lamolina.model.enums.EstadoAsistenciaEnum;
import pe.edu.lamolina.model.enums.TallerCicloEstadoEnum;
import pe.edu.lamolina.model.finanzas.CuentaBancaria;
import pe.edu.lamolina.model.general.Aula;
import pe.edu.lamolina.model.general.Dia;
import pe.edu.lamolina.model.horario.Hora;
import pe.edu.lamolina.model.horario.HorarioTaller;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "extn_taller_ciclo")
public class TallerCiclo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "costo")
    private BigDecimal costo;

    @Column(name = "vacantes")
    private Integer vacantes;

    @Column(name = "preinscritos")
    private Integer preInscritos;

    @Column(name = "inscritos")
    private Integer inscritos;

    @Column(name = "minimo_inscritos")
    private Integer minimoInscritos;

    @Column(name = "edad_inicio")
    private Integer edadInicio;

    @Column(name = "edad_Fin")
    private Integer edadFin;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modifica")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_bancaria")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modifica")
    private Usuario userModifica;

    @OneToMany(mappedBy = "tallerCiclo", fetch = FetchType.LAZY)
    private List<HorarioTaller> horarioTaller;

    @OneToMany(mappedBy = "tallerCiclo", fetch = FetchType.LAZY)
    private List<PrecioTaller> preciosTaller;

    @OneToMany(mappedBy = "tallerCiclo", fetch = FetchType.LAZY)
    private List<DocenteTaller> docenteTallers;

    @Transient
    private BigDecimal unMes;

    @Transient
    private BigDecimal dosMes;

    @Transient
    private Boolean configurado;

    @Transient
    private Integer asistenciaDiaria;

    @Transient
    private EstadoAsistenciaEnum estadoAsistenciaEnum;

    @Transient
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaInicio;

    @Transient
    @JsonDeserialize(using = DateDeserializer.class)
    private Date fechaFin;

    @Transient
    private List<Docente> docentes;

    public TallerCiclo(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Integer getPreInscritos() {
        if (preInscritos == null) {
            return 0;
        }
        return preInscritos;
    }

    public Integer getInscritos() {
        if (inscritos == null) {
            return 0;
        }
        return inscritos;
    }

    public TallerCicloEstadoEnum getEstadoEnum() {
        if (StringUtils.isBlank(estado)) {
            return null;
        }
        return TallerCicloEstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(TallerCicloEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        estado = estadoEnum.name();
    }

    public Integer getReservados() {
        return this.getPreInscritos() + this.getInscritos();
    }

    public String getHorarioTexto() {
        if (this.horarioTaller == null) {
            return "";
        }
        if (this.horarioTaller.isEmpty()) {
            return "";
        }

        String horario = "";
        Map<Long, List<Hora>> mapDiaHoras = TypesUtil.convertListToMapList("dia.id", "hora", this.horarioTaller);
        List<Dia> dias = this.horarioTaller.stream().map(x -> x.getDia()).distinct().collect(Collectors.toList());
        Collections.sort(dias, new Dia.CompareNumero());

        boolean inicio = true;
        String horaTextoAntes = "";
        String horaTexto = "";
        List<Dia> diasBloque = new ArrayList();

        for (Dia dia : dias) {
            List<Hora> horas = mapDiaHoras.get(dia.getId());
            Collections.sort(horas, new Hora.CompareCodigo());

            horaTexto = " de " + horas.get(0).getDescripcion2() + " a ";
            horaTexto += horas.get(horas.size() - 1).getDescripcion2Fin();

            if (inicio) {
                diasBloque.add(dia);
                inicio = false;
                horaTextoAntes = horaTexto;
                continue;

            } else if (horaTexto.equals(horaTextoAntes)) {
                diasBloque.add(dia);
                continue;

            }

            horario += horario.equals("") ? "" : " y ";
            horario += createDiasBloqueTexto(diasBloque);
            horario += horaTextoAntes;

            horaTextoAntes = horaTexto;
            diasBloque.clear();
            diasBloque.add(dia);

        }

        horario += horario.equals("") ? "" : " y ";
        horario += createDiasBloqueTexto(diasBloque);
        horario += horaTextoAntes;

        return horario;
    }

    public String getHorarioTextoAbr() {
        if (this.horarioTaller == null) {
            return "";
        }
        if (this.horarioTaller.isEmpty()) {
            return "";
        }

        String horario = "";
        Map<Long, List<Hora>> mapDiaHoras = TypesUtil.convertListToMapList("dia.id", "hora", this.horarioTaller);
        List<Dia> dias = this.horarioTaller.stream().map(x -> x.getDia()).distinct().collect(Collectors.toList());
        Collections.sort(dias, new Dia.CompareNumero());

        boolean inicio = true;
        String horaTextoAntes = "";
        String horaTexto = "";
        List<Dia> diasBloque = new ArrayList();

        for (Dia dia : dias) {
            List<Hora> horas = mapDiaHoras.get(dia.getId());
            Collections.sort(horas, new Hora.CompareCodigo());

            horaTexto = " de " + horas.get(0).getDescripcion2() + " a ";
            horaTexto += horas.get(horas.size() - 1).getDescripcion2Fin();

            if (inicio) {
                diasBloque.add(dia);
                inicio = false;
                horaTextoAntes = horaTexto;
                continue;

            } else if (horaTexto.equals(horaTextoAntes)) {
                diasBloque.add(dia);
                continue;

            }

            horario += horario.equals("") ? "" : " y ";
            horario += createDiasBloqueTextoAbr(diasBloque);
            horario += horaTextoAntes;

            horaTextoAntes = horaTexto;
            diasBloque.clear();
            diasBloque.add(dia);

        }

        horario += horario.equals("") ? "" : " y ";
        horario += createDiasBloqueTextoAbr(diasBloque);
        horario += horaTextoAntes;

        return horario;
    }

    private String createDiasBloqueTexto(List<Dia> dias) {
        String diasBloqueTexto = "";
        if (dias.isEmpty()) {
            return diasBloqueTexto;
        }
        if (dias.size() == 1) {
            return dias.get(0).getSimbolo();
        }

        boolean correlativo = true;
        int nroDiaAntes = dias.get(0).getNumeroDia() - 1;
        for (Dia dia : dias) {
            correlativo = correlativo && dia.getNumeroDia() == nroDiaAntes;
        }
        if (correlativo) {
            return dias.get(0).getSimbolo() + " a " + dias.get(dias.size() - 1).getSimbolo();
        }
        for (Dia dia : dias) {
            diasBloqueTexto += diasBloqueTexto.equals("") ? "" : ", ";
            diasBloqueTexto += dia.getSimbolo();
        }

        return diasBloqueTexto;
    }

    private String createDiasBloqueTextoAbr(List<Dia> dias) {
        String diasBloqueTexto = "";
        if (dias.isEmpty()) {
            return diasBloqueTexto;
        }
        if (dias.size() == 1) {
            return dias.get(0).getSimboloAbr();
        }

        boolean correlativo = true;
        int nroDiaAntes = dias.get(0).getNumeroDia() - 1;
        for (Dia dia : dias) {
            correlativo = correlativo && dia.getNumeroDia() == nroDiaAntes;
        }
        if (correlativo) {
            return dias.get(0).getSimboloAbr() + " a " + dias.get(dias.size() - 1).getSimboloAbr();
        }
        for (Dia dia : dias) {
            diasBloqueTexto += diasBloqueTexto.equals("") ? "" : ", ";
            diasBloqueTexto += dia.getSimboloAbr();
        }

        return diasBloqueTexto;
    }

    public String getDocentesAuxiliares() {
        if (docenteTallers == null) {
            return "";
        }
        String docentes = "";
        for (DocenteTaller docenteTaller : docenteTallers) {
            docentes = docentes.concat("\n").concat(docenteTaller.getDocente().getPersona().getApellidosNombres());
        }
        return docentes;
    }

    public List<DateTime> getListFechasAsistencia() {

        List<DateTime> dateTimes = new ArrayList<>();
        if (this.horarioTaller == null) {
            return dateTimes;
        }
        if (this.horarioTaller.isEmpty()) {
            return dateTimes;
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy hh:mm a");
        String diaHoraInicio = TypesUtil.getStringDate(this.horarioTaller.get(0).getFechaInicio(), "dd/MM/yyyy") + " " + this.horarioTaller.get(0).getHora().getDescripcion();

        DateTime diaInicio = formatter.parseDateTime(diaHoraInicio);
        DateTime diaFin = new DateTime(this.horarioTaller.get(0).getFechaFin());

        List<Dia> dias = this.horarioTaller.stream().map(x -> x.getDia()).distinct().collect(Collectors.toList());
        Collections.sort(dias, new Dia.CompareNumero());
        for (;;) {
            if (diaInicio.compareTo(diaFin) <= 0) {
                for (Dia dia : dias) {
                    if (diaInicio.getDayOfWeek() == dia.getNumeroDia()) {
                        dateTimes.add(diaInicio);
                    }
                }
                diaInicio = diaInicio.plusDays(1);
            } else {
                break;
            }
        }

        return dateTimes;
    }

    public Integer getAsistenciaDiaria() {
        if (asistenciaDiaria == null) {
            return 0;
        }
        return asistenciaDiaria;
    }

}
