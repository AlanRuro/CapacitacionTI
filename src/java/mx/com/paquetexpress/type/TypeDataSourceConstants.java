package mx.com.paquetexpress.type;

import java.io.Serializable;

public enum TypeDataSourceConstants implements Serializable {

    AUD(1);
    private final int type;

    TypeDataSourceConstants(int clasificacion) {
        this.type = clasificacion;
    }

    public int getType() {
        return type;
    }

    public static TypeDataSourceConstants getEnum(int clasificador) {
        if (AUD.getType() == clasificador) {
            return AUD;
        }
        throw new IllegalArgumentException("No Enum specified for this string");
    }
}
