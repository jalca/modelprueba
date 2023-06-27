package pe.edu.lamolina.model.enums.croacia;

import java.util.HashMap;
import java.util.Map;
import pe.edu.lamolina.model.enums.ConceptoPosgradoEnum;

public enum ConceptoDeudaEnum {
    MAT("MATRICULA", ConceptoPosgradoEnum.MAT),
    ENZ("ENSEÑANZA", ConceptoPosgradoEnum.ENZ),
    XTM("EXTEMPORANEO", ConceptoPosgradoEnum.XTM);

    private final String value;
    private final ConceptoPosgradoEnum conceptoPosgradoEnum;
    private static final Map<String, ConceptoDeudaEnum> lookup = new HashMap<>();

    static {
        for (ConceptoDeudaEnum d : ConceptoDeudaEnum.values()) {
            lookup.put(d.getValue(), d);
        }
    }

    private ConceptoDeudaEnum(String value, ConceptoPosgradoEnum conceptoPosgradoEnum) {
        this.value = value;
        this.conceptoPosgradoEnum = conceptoPosgradoEnum;
    }

    public String getValue() {
        return value;
    }

    public ConceptoPosgradoEnum getConceptoPosgradoEnum() {
        return conceptoPosgradoEnum;
    }

}
