package pe.edu.lamolina.model.zelper;

public class Laboratory {

    public static void mainx(String[] attrs) {
        String emailCia = "pepe.lucho@gmail.com";
        String name = emailCia.substring(0, emailCia.indexOf("@"));
        String dominio = emailCia.substring(emailCia.indexOf("@") + 1);
        System.out.println("<<" + name + ">>");
        System.out.println("<<" + dominio + ">>");
        
        String s1 = "wefwe";
        String s2 = "34345234";
        String s3 = "34345.234";
        String s4 = "34345.234ww";
        
        System.out.println("s1=" + s1 + " es-numero=" + isNumeric(s1));
        System.out.println("s2=" + s2 + " es-numero=" + isNumeric(s2));
        System.out.println("s3=" + s3 + " es-numero=" + isNumeric(s3));
        System.out.println("s4=" + s4 + " es-numero=" + isNumeric(s4));
        
    }

    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("") == false);
    }

}
