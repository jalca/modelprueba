package pe.edu.lamolina.model.constantines;

import pe.albatross.zelpers.miscelanea.OSValidator;
import static pe.edu.lamolina.model.constantines.GlobalConstantine.S3_URL_BASE;

public interface NetworkingConstantine {

    String CODIGO_SISTEMA = "NETWORKING";

    String CODIGO_UNALM = "160000007";

    String S3_BUCKET_NETWORKING = "lamolina-networking";

    String S3_LINK_NETWORKING = S3_URL_BASE + S3_BUCKET_NETWORKING;

    String PERFIL_SUBDIR = "profile/";
    String EMPRESA_SUBDIR = "company/";
    String UNIVERSIDAD_SUBDIR = "university/";
    
    String PERFIL_PRIVADO = "/admin/empleos/interesado/perfil/";

    String FILE_DIR = OSValidator.isWindows() ? "C:\\nw\\" : "/tmp/";

    String[] CODE_ALUMNOS = {"N", "A", "1", "2", "3", "4", "5", "6", "8", "9", "Y", "U", "3U", "MD", "2U", "Q", "XD", "4U", "6B", "6U", "T", "TU"};

    String[] CODE_NO_ALUMNOS = {"7", "X"};
    
    String[] CODE_DESERTOR = {"D"};

    String[] CODE_EGRESADOS = {"E", "EM", "G"};

    Long ID_PORTAL_EGRESADO = 3L;
    
    Long ID_EMPRESA_AGRARIA = 9L;

}
