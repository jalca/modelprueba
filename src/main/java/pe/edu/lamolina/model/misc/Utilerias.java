package pe.edu.lamolina.model.misc;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

public class Utilerias {

    static long milisegundos_dia = 24 * 60 * 60 * 1000;

    public static Date getPrimerDiaDelMes() {

        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));

        return cal.getTime();

    }

    public static Date getUltimoDiaDelMes() {

        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));

        return cal.getTime();

    }

    public static Period getEdadPersona(Date fecha) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNaci = sdf.format(fecha);
        LocalDate fechaNac = LocalDate.parse(fechaNaci, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate ahora = LocalDate.now();

        return Period.between(fechaNac, ahora);
    }

    public static Date sumarRestarDiasFecha(Date fecha, int dias) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }

    public static String getFechaContrato(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String f = sdf.format(fecha);
        sdf = new SimpleDateFormat("MMMM");
        f = f.concat(" de ").concat(sdf.format(fecha));
        sdf = new SimpleDateFormat("yyyy");
        f = f.concat(" del ").concat(sdf.format(fecha));
        return f;
    }

    public static Date getStringToDate(String fecha, String formato) {

        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        try {
            return sdf.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Integer diasEntreFechas(Date fechaMayor, Date fechaMenor) {

        long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

    public static long diasEntreFechas2(Date fechaMayor, Date fechaMenor) {

        long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEn_ms / (1000 * 60 * 60);
        if (dias < 0) {
            dias = dias * -1;
        }
        return dias;
    }

    public static int calcularMeses(Date fechaInicio, Date fechaFin) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String f1 = sdf.format(fechaInicio);
            String f2 = sdf.format(fechaFin);

            String[] aF1 = f1.split("/");
            String[] aF2 = f2.split("/");

            int numMeses = Integer.parseInt(aF2[2]) * 12 + Integer.parseInt(aF2[1]) - (Integer.parseInt(aF1[2]) * 12 + Integer.parseInt(aF1[1]));
            if (Integer.parseInt(aF2[0]) < Integer.parseInt(aF1[0])) {
                numMeses = numMeses - 1;
            }
            return numMeses;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static long diferenciaHorasDias(Calendar fechaInicial, Calendar fechaFinal) {

        long diferenciaHoras = 0;
        diferenciaHoras = (fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis());
        if (diferenciaHoras > 0) {
            diferenciaHoras = diferenciaHoras * 24;
        }
        return diferenciaHoras;
    }

    public static long diferenciaMinutos(Calendar fechaInicial, Calendar fechaFinal) {

        long totalMinutos = 0;
        totalMinutos = (fechaFinal.get(Calendar.MINUTE) - fechaInicial.get(Calendar.MINUTE));
        if (totalMinutos < 0) {
            totalMinutos = totalMinutos * -1;
        }
        return totalMinutos;
    }

    public static long cantidadTotalMinutos(Calendar fechaInicial, Calendar fechaFinal) {

        long totalMinutos = 0;
        totalMinutos = ((fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis()) / 1000 / 60);
        return totalMinutos / 60;
    }

    public static long cantidadTotalHoras(Calendar fechaInicial, Calendar fechaFinal) {

        long totalMinutos = 0;
        totalMinutos = ((fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis()) / 1000 / 60 / 60);
        return totalMinutos;
    }

    public static long cantidadTotalSegundos(Calendar fechaInicial, Calendar fechaFinal) {

        long totalMinutos = 0;
        totalMinutos = ((fechaFinal.getTimeInMillis() - fechaInicial.getTimeInMillis()) / 1000);
        return totalMinutos;
    }

    public static long diferenciaHoras(Calendar fechaInicial, Calendar fechaFinal) {
        long diferenciaHoras = 0;
        diferenciaHoras = (fechaFinal.get(Calendar.HOUR_OF_DAY) - fechaInicial.get(Calendar.HOUR_OF_DAY));
        return diferenciaHoras;
    }

    public static String getProperty(String propertiesFile, String key) {

        String response = null;
        try {
            Properties properties = new Properties();
            InputStream in = new FileInputStream(propertiesFile);
            properties.load(in);
            response = properties.getProperty(key);

        } catch (Exception e) {
            System.out.println("Utils]getProperties: No se encuentra el archivo:" + response);
        }
        return response;
    }

    public static List<Date> calcularFechas(Date fechaInicio, Date fechaFin, Integer cantidad) {

        List<Date> lista = new ArrayList<Date>();
        Double totalDias = new Double(Utilerias.diasEntreFechas(fechaFin, fechaInicio));

        Double dias = Math.ceil(totalDias / cantidad);
        Date fecha1 = Utilerias.sumarRestarDiasFecha(fechaInicio, dias.intValue());
        Date fecha = fecha1;
        lista.add(fecha1);

        for (int i = 2; i < cantidad; i++) {
            fecha = Utilerias.sumarRestarDiasFecha(fecha, dias.intValue());
            lista.add(fecha);
        }

        lista.add(fechaFin);

        return lista;
    }

    public static void notifyWindows(String mensaje) {

        try {
            TrayIcon icono = new TrayIcon(getImagen(), "Mensajeria IEP"); //, crearMenu());
            SystemTray.getSystemTray().add(icono);
            Thread.sleep(3000);

            icono.displayMessage("Mensaje", mensaje, TrayIcon.MessageType.INFO);
        } catch (AWTException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static Image getImagen() {
        Image img = Toolkit.getDefaultToolkit().getImage("C:/icono.png");
        return img;
    }

    public static PopupMenu crearMenu() {
        PopupMenu menu = new PopupMenu();
        MenuItem salir = new MenuItem("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(salir);
        return menu;

    }

    public static Boolean diaHabil(Date fecha) {

        Boolean flag = true;
        Calendar dia = Calendar.getInstance();
        dia.setTime(fecha);

        Integer day = dia.get(Calendar.DAY_OF_WEEK);

        if (day.compareTo(Calendar.SATURDAY) == 0 || day.compareTo(Calendar.SUNDAY) == 0) {
            flag = false;
        }
        return flag;
    }

    public static Integer diasMes(Date fecha) {
        Calendar dia = Calendar.getInstance();
        dia.setTime(fecha);
        return dia.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Integer diasHabilesEntreFechas(Integer mes, Integer agno, Integer periodoLaboral) {

        Integer dias = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Integer ultimoDia = diasMes(new Date("01/" + mes + "/" + agno));
        Calendar fechaInicial = new GregorianCalendar(agno, mes - 1, 1);
        Calendar fechaFinal = new GregorianCalendar(agno, mes - 1, ultimoDia);

        while (fechaInicial.before(fechaFinal) || fechaInicial.equals(fechaFinal)) {

            if (fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
                    && fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                dias++;
            }
            fechaInicial.add(Calendar.DATE, 1);
        }

        return dias;
    }

    public static Boolean validarCamposVacios(Object pObjeto) {
        Boolean status = false;
        Method metodos[] = pObjeto.getClass().getMethods();
        for (int i = 0; i < metodos.length; i++) {
            Method metodo = metodos[i];
            //Si es un metodo get o is lo utilizo con su equivalente set
            if ((metodo.getName().substring(0, 3).equalsIgnoreCase("get") || metodo.getName().substring(0, 2).equalsIgnoreCase("is")) && !metodo.getName().equals("getClass")) {
                String methodNameSet = "";
                if (metodo.getName().substring(0, 3).equalsIgnoreCase("get")) {
                    methodNameSet = metodo.getName().replaceFirst("get", "set");
                } else {
                    methodNameSet = methodNameSet.replaceFirst("is", "set");
                }
                try {
                    Method metodoSet = pObjeto.getClass().getMethod(methodNameSet, metodo.getReturnType());
                    if (metodoSet != null) {
                        //Si es Boolean
                        if (metodo.getReturnType().equals(java.lang.Boolean.class)) {
                            Boolean valor = (Boolean) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                        //Si es byte
                        if (metodo.getReturnType().equals(java.lang.Byte.class)) {
                            Byte valor = (Byte) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                        //Si es bigDecimal
                        if (metodo.getReturnType().equals(java.math.BigDecimal.class)) {
                            BigDecimal valor = (BigDecimal) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                        //Si es Integer
                        if (metodo.getReturnType().equals(java.lang.Integer.class)) {
                            Integer valor = (Integer) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                        //Si es Long
                        if (metodo.getReturnType().equals(java.lang.Long.class)) {
                            Long valor = (Long) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                        // Si es Float
                        if (metodo.getReturnType().equals(java.lang.Float.class)) {
                            Float valor = (Float) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                        // Si es Double
                        if (metodo.getReturnType().equals(java.lang.Double.class)) {
                            Double valor = (Double) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                        //Si es un string
                        if (metodo.getReturnType().equals(java.lang.String.class)) {
                            String valor = (String) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                        //Si es date
                        if (metodo.getReturnType().equals(java.util.Date.class)) {
                            Date valor = (Date) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                System.out.println("metodo name: " + metodo.getName());
                                status = true;
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return status;
    }

    public static Object validarCampos(Object pObjeto) {

        Object objeto = pObjeto;
        Method metodos[] = pObjeto.getClass().getMethods();
        for (int i = 0; i < metodos.length; i++) {
            Method metodo = metodos[i];
            //Si es un metodo get o is lo utilizo con su equivalente set
            if ((metodo.getName().substring(0, 3).equalsIgnoreCase("get") || metodo.getName().substring(0, 2).equalsIgnoreCase("is")) && !metodo.getName().equals("getClass")) {
                String methodNameSet = "";
                if (metodo.getName().substring(0, 3).equalsIgnoreCase("get")) {
                    methodNameSet = metodo.getName().replaceFirst("get", "set");
                } else {
                    methodNameSet = methodNameSet.replaceFirst("is", "set");
                }
                try {
                    Method metodoSet = pObjeto.getClass().getMethod(methodNameSet, metodo.getReturnType());
                    if (metodoSet != null) {
                        //Datos numericos
                        //Si es byte
                        if (metodo.getReturnType().equals(java.lang.Byte.class)) {
                            Byte valor = (Byte) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                metodoSet.invoke(pObjeto, 0);
                            }
                        }
                        //Si es bigDecimal
                        if (metodo.getReturnType().equals(java.math.BigDecimal.class)) {
                            BigDecimal valor = (BigDecimal) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                metodoSet.invoke(pObjeto, new BigDecimal(0));
                            }
                        }
                        // Si es Double
                        if (metodo.getReturnType().equals(java.lang.Double.class)) {
                            Double valor = (Double) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                metodoSet.invoke(pObjeto, new Double(0));
                            }
                        }
                        //Si es un string
                        if (metodo.getReturnType().equals(java.lang.String.class)) {
                            String valor = (String) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                metodoSet.invoke(pObjeto, "");
                            }
                        }
                        //Si es una lista
                        if (metodo.getReturnType().equals(java.util.List.class)) {
                            List objetosList = (List) metodo.invoke(pObjeto, new Object[0]);
                            for (Object objetoFromList : objetosList) {
                                Utilerias.validarCampos(objetoFromList);
                            }
                        }
                        //Si es date
                        if (metodo.getReturnType().equals(java.util.Date.class)) {
                            Date valor = (Date) metodo.invoke(pObjeto, new Object[0]);
                            if (valor == null) {
                                metodoSet.invoke(pObjeto, new Date());
                            }
                        }
                        //Si es primitivo
                        if (metodo.getReturnType().isPrimitive()) {
                            //los primitivos no permiten null
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return objeto;
    }

    public static String validacionDocItendidadBCP(String idDocumento) {
        String id = null;
        switch (idDocumento) {
            case "1":
                id = "1";
                break;
            case "2":
                id = "6";
                break;
            case "4":
                id = "3";
                break;
            case "3":
                id = "4";
                break;
            case "5":
                id = "7";
                break;
        }
        return id;
    }

    public static byte[] loadImage64(String url) throws Exception {

        File file = new File(url.toString());
        if (file.exists()) {
            int lenght = (int) file.length();
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[lenght];
            reader.read(bytes, 0, lenght);
            reader.close();
            return bytes;
        } else {
            System.out.println("Recurso no encontrado");
            return null;
        }
    }
}
