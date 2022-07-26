package mx.com.paquetexpress.properties;

import java.io.Serializable;

public enum TypePropertiesConstants implements Serializable {

    EADREST(0), PRINCIPAL(1), APIEAD(2);
    private final int type;

    TypePropertiesConstants(int clasificacion) {
        this.type = clasificacion;
    }

    public int getType() {
        return type;
    }

    public static TypePropertiesConstants getEnum(int clasificador) {
        if (EADREST.getType() == clasificador) {
            return EADREST;
            }else if (PRINCIPAL.getType() == clasificador) {
             return PRINCIPAL;
        } else if (APIEAD.getType() == clasificador) {
            return APIEAD;
        }
        throw new IllegalArgumentException("No Enum specified for this string");
    }
}
