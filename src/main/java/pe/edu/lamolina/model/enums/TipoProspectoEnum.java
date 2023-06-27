package pe.edu.lamolina.model.enums;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public enum TipoProspectoEnum implements IHasID<Long>, IHasDisplayName {
    regular(0L, "000"),
    conexamen(1L, "001"),
    sinexamen(2L, "002"),
    examenvirtual(3L,"003");

    private final Long idEnum;
    private final String display;

    private TipoProspectoEnum(@Nonnull @Nonempty final Long id, @Nonnull final String descripcion) {
        idEnum = id;
        display = descripcion;
    }

    @Nonnull
    @Nonempty
    public Long getID() {
        return idEnum;
    }

    @Nonnull
    public String getDisplayName() {
        return display;
    }

    @Nullable
    public static TipoProspectoEnum getFromIDOrNull(@Nullable final Long sID) {
        return EnumHelper.getFromIDOrNull(TipoProspectoEnum.class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final Long sID) {
        final TipoProspectoEnum eValue = TipoProspectoEnum.getFromIDOrNull(sID);
        return ((eValue == null) ? null : eValue.getDisplayName());
    }
}
