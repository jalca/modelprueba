package pe.edu.lamolina.model.constantines;

public interface GlobalMessages {

    // ACTUALIZACIONES
    String UPDATED = "Registro actualizado";

    String CREATED = "Registro agregado.";

    String DELETED = "Registro eliminado";

    String UPLOAD_SUCCESS = "Carga satisfactoria del archivo";

    // ACTUALIZACIONES DE ESTADO
    String ACTIVATED = "Registro activado";

    String INACTIVATED = "Registro inactivado";

    String APPROVED = "Registro aprobado";

    String DISAPPROVE = "Registro desaprobado";

    String REJECT = "Registro rechazado";

    String ANNULL = "Registro Anulado";

    String OBSERVED = "Registro Observado";

    // SESION
    String MENSAJE_SIN_SESSION = "Lo sentimos, su sesión caducó o no se encuentra logueado. Ingrese nuevamente al sistema.";

    // ERRORES
    String ERROR_GENERAL = "Esto es inoportuno pero se ha generado un problema desconocido. Por favor reporte al correo soporte@albatross.pe";

    String UNKNOWN = "Registro no identificado en la base de datos.";

    String ERROR_NOT_EDIT = "No tiene permiso de edición";

    String FORBIDEN = "No se encuentra autorizado para realizar esta operación";

    String FK_ERROR_UPDATE = "Imposible modificar, el registro está  relacionado con otros registros.";

    String FK_ERROR_DELETE = "Imposible eliminar, el registro está relacionado con otros registros.";

}
