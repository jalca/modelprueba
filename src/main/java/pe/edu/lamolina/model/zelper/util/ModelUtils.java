package pe.edu.lamolina.model.zelper.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.StringJoiner;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pe.albatross.zelpers.miscelanea.PhobosException;

public class ModelUtils {

    private static String FORMAT_DATE_SHORT = "yyyy-MM-dd";
    private static String FORMAT_DATE_LARGE = "yyyy-MM-dd HH:mm:ss";

    public static String toString(Object obj, String... attrs) {
        if (obj == null) {
            return null;
        }

        StringJoiner join = toStringAttr(obj, attrs);

        return join.toString();
    }

    public static void getDataByAttr(StringJoiner join, String attrName, Object attrObj, boolean mandatory) {
        if (attrObj == null) {
            if (!mandatory) {
                return;
            }
            join.add(attrName + ":" + attrObj);
            return;
        }
        if (attrObj instanceof String) {
            join.add(attrName + ":'" + attrObj + "'");
            return;
        }
        if (attrObj instanceof Date) {
            join.add(attrName + ":'" + getDateTime((Date) attrObj) + "'");
            return;
        }

        String clazz = attrObj.getClass().getSimpleName();
        if (!noPuedeLeerse(clazz)) {
            join.add(attrName + ":" + attrObj);
        }
    }

    public static void getDataByAttr(StringJoiner join, String attrName, Object attrObj) {
        getDataByAttr(join, attrName, attrObj, true);
    }

    public static void getDataByAttrObject(StringJoiner join, String attrName, Object attrObj, String... attrs) {
        if (attrObj == null) {
            return;
        }

        StringJoiner joinAttr = toStringAttr(attrObj, attrs);

        if (joinAttr != null) {
            join.add(attrName + "=" + joinAttr.toString());
        }
    }

    private static String getDateTime(Date value) {
        Date d1 = new LocalDate(value.getTime()).toDate();
        Date d2 = new DateTime(value.getTime()).toDate();

        if (d1.getTime() == d2.getTime()) {
            return new DateTime((Date) value).toString(FORMAT_DATE_SHORT);
        } else {
            return new DateTime((Date) value).toString(FORMAT_DATE_LARGE);
        }
    }

    private static StringJoiner toStringAttr(Object attrObj, String... attrs) {
        String clazz = attrObj.getClass().getSimpleName();
        if (noPuedeLeerse(clazz)) {
            return null;
        }

        StringJoiner join = new StringJoiner(", ", attrObj.getClass().getSimpleName() + "{", "}");

        for (String attr : attrs) {
            boolean noExiste = true;
            for (Field f : attrObj.getClass().getDeclaredFields()) {
                if (f.getName().equals(attr)) {
                    noExiste = false;
                    try {
                        f.setAccessible(true);
                        Object value = f.get(attrObj);
                        ModelUtils.getDataByAttr(join, attr, value);
                    } catch (IllegalArgumentException ex) {
                    } catch (IllegalAccessException ex) {
                    }
                    break;
                }
            }
            if (noExiste) {
                throw new PhobosException("No existe el attr " + attr + " para la clase " + attrObj.getClass().getSimpleName());
            }
        }
        return join;
    }

    public static boolean noPuedeLeerse(String string) {
        if (string.contains("$$")) {
            return true;
        }
        if (string.contains("$")) {
            return true;
        }
        return false;
    }

}
