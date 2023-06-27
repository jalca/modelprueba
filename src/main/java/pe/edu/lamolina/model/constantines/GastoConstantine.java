package pe.edu.lamolina.model.constantines;

import java.util.Arrays;
import java.util.List;
import pe.edu.lamolina.model.enums.CodigoContableEnum;

public interface GastoConstantine {

    final List<CodigoContableEnum> contablesPlanilla = Arrays.asList(
            CodigoContableEnum.DIC_CLA,
            CodigoContableEnum.HON_COOR,
            CodigoContableEnum.HON_DIR_DUPG,
            CodigoContableEnum.INC_EXA_GRA,
            CodigoContableEnum.INC_EXA_ING,
            CodigoContableEnum.INC_PAT_TE,
            CodigoContableEnum.INC_SUS_TE,
            CodigoContableEnum.JUR_ADMISION,
            CodigoContableEnum.PUB_ARTICULO);

}
